package al.assignment.quote.sender;

import al.assignment.consumer.grpc.ConsumerGrpc;
import al.assignment.utils.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import java.util.concurrent.TimeUnit;

public class ClientRPCSender extends Thread {
    private final MessagesToClientQueue queue;
    private final ClientAddress address;
    private ConsumerGrpc.ConsumerBlockingStub blockingStub;
    private ManagedChannel channel;
    private volatile boolean active;

    public ClientRPCSender(MessagesToClientQueue queue, ClientAddress address) {
        this.queue = queue;
        this.address = address;
        this.active = true;
    }

    public void terminate() {
        active = false;
    }

    @Override
    public void run() {
        prepareConnection();
        processMessages();
        terminateChannel();
    }

    private void prepareConnection(){
        System.out.println("CLIENT RPC SENDER PREPARATION");
        String target = address.getUrl();
        channel = ManagedChannelBuilder.forTarget(target).usePlaintext().build();
        blockingStub = ConsumerGrpc.newBlockingStub(channel);

    }
    void terminateChannel() {
        try {
            channel.shutdownNow().awaitTermination(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void processMessages() {
        while (active) {
            try {
                send(queue.take());
            } catch (InterruptedException | RuntimeException e) {
                System.out.printf("DEAD RPC CLIENT DETECTED %s\n", address.getUrl());
                sendClientTerminationMessage();
            }
        }
    }

    private void send(MessageToClient message) {
        if (message.trade != null) {
            System.out.printf("SEND TRADE MESSAGE %s %s \n", message.trade.getSymbol(), address.getUrl());
            blockingStub.onTrade(message.trade);
        }
        if (message.book != null) {
            blockingStub.onBook(message.book);
        }
    }
    private void sendClientTerminationMessage() {
        SubscriptionUpdatesQueue queue = SubscriptionUpdatesQueue.getInstance();
        queue.add(new SubscriptionUpdate(address));
        terminate();
    }


}
