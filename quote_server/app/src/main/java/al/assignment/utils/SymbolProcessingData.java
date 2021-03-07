package al.assignment.utils;

import al.assignment.symbolprocessor.SymbolProcessor;
import org.java_websocket.client.WebSocketClient;

import java.util.HashSet;
import java.util.Set;

public class SymbolProcessingData {
    Set<ClientAddress> clients;
    WebSocketClient subscriber;
    SymbolProcessor processor;

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

}
