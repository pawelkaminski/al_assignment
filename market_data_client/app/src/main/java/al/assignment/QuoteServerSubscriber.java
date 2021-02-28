package al.assignment;

import al.assignment.subscriber.grpc.ProducerStatus;
import al.assignment.subscriber.grpc.SubscriberGrpc;
import al.assignment.subscriber.grpc.Subscriptions;
import io.grpc.Channel;
import io.grpc.StatusRuntimeException;

import java.util.Arrays;

public class QuoteServerSubscriber {
    private static final int QS_PORT = Integer.parseInt(System.getenv().getOrDefault("QS_PORT", "5000"));
    private static final String QS_HOST = System.getenv().getOrDefault("QS_HOST", "localhost");
    private static final String[] SYMBOLS = System.getenv().getOrDefault("SYMBOLS", "ETH-USD ETH-BTC").split(" ");

    private final SubscriberGrpc.SubscriberBlockingStub blockingStub;

    public QuoteServerSubscriber(Channel channel) {
        blockingStub = SubscriberGrpc.newBlockingStub(channel);
    }

    public static String getChannelTarget() {
        return QS_HOST + ":" + QS_PORT;
    }

    public void subscribe() {
        Subscriptions subscriptions = prepareSubscriptions();
        callSubscription(subscriptions);
    }

    Subscriptions prepareSubscriptions() {
        Subscriptions.Builder builder = Subscriptions.newBuilder();
        for (int idx = 0; idx < SYMBOLS.length; ++idx) {
            builder.setSubscription(idx, SYMBOLS[idx]);
        }
        return builder.build();
    }

    void callSubscription(Subscriptions subscriptions) {
        System.out.println("Trying to subscribe to" + Arrays.toString(SYMBOLS));
        ProducerStatus response;
        try {
            response = blockingStub.subscribe(subscriptions);
        } catch (StatusRuntimeException e) {
            System.out.println("Problem with subscription" + e);
            return;
        }
        if (!response.getStatus()) {
            System.out.println("Not subscribed.");
            return;
        }
        System.out.println("Subscribed");
    }

}
