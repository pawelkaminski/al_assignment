package al.assignment.utils;

import java.util.List;

public class SubscriptionUpdate {
    public boolean isUnsubscribe;
    public ClientAddress clientAddress;
    public List<String> symbols;

    public SubscriptionUpdate(ClientAddress clientAddress) {
        this.clientAddress = clientAddress;
        this.isUnsubscribe = true;
    }

    public SubscriptionUpdate(ClientAddress clientAddress, List<String> symbols) {
        this.clientAddress = clientAddress;
        this.isUnsubscribe = false;
        this.symbols = symbols;
    }

}
