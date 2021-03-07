package al.assignment;

import al.assignment.quote.sender.ClientRPCSender;
import al.assignment.quote.subscribtion.QuoteSubscriptionServer;
import al.assignment.symbolprocessor.SymbolProcessor;
import al.assignment.utils.*;
import al.assignment.websocketsubscriber.WebsocketSubscriber;
import org.java_websocket.client.WebSocketClient;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class QuoteServer {
    private static QuoteSubscriptionServer RPCServer;
    private static SubscriptionUpdatesQueue queue;
    private static HashMap<ClientAddress, ClientProcessingData> clientProcessingMap;
    private static HashMap<String, SymbolProcessingData> symbolProcessingMap;

    public static void main(String[] args) throws IOException, InterruptedException {
        startRPCServer();
        prepareProcessingSubscriptions();
        updateSubscriptions();
    }

    private static void startRPCServer() throws IOException {
        RPCServer = new QuoteSubscriptionServer();
        queue = new SubscriptionUpdatesQueue();
        RPCServer.start(queue);
    }

    private static void prepareProcessingSubscriptions() {
        symbolProcessingMap = new HashMap<>();
        clientProcessingMap = new HashMap<>();
    }

    private static void updateSubscriptions() {
        try {
            while (true) {
                consume(queue.take());
            }
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    private static void consume(SubscriptionUpdate update) {
        if (update.isUnsubscribe) {
            removeClient(update.clientAddress);
            return;
        }
        updateClient(update.clientAddress, update.symbols);
    }

    private static void removeClient(ClientAddress address){
        if (!clientProcessingMap.containsKey(address)) {
            return;
        }

        ClientProcessingData data = clientProcessingMap.get(address);
        data.getSender().terminate();
        for (String symbol: data.getSymbols()) {
            if (!symbolProcessingMap.containsKey(symbol)){
                continue;
            }

            // TODO(pawelk): terminate user
            symbolProcessingMap.get(symbol);
        }
        // TODO(pawelk): remove from sub

    }

    private static void updateClient(ClientAddress address, List<String> symbols) {
        if (!clientProcessingMap.containsKey(address)) {
            MessagesToClientQueue queue = new MessagesToClientQueue();
            ClientRPCSender sender = new ClientRPCSender(queue, address);
            sender.start();
            clientProcessingMap.put(address, new ClientProcessingData(sender, queue));
        }
        System.out.println("CREATED CLIENT " + address.getUrl() + symbols.toString());

        MessagesToClientQueue queue = clientProcessingMap.get(address).getQueue();

        for (String symbol: symbols) {
            if (symbolProcessingMap.containsKey(symbol)) {
                continue;
            }

            WebSocketQueue websocketQueue = new WebSocketQueue();
            SymbolProcessor processor = new SymbolProcessor(symbol, websocketQueue, address, queue);
            processor.start();
            System.out.println("CREATED procesor " + address.getUrl() + symbols.toString());

            WebSocketClient client = new WebsocketSubscriber(symbol, websocketQueue);
            client.connect();

            System.out.println("CREATED websocket " + address.getUrl() + symbols.toString());

            symbolProcessingMap.put(symbol, new SymbolProcessingData(processor, client));

            //create if not there + update
        }

        // diff
    }

}
