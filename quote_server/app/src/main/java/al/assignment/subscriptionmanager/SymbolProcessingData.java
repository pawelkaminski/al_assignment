package al.assignment.subscriptionmanager;

import al.assignment.symbolprocessor.SymbolProcessor;
import al.assignment.utils.ClientAddress;
import org.java_websocket.client.WebSocketClient;

import java.util.HashSet;
import java.util.Set;

public class SymbolProcessingData {
    public Set<ClientAddress> clients;
    private final WebSocketClient subscriber;
    public SymbolProcessor processor;

    public SymbolProcessingData(SymbolProcessor processor, WebSocketClient subscriber) {
        this.processor = processor;
        this.subscriber = subscriber;
        this.clients = new HashSet<>();
    }

    public void addClient(ClientAddress client) {
        clients.add(client);
    }

    public void removeClient(ClientAddress client) {
        clients.remove(client);
    }

    public void deleteProcessor() throws InterruptedException {
        subscriber.closeBlocking();
        processor.terminate();
        processor.join();
    }
}
