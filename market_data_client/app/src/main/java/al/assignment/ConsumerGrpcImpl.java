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
        System.out.printf("RECEIVED TRADE SYMBOL: %s PRICE: %s QUANTITY: %s \n", request.getSymbol(),
                request.getPrice(), request.getQuantity());
        responseObserver.onNext(ConsumerStatus.newBuilder().setStatus(true).build());
        responseObserver.onCompleted();
    }

    @Override
    public void onBook(Book request,
                       StreamObserver<ConsumerStatus> responseObserver) {
        //System.out.println("RECEIVED BOOK " + request.getOrderId());
        responseObserver.onNext(ConsumerStatus.newBuilder().setStatus(true).build());
        responseObserver.onCompleted();
    }
}
