package al.assignment;

import al.assignment.quote.subscribtion.QuoteSubscriptionServer;

import java.io.IOException;

public class QuoteServer {
    private static final int PORT = Integer.parseInt(System.getenv().getOrDefault("GRPC_PORT", "5000"));
    private static QuoteSubscriptionServer RPCServer;

    public static void main(String[] args) throws IOException, InterruptedException {
        startRPCServer();


        // mock run
        //        System.out.println("alieve");
        //        WebSocketQueue queue = new WebSocketQueue();
        //        SymbolProcessor processor = new SymbolProcessor("ETH-USD", queue);
        //        new Thread(processor).start();
        //        WebSocketClient client = new WebsocketSubscriber("ETH-USD", queue);
        //        client.connect();
    }

    private static void startRPCServer() throws IOException {
        RPCServer = new QuoteSubscriptionServer();
        RPCServer.start();
    }

}
