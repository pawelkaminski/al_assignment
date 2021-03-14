package al.assignment.manager;

import al.assignment.symbolprocessor.SymbolProcessor;
import al.assignment.utils.ClientAddress;
import al.assignment.utils.MessagesToClientQueue;
import al.assignment.utils.WebSocketMessagesQueue;
import al.assignment.websocket.WebsocketSubscriber;
import org.java_websocket.client.WebSocketClient;

import java.util.HashSet;
import java.util.Set;

public class SymbolProcessingManager {
    private final Set<ClientAddress> clients;
    private WebSocketClient subscriber;
    private SymbolProcessor processor;

    public SymbolProcessingManager() {
        this.clients = new HashSet<>();
    }

    public void createClientProcessing(String symbol) {
        WebSocketMessagesQueue websocketQueue = new WebSocketMessagesQueue();
        processor = new SymbolProcessor(symbol, websocketQueue);
        processor.start();
        subscriber = new WebsocketSubscriber(symbol, websocketQueue);
        subscriber.connect();
    }

    public void addClient(ClientAddress address, MessagesToClientQueue queue) {
        processor.addClient(address, queue);
        clients.add(address);
    }

    public void removeClient(ClientAddress client) {
        processor.removeClient(client);
        clients.remove(client);
    }

    public void close() throws InterruptedException {
        subscriber.closeBlocking();
        processor.terminate();
        processor.interrupt();
        processor.join();
    }

    public boolean isUsed() {
        return !clients.isEmpty();
    }
}
