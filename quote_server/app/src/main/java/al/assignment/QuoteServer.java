package al.assignment;

import al.assignment.quote.subscribtion.QuoteSubscriptionServer;
import al.assignment.subscriptionmanager.SubscriptionManager;
import al.assignment.utils.SubscriptionUpdatesQueue;

import java.io.IOException;

public class QuoteServer {
    private static SubscriptionUpdatesQueue queue;

    public static void main(String[] args) throws IOException {
        startRPCServer();
        SubscriptionManager manager = new SubscriptionManager(queue);
        manager.run();
    }

    private static void startRPCServer() throws IOException {
        QuoteSubscriptionServer RPCServer = new QuoteSubscriptionServer();
        queue = new SubscriptionUpdatesQueue();
        RPCServer.start(queue);
    }
}
