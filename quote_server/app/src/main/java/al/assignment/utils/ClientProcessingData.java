package al.assignment.utils;

import al.assignment.quote.sender.ClientRPCSender;

import java.util.ArrayList;
import java.util.List;

public class ClientProcessingData {
    private ClientRPCSender sender;
    private MessagesToClientQueue queue;
    private List<String> symbols;

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
