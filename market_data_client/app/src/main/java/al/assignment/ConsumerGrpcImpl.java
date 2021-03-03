package al.assignment;

import al.assignment.consumer.grpc.Book;
import al.assignment.consumer.grpc.ConsumerGrpc;
import al.assignment.consumer.grpc.ConsumerStatus;
import al.assignment.consumer.grpc.Trade;
import io.grpc.stub.StreamObserver;

public class ConsumerGrpcImpl extends ConsumerGrpc.ConsumerImplBase {

    @Override
    public void onTrade(Trade request,
                        StreamObserver<ConsumerStatus> responseObserver) {
        System.out.println("RECEIVED");
        responseObserver.onNext(ConsumerStatus.newBuilder().setStatus(true).build());
        System.out.println("PROCESSED");
        responseObserver.onCompleted();
        System.out.println("GOOD");
    }

    @Override
    public void onBook(Book request,
                       StreamObserver<ConsumerStatus> responseObserver) {
        System.out.println("RECEIVED");
        responseObserver.onNext(ConsumerStatus.newBuilder().setStatus(true).build());
        System.out.println("PROCESSED");
        responseObserver.onCompleted();
        System.out.println("GOOD");
    }
}
