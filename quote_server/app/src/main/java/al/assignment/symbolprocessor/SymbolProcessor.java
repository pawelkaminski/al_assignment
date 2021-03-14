package al.assignment.symbolprocessor;

import al.assignment.consumer.grpc.Book;
import al.assignment.consumer.grpc.Trade;
import al.assignment.utils.ClientAddress;
import al.assignment.utils.MessageToClient;
import al.assignment.utils.MessagesToClientQueue;
import al.assignment.utils.WebSocketMessagesQueue;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;


public class SymbolProcessor extends Thread {
    private final WebSocketMessagesQueue queue;
    private final String symbol;
    private Long firstSequenceID;
    private final JSONParser parser;
    private volatile boolean active;
    private final OrderBook book;
    private final Map<ClientAddress, MessagesToClientQueue> consumerMap;
    private final ArrayBlockingQueue<ClientUpdateData> clientUpdates;

    public SymbolProcessor(String symbol, WebSocketMessagesQueue queue) {
        this.queue = queue;
        this.symbol = symbol;
        this.parser = new JSONParser();
        this.book = new OrderBook();
        this.consumerMap = new HashMap<>();
        this.clientUpdates = new ArrayBlockingQueue<>(100);
        this.active = true;
    }

    public void removeClient(ClientAddress client) {
        clientUpdates.add(new ClientUpdateData(client));
    }

    public void addClient(ClientAddress client, MessagesToClientQueue queue) {
        clientUpdates.add(new ClientUpdateData(client, queue));
    }

    public void terminate() {
        active = false;
    }

    public void run() {
        prepareInitialBook();
        runQueueProcessing();
    }

    private void prepareInitialBook() {
        // We want to ensure that first message is taken from websocket (first message is a subscribe message)
        try {
            queue.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String response = WebCurrentBook.getCurrentWeb(symbol);
        storeWebResponse(response);
    }

    private void storeWebResponse(String response) {
        JSONObject cleanedMessage = null;
        try {
            cleanedMessage = (JSONObject) parser.parse(response);
        } catch (ParseException exception) {
            exception.printStackTrace();
        }

        putMessages(false, (JSONArray) cleanedMessage.get("asks"));
        putMessages(true, (JSONArray) cleanedMessage.get("bids"));
        firstSequenceID = (Long) cleanedMessage.get("sequence");
    }

    private void putMessages(boolean side, JSONArray ordersList) {
        for (Object val: ordersList) {
            JSONArray arr = (JSONArray) val;
            book.put((String) arr.get(2), new Order(
                    side,
                    (String) arr.get(0),
                    (String) arr.get(1)
            ));
        }
    }

    private void runQueueProcessing() {
        System.out.printf("STARTED PROCESSING  %s\n", symbol);
        try {
            while (active) {
                update();
                consume(queue.take());
            }
        } catch (InterruptedException ex) {
            System.out.printf("CALLED INTERRUPTION %s\n", symbol);
        }
    }

    private void update() throws InterruptedException {
        while (!clientUpdates.isEmpty()) {
            ClientUpdateData clientUpdate = clientUpdates.take();
            if (clientUpdate.isDelete) {
                deleteClientQueue(clientUpdate);
            } else {
                addClientQueue(clientUpdate);
            }
        }
    }

    private void deleteClientQueue(ClientUpdateData clientUpdate) {
        consumerMap.remove(clientUpdate.client);
        System.out.printf("DELETED CLIENT %s AT SYMBOL PROCESSING %s \n", clientUpdate.client.getUrl(), symbol);
    }

    private void addClientQueue(ClientUpdateData clientUpdate) {
        if (consumerMap.containsKey(clientUpdate.client)) {
            return;
        }
        consumerMap.put(clientUpdate.client, clientUpdate.queue);
        propagateCurrentBook(clientUpdate.queue);
        System.out.printf("ADDED CLIENT %s AT SYMBOL PROCESSING %s \n", clientUpdate.client.getUrl(), symbol);
    }

    private void propagateCurrentBook(MessagesToClientQueue queue) {
        for (Book bookMessage: book.prepareBookMessages(symbol)) {
            queue.add(new MessageToClient(bookMessage));
        }
    }

    private void consume(String message) {
        JSONObject cleanedMessage;
        try {
            cleanedMessage = (JSONObject) parser.parse(message);
        } catch (ParseException exception) {
            exception.printStackTrace();
            return;
        }

        if (!cleanedMessage.containsKey("type") || (Long) cleanedMessage.get("sequence") <= firstSequenceID) {
            return;
        }

        switch ((String) cleanedMessage.get("type")) {
            case "open":
                processOpen(cleanedMessage);
                return;
            case "done":
                processDone(cleanedMessage);
                return;
            case "match":
                processMatch(cleanedMessage);
        }

    }

    private void processOpen(JSONObject cleanedMessage) {
        Order order = new Order(
                (cleanedMessage.get("side")).equals("buy"),
                (String) cleanedMessage.get("price"),
                (String) cleanedMessage.get("remaining_size")
        );
        String orderId = (String) cleanedMessage.get("order_id");
        book.put(orderId, order);
        propagateMessages(new MessageToClient(order.getBookProto(symbol,orderId, false)));
    }


    private void processDone(JSONObject cleanedMessage) {
        String orderId = (String) cleanedMessage.get("order_id");
        Order order = book.remove(orderId);

        if (order == null) {
            return;
        }

        propagateMessages(new MessageToClient(order.getBookProto(symbol, orderId, true)));
    }

    private void processMatch(JSONObject cleanedMessage) {
        propagateMessages(prepareTradeMessage(cleanedMessage));
        String size = (String) cleanedMessage.get("size");

        for (String key: new String[]{"maker_order_id","taker_order_id"}) {
            String orderId = (String) cleanedMessage.get(key);
            if (!book.containsKey(orderId)) {
                continue;
            }
            Order order = book.get(orderId);
            order.decreaseQuantity(size);
            propagateMessages(new MessageToClient(order.getBookProto(symbol, orderId, false)));
        }
    }

    private void propagateMessages(MessageToClient message) {
        for (var queue: consumerMap.values()) {
            queue.add(message);
        }
    }

    private MessageToClient prepareTradeMessage(JSONObject cleanedMessage) {
        Trade.Builder builder = Trade.newBuilder()
            .setSymbol(symbol)
            .setIsBuy(cleanedMessage.get("side")
            .equals("buy"))
            .setPrice((String) cleanedMessage.get("price"))
            .setQuantity((String) cleanedMessage.get("size"));
        return new MessageToClient(builder.build());
    }

}
