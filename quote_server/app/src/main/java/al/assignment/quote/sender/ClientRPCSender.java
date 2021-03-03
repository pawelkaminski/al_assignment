package al.assignment.quote.sender;

import al.assignment.consumer.grpc.ConsumerGrpc;
import al.assignment.utils.ClientAddress;
import al.assignment.utils.MessageToClient;
import al.assignment.utils.MessagesToClientQueue;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import java.util.concurrent.TimeUnit;

public class ClientRPCSender implements Runnable {
    private final MessagesToClientQueue queue;
    private final ClientAddress address;
    private ConsumerGrpc.ConsumerBlockingStub blockingStub;
    private ManagedChannel channel;
    private boolean active;

    ClientRPCSender (MessagesToClientQueue queue, ClientAddress address) {
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
            } catch (InterruptedException e) {
                e.printStackTrace();
                // TODO(pawelk): handle dangling client connection
            }
        }
    }

    private void send(MessageToClient message) {
        if (message.trade != null) {
            blockingStub.onTrade(message.trade);
        }
        if (message.book != null) {
            blockingStub.onBook(message.book);
        }
    }


}
