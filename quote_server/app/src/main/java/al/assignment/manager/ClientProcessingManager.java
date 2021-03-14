package al.assignment.manager;

import al.assignment.quote.sender.ClientRPCSender;
import al.assignment.utils.ClientAddress;
import al.assignment.utils.MessagesToClientQueue;

import java.util.HashSet;
import java.util.Set;

public class ClientProcessingManager {
    private ClientRPCSender sender;
    private MessagesToClientQueue queue;
    private final HashSet<String> symbols;

    public ClientProcessingManager() {
        this.symbols = new HashSet<>();
    }

    public void createClientProcessing(ClientAddress address) {
        queue = new MessagesToClientQueue();
        sender = new ClientRPCSender(queue, address);
        sender.start();
    }

    public Set<String> getSymbols() {
        return new HashSet<>(symbols);
    }

    public void addSymbol(String symbol) {
        symbols.add(symbol);
    }

    public void removeSymbol(String symbol) {
        symbols.remove(symbol);
    }

    public MessagesToClientQueue getQueue() {
        return queue;
    }

    public void close() throws InterruptedException {
        sender.terminate();
        sender.interrupt();
        sender.join();
    }
}
