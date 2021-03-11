package al.assignment.subscriptionmanager;

import al.assignment.utils.ClientAddress;
import al.assignment.utils.MessagesToClientQueue;
import al.assignment.utils.SubscriptionUpdate;
import al.assignment.utils.SubscriptionUpdatesQueue;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class SubscriptionManager {
    private final HashMap<ClientAddress, ClientProcessingManager> clientProcessingMap;
    private final HashMap<String, SymbolProcessingManager> symbolProcessingMap;
    private final SubscriptionUpdatesQueue queue;

    public SubscriptionManager() {
        this.queue = SubscriptionUpdatesQueue.getInstance();
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
            removeAllClientSubscriptions(update.clientAddress);
            return;
        }
        updateSubscriptions(update.clientAddress, update.symbols);
    }

    void removeAllClientSubscriptions(ClientAddress address) throws InterruptedException {
        if (!clientProcessingMap.containsKey(address)) {
            return;
        }

        for (String symbol: clientProcessingMap.get(address).getSymbols()) {
            closeSymbolPipe(symbol, address);
        }

        removeClient(address);
    }

    void closeSymbolPipe(String symbol, ClientAddress address) throws InterruptedException {
        SymbolProcessingManager manager = symbolProcessingMap.get(symbol);
        manager.removeClient(address);
        System.out.printf("CLOSED SYMBOL %s TO ADDRESS %s PIPE \n", symbol, address.getUrl());
        if (!manager.isUsed()) {
            manager.close();
            symbolProcessingMap.remove(symbol);
            System.out.printf("CLOSED SYMBOL %s MANAGER \n", symbol);
        }
    }

    void removeClient(ClientAddress address) throws InterruptedException {
        clientProcessingMap.get(address).close();
        clientProcessingMap.remove(address);
        System.out.printf("REMOVED CLIENT %s MANAGER\n", address.getUrl());
    }

    void updateSubscriptions(ClientAddress address, List<String> symbols) throws InterruptedException {
        addClient(address);

        for (String symbol: symbols) {
            createSymbolProcessor(symbol);
            createSymbolPipe(symbol, address);
        }

        List<String> symbolsToRemove = new LinkedList<>();
        for (String symbol: clientProcessingMap.get(address).getSymbols()) {
            if (!symbols.contains(symbol)){
                closeSymbolPipe(symbol, address);
                symbolsToRemove.add(symbol);
            }
        }

        for (String symbol: symbolsToRemove) {
            clientProcessingMap.get(address).removeSymbol(symbol);
        }
    }

    void addClient(ClientAddress address) {
        if (clientProcessingMap.containsKey(address)) {
            return;
        }
        ClientProcessingManager processingData = new ClientProcessingManager();
        processingData.createClientProcessing(address);
        clientProcessingMap.put(address, processingData);
        System.out.printf("CLIENT PROCESSOR %s ADDED\n", address.getUrl());
    }

    void createSymbolProcessor(String symbol) {
        if (symbolProcessingMap.containsKey(symbol)) {
            return;
        }
        SymbolProcessingManager manager = new SymbolProcessingManager();
        manager.createClientProcessing(symbol);
        symbolProcessingMap.put(symbol, manager);
        System.out.printf("CREATED SYMBOL %s PROCESSOR\n", symbol);
    }

    void createSymbolPipe(String symbol, ClientAddress address) {
        MessagesToClientQueue queue = clientProcessingMap.get(address).getQueue();
        symbolProcessingMap.get(symbol).addClient(address, queue);
        clientProcessingMap.get(address).addSymbol(symbol);
        System.out.printf("CREATED SYMBOL %s TO ADDRESS %s PIPE \n", symbol, address.getUrl());
    }
}
