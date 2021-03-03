package al.assignment.symbolprocessor;

import al.assignment.utils.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;


public class SymbolProcessor implements Runnable {
    private final WebSocketQueue queue;
    private final String symbol;
    private Long firstsequenceID;
    private JSONParser parser;

    private OrderBook book;
    private Map<ClientAddress, MessagesToClientQueue> consumerMap;

    public SymbolProcessor(String symbol, WebSocketQueue queue) {
        this.queue = queue;
        this.symbol = symbol;
        this.parser = new JSONParser();
        this.book = new OrderBook();
        this.consumerMap = new HashMap<>();
    }

    public void run() {
        prepareInitialBook();
        runQueueProcessing();
    }

    private void prepareInitialBook() {
        // We want to ensure that firs message is taken from websocket (first message is subscribe message
        try {
            queue.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String response = getWebResponse();
        storeWebResponse(response);
    }

    private String getWebResponse() {
        // TODO(pawelk): ugly uri creator
        String uri = "https://api.pro.coinbase.com/products/" + symbol + "/book?level=3";

        HttpsURLConnection con = null;
        try {
            URL url = new URL(uri);
            con = (HttpsURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line).append("\n");
            }
            br.close();
            return sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (con != null) {
                try {
                    con.disconnect();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
        // TODO(pawelk): process exception
        return "";
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
        firstsequenceID = (Long) cleanedMessage.get("sequence");
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
        try {
            while (true) {
                consume(queue.take());
            }
        } catch (InterruptedException ex) {
            ex.printStackTrace();
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

        if (!cleanedMessage.containsKey("type")) {
            return;
        }

        if ((Long) cleanedMessage.get("sequence") <= firstsequenceID) {
            return;
        }

        if (cleanedMessage.get("type").equals("open")) {
            book.put((String) cleanedMessage.get("order_id"), new Order(
                    (cleanedMessage.get("side")).equals("buy"),
                    (String) cleanedMessage.get("price"),
                    (String) cleanedMessage.get("remaining_size")
            ));
            //TODO(pawelk): add message to rpc queue
            return;
        }

        if (cleanedMessage.get("type").equals("done")) {
            book.remove((String) cleanedMessage.get("order_id"));
            //TODO(pawelk): add message to rpc queue
            return;
        }

        if (cleanedMessage.get("type").equals("match")) {
            String size = (String) cleanedMessage.get("size");

            for (String key: new String[]{"maker_order_id","taker_order_id"}) {
                if (!book.containsKey((String) cleanedMessage.get(key))) {
                    continue;
                }
                book.get((String) cleanedMessage.get(key)).decreaseQuantity(size);
            }

            //TODO(pawelk): add message to rpc queue with trade & update book
            return;
        }
    }

}
