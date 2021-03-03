package al.assignment.quote.subscribtion;

import al.assignment.subscriber.grpc.ProducerStatus;
import al.assignment.subscriber.grpc.SubscriberGrpc;
import al.assignment.subscriber.grpc.Subscriptions;
import io.grpc.stub.StreamObserver;

public class SubscriberGrpcImpl extends SubscriberGrpc.SubscriberImplBase {
    @Override
    public void subscribe(Subscriptions request, StreamObserver<ProducerStatus> responseObserver) {
        System.out.println("RECEIVED SUBSCRIPTION" + request.getSubscriptionList().toString());
        responseObserver.onNext(ProducerStatus.newBuilder().setStatus(true).build());
        System.out.println("PROCESSED SUBSCRIPTION");
        responseObserver.onCompleted();
        System.out.println("FINISHED SUBSCRIPTION");
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
