package al.assignment;

import al.assignment.subscriber.grpc.ProducerStatus;
import al.assignment.subscriber.grpc.SubscriberGrpc;
import al.assignment.subscriber.grpc.Subscriptions;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import org.java_websocket.client.WebSocketClient;

import al.assignment.websocketsubscriber.WebsocketSubscriber;
import al.assignment.symbolprocessor.SymbolProcessor;
import al.assignment.utils.WebSocketQueue;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class QuoteServer {
    private static final int PORT = Integer.parseInt(System.getenv().getOrDefault("GRPC_PORT", "5000"));

    private Server server;
    private void start() throws IOException {
        server = ServerBuilder.forPort(PORT).addService(new SubscriberGrpcImpl()).build().start();
        System.out.println("Server started, listening on " + PORT);
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            // Use stderr here since the logger may have been reset by its JVM shutdown hook.
            System.err.println("*** shutting down gRPC server since JVM is shutting down");
            try {
                QuoteServer.this.stop();
            } catch (InterruptedException e) {
                e.printStackTrace(System.err);
            }
            System.err.println("*** server shut down");
        }));
    }

    private void stop() throws InterruptedException {
        if (server != null) {
            server.shutdown().awaitTermination(30, TimeUnit.SECONDS);
        }
    }

    /**
     * Await termination on the main thread since the grpc library uses daemon threads.
     */
    private void blockUntilShutdown() throws InterruptedException {
        if (server != null) {
            server.awaitTermination();
        }
    }

    /**
     * Main launches the server from the command line.
     */
    public static void main(String[] args) throws IOException, InterruptedException {
        final QuoteServer server = new QuoteServer();
        server.start();
        server.blockUntilShutdown();
        // mock run
        //        System.out.println("alieve");
        //        WebSocketQueue queue = new WebSocketQueue();
        //        SymbolProcessor processor = new SymbolProcessor("ETH-USD", queue);
        //        new Thread(processor).start();
        //        WebSocketClient client = new WebsocketSubscriber("ETH-USD", queue);
        //        client.connect();

    }

    static class SubscriberGrpcImpl extends SubscriberGrpc.SubscriberImplBase {

        @Override
        public void subscribe(Subscriptions request, StreamObserver<ProducerStatus> responseObserver) {
            System.out.println("RECEIVED");
            responseObserver.onNext(ProducerStatus.newBuilder().setStatus(true).build());
            System.out.println("PROCESSED");
            responseObserver.onCompleted();
            System.out.println("GOOD");
        }

        @Override
        public void isHealthy(ProducerStatus request, StreamObserver<ProducerStatus> responseObserver) {
            System.out.println("RECEIVED");
            responseObserver.onNext(ProducerStatus.newBuilder().setStatus(true).build());
            System.out.println("PROCESSED");
            responseObserver.onCompleted();
            System.out.println("GOOD");
        }


    }
}
