package al.assignment;

import org.java_websocket.client.WebSocketClient;

import al.assignment.websocketsubscriber.WebsocketSubscriber;
import al.assignment.symbolprocessor.SymbolProcessor;
import al.assignment.utils.WebSocketQueue;

public class QuoteServer {

    public static void main(String[] args) {
        // mock run
        WebSocketQueue queue = new WebSocketQueue();
        SymbolProcessor processor = new SymbolProcessor("ETH-USD", queue);
        new Thread(processor).start();
        WebSocketClient client = new WebsocketSubscriber("ETH-USD", queue);
        client.connect();
    }

}
