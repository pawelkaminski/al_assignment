package al.assignment.quote.subscribtion;

import al.assignment.utils.SubscriptionUpdatesQueue;
import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class QuoteSubscriptionServer {

    private static final int QS_PORT = Integer.parseInt(System.getenv().getOrDefault("QS_PORT", "5000"));
    private static final String QS_HOST = System.getenv().getOrDefault("QS_HOST", "localhost");

    private Server server;

    public void start(SubscriptionUpdatesQueue queue) throws IOException {
        server = ServerBuilder.forPort(QS_PORT).addService(new SubscriberGrpcImpl(queue)).build().start();
        System.out.println("Server started, listening on " + QS_PORT);
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            // Use stderr here since the logger may have been reset by its JVM shutdown hook.
            System.err.println("shutting down gRPC server since JVM is shutting down");
            try {
                QuoteSubscriptionServer.this.stop();
            } catch (InterruptedException e) {
                e.printStackTrace(System.err);
            }
            System.err.println("Quote RPC server shut down");
        }));
    }

    public void stop() throws InterruptedException {
        if (server != null) {
            server.shutdown().awaitTermination(30, TimeUnit.SECONDS);
        }
    }
}
