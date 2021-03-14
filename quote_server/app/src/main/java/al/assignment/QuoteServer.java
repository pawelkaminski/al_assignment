package al.assignment;

import al.assignment.quote.subscribtion.QuoteSubscriptionServer;
import al.assignment.manager.SubscriptionManager;

import java.io.IOException;

public class QuoteServer {

    public static void main(String[] args) throws IOException {
        startSubscriptionRPCServer();
        runSubscriptionManager();
    }

    private static void startSubscriptionRPCServer() throws IOException {
        QuoteSubscriptionServer RPCServer = new QuoteSubscriptionServer();
        RPCServer.start();
    }

    private static void runSubscriptionManager() {
        SubscriptionManager manager = new SubscriptionManager();
        manager.blockingRun();
    }
}
