package al.assignment.subscriptionmanager;

import al.assignment.quote.sender.ClientRPCSender;
import al.assignment.utils.ClientAddress;
import al.assignment.utils.MessagesToClientQueue;

import java.util.ArrayList;
import java.util.List;

public class ClientProcessingData {
    private ClientRPCSender sender;
    private MessagesToClientQueue queue;
    private List<String> symbols;

    public ClientProcessingData() {
        this.symbols = new ArrayList<>();
    }

    public void createClientProcessingData(ClientAddress address) {
        queue = new MessagesToClientQueue();
        sender = new ClientRPCSender(queue, address);
        sender.start();
        System.out.printf("CREATED CLIENT SENDER %s \n", address.getUrl());
    }

    public ClientProcessingData(ClientRPCSender sender, MessagesToClientQueue queue) {
        this.sender = sender;
        this.queue = queue;
        this.symbols = new ArrayList<>();
    }

    public List<String> getSymbols() {
        return symbols;
    }

    public void addSymbol(String symbol) {
        symbols.add(symbol);
    }

    public ClientRPCSender getSender() {
        return sender;
    }

    public MessagesToClientQueue getQueue() {
        return queue;
    }
}
