package al.assignment;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import java.util.concurrent.TimeUnit;

public class MarketDataClient {

    public static void main(String[] args) throws Exception {
        startConsumerServer();
        subscribeToSymbols();
    }

    private static void startConsumerServer() {

    }

    private static void subscribeToSymbols() throws InterruptedException {
        String target = QuoteServerSubscriber.getChannelTarget();
        ManagedChannel channel = ManagedChannelBuilder.forTarget(target).usePlaintext().build();
        QuoteServerSubscriber subscriber = new QuoteServerSubscriber(channel);

        try {
            subscriber.subscribe();
        } finally {
            // ManagedChannels use resources like threads and TCP connections. To prevent leaking these
            // resources the channel should be shut down when it will no longer be used. If it may be used
            // again leave it running.
            channel.shutdownNow().awaitTermination(5, TimeUnit.SECONDS);
        }
    }

}
