package al.assignment;

import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class MarketDataReceiver {
    private static final int MD_PORT = Integer.parseInt(System.getenv().getOrDefault("MD_PORT", "5001"));
    private static final String MD_HOST = System.getenv().getOrDefault("MD_HOST", "localhost");

    private Server server;

    public void start() throws IOException {
        server = ServerBuilder.forPort(MD_PORT).addService(new ConsumerGrpcImpl()).build().start();
        System.out.println("Server started, listening on " + MD_PORT);
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            // Use stderr here since the logger may have been reset by its JVM shutdown hook.
            System.err.println("*** shutting down gRPC server since JVM is shutting down");
            try {
                MarketDataReceiver.this.stop();
            } catch (InterruptedException e) {
                e.printStackTrace(System.err);
            }
            System.err.println("*** server shut down");
        }));
    }

    public void stop() throws InterruptedException {
        if (server != null) {
            server.shutdown().awaitTermination(30, TimeUnit.SECONDS);
        }
    }


    public void blockUntilShutdown() throws InterruptedException {
        if (server != null) {
            server.awaitTermination();
        }
    }


}
