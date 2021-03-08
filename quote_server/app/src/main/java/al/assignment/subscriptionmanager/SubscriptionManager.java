package al.assignment.subscriptionmanager;

import al.assignment.symbolprocessor.SymbolProcessor;
import al.assignment.utils.*;
import al.assignment.websocketsubscriber.WebsocketSubscriber;
import org.java_websocket.client.WebSocketClient;

import java.util.HashMap;
import java.util.List;

public class SubscriptionManager {
    private final HashMap<ClientAddress, ClientProcessingData> clientProcessingMap;
    private final HashMap<String, SymbolProcessingData> symbolProcessingMap;
    private final SubscriptionUpdatesQueue queue;

    public SubscriptionManager(SubscriptionUpdatesQueue queue) {
        this.queue = queue;
        this.symbolProcessingMap = new HashMap<>();
        this.clientProcessingMap = new HashMap<>();
    }

    public void run() {
        try {
            while (true) {
                consume(queue.take());
            }
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    private void consume(SubscriptionUpdate update) throws InterruptedException {
        if (update.isUnsubscribe || update.symbols.isEmpty()) {
            removeAllSubscriptions(update.clientAddress);
            return;
        }
        updateSubscriptions(update.clientAddress, update.symbols);
    }

    void removeAllSubscriptions(ClientAddress address) throws InterruptedException {
        if (!clientProcessingMap.containsKey(address)) {
            return;
        }

        for (String symbol: clientProcessingMap.get(address).getSymbols()) {
            symbolProcessingMap.get(symbol).processor.removeClient(address);
            symbolProcessingMap.get(symbol).clients.remove(address);
            if (symbolProcessingMap.get(symbol).clients.isEmpty()) {
                symbolProcessingMap.get(symbol).deleteProcessor();
                symbolProcessingMap.remove(symbol);
                System.out.printf("CLOSED SYMBOL PROCESSOR %s \n", symbol);
            }
        }

        ClientProcessingData data = clientProcessingMap.get(address);
        data.getSender().terminate();
        data.getSender().join();
        clientProcessingMap.remove(address);
    }

    void updateSubscriptions(ClientAddress address, List<String> symbols) throws InterruptedException {

        if (!clientProcessingMap.containsKey(address)) {
            ClientProcessingData processingData = new ClientProcessingData();
            processingData.createClientProcessingData(address);
            clientProcessingMap.put(address, processingData);
        }

        MessagesToClientQueue queue = clientProcessingMap.get(address).getQueue();

        for (String symbol: symbols) {
            if (!symbolProcessingMap.containsKey(symbol)) {
                WebSocketQueue websocketQueue = new WebSocketQueue();
                SymbolProcessor processor = new SymbolProcessor(symbol, websocketQueue);
                processor.start();
                System.out.printf("CREATED PROCESSOR %s %s \n", address.getUrl(), symbol);
                WebSocketClient client = new WebsocketSubscriber(symbol, websocketQueue);
                client.connect();
                System.out.printf("CREATED WEBSOCKET %s %s \n", address.getUrl(), symbol);
                symbolProcessingMap.put(symbol, new SymbolProcessingData(processor, client));
            }
            symbolProcessingMap.get(symbol).processor.addClient(address, queue);
            symbolProcessingMap.get(symbol).clients.add(address);
            clientProcessingMap.get(address).addSymbol(symbol);
            System.out.printf("PREPARE SENDING DATA TO %s ABOUT %s \n", address.getUrl(), symbol);
        }

        for (String symbol: clientProcessingMap.get(address).getSymbols()) {
            if (symbols.contains(symbol)){
                continue;
            }
            symbolProcessingMap.get(symbol).processor.removeClient(address);
            symbolProcessingMap.get(symbol).clients.remove(address);
            if (symbolProcessingMap.get(symbol).clients.isEmpty()) {
                symbolProcessingMap.get(symbol).deleteProcessor();
                symbolProcessingMap.remove(symbol);
                System.out.printf("CLOSED SYMBOL PROCESSOR %s \n", symbol);
            }
        }
    }


}
