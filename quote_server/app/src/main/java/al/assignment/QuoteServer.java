package al.assignment;

import al.assignment.quote.subscribtion.QuoteSubscriptionServer;
import al.assignment.subscriptionmanager.SubscriptionManager;

import java.io.IOException;

public class QuoteServer {

    public static void main(String[] args) throws IOException {
        startRPCServer();
        runSubscriptionManager();
    }

    private static void startRPCServer() throws IOException {
        QuoteSubscriptionServer RPCServer = new QuoteSubscriptionServer();
        RPCServer.start();
    }

    private static void runSubscriptionManager() {
        SubscriptionManager manager = new SubscriptionManager();
        manager.run();
    }
}
