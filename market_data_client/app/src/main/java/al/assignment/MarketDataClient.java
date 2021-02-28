package al.assignment;


import al.assignment.subscriber.grpc.ProducerStatus;
import al.assignment.subscriber.grpc.SubscriberGrpc;
import io.grpc.*;

import java.util.concurrent.TimeUnit;

public class MarketDataClient {

    private static final int QS_PORT = Integer.parseInt(System.getenv().getOrDefault("QS_PORT", "5000"));
    private static final String QS_HOST = System.getenv().getOrDefault("QS_HOST", "localhost");
    private static final String[] SYMBOLS = System.getenv().getOrDefault("SYMBOLS", "ETH-USD ETH-BTC").split(" ");

    private static final int MD_PORT = Integer.parseInt(System.getenv().getOrDefault("MD_PORT", "5000"));
    private static final String MD_HOST = System.getenv().getOrDefault("MD_HOST", "localhost");

    private final SubscriberGrpc.SubscriberBlockingStub blockingStub;

    public MarketDataClient(Channel channel) {
        blockingStub = SubscriberGrpc.newBlockingStub(channel);
    }

    public void ping() {
        System.out.println("Will try to ping");
        ProducerStatus status = ProducerStatus.newBuilder().setStatus(true).build();
        ProducerStatus response;
        try {
            response = blockingStub.isHealthy(status);
        } catch (StatusRuntimeException e) {
            System.out.println("BAD");
            return;
        }
        System.out.println("GOOD");
    }


    public static void main(String[] args) throws Exception {
        System.out.println("TEST");
        String target = QS_HOST + ":" + QS_PORT;

        // Create a communication channel to the server, known as a Channel. Channels are thread-safe
        // and reusable. It is common to create channels at the beginning of your application and reuse
        // them until the application shuts down.
        ManagedChannel channel = ManagedChannelBuilder.forTarget(target)
                // Channels are secure by default (via SSL/TLS). For the example we disable TLS to avoid
                // needing certificates.
                .usePlaintext()
                .build();
        try {
            MarketDataClient client = new MarketDataClient(channel);
            client.ping();
        } finally {
            // ManagedChannels use resources like threads and TCP connections. To prevent leaking these
            // resources the channel should be shut down when it will no longer be used. If it may be used
            // again leave it running.
            channel.shutdownNow().awaitTermination(5, TimeUnit.SECONDS);
        }
    }

}
