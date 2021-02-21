package al.assignment;

import al.assignment.websocketsubscriber.*;
import al.assignment.symbolprocessor.SybmbolProcessor;
import org.java_websocket.client.WebSocketClient;

import java.util.concurrent.ArrayBlockingQueue;

public class QuoteServer {

    public static void main(String[] args) {
        // mock run

        ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<String>(100000);
        SybmbolProcessor processor = new SybmbolProcessor("ETH-USD", queue);
        new Thread(processor).start();
        WebSocketClient client = new WebsocketSubscriber("ETH-USD", queue);
        client.connect();
    }

}
