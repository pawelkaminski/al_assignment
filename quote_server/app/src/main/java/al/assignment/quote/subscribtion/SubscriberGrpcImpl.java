package al.assignment.quote.subscribtion;

import al.assignment.subscriber.grpc.ProducerStatus;
import al.assignment.subscriber.grpc.SubscriberGrpc;
import al.assignment.subscriber.grpc.Subscriptions;
import al.assignment.utils.ClientAddress;
import al.assignment.utils.SubscriptionUpdate;
import al.assignment.utils.SubscriptionUpdatesQueue;
import io.grpc.stub.StreamObserver;

public class SubscriberGrpcImpl extends SubscriberGrpc.SubscriberImplBase {
    private final SubscriptionUpdatesQueue queue;

    SubscriberGrpcImpl() {
        super();
        this.queue = SubscriptionUpdatesQueue.getInstance();
    }

    @Override
    public void subscribe(Subscriptions request, StreamObserver<ProducerStatus> responseObserver) {
        System.out.printf("RECEIVED SUBSCRIPTION REQUEST FROM %s:%s WITH SYMBOLS %s \n",
                request.getHost(), request.getPort(), request.getSubscriptionList().toString());
        responseObserver.onNext(updateSubscription(request));
        responseObserver.onCompleted();
    }

    ProducerStatus updateSubscription(Subscriptions request) {
        ClientAddress address = new ClientAddress(request.getHost(), request.getPort());
        SubscriptionUpdate update = new SubscriptionUpdate(address, request.getSubscriptionList());
        queue.add(update);
        return ProducerStatus.newBuilder().setStatus(true).build();
    }

    @Override
    public void isHealthy(ProducerStatus request, StreamObserver<ProducerStatus> responseObserver) {
        System.out.println("RECEIVED HEALTHY");
        responseObserver.onNext(ProducerStatus.newBuilder().setStatus(true).build());
        System.out.println("PROCESSED HEALTHY");
        responseObserver.onCompleted();
        System.out.println("FINISHED HEALTHY");
    }

}
