package al.assignment.consumer.grpc;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.36.0)",
    comments = "Source: consumer.proto")
public final class ConsumerGrpc {

  private ConsumerGrpc() {}

  public static final String SERVICE_NAME = "Consumer";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<al.assignment.consumer.grpc.Trade,
      al.assignment.consumer.grpc.ConsumerStatus> getOnTradeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "onTrade",
      requestType = al.assignment.consumer.grpc.Trade.class,
      responseType = al.assignment.consumer.grpc.ConsumerStatus.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<al.assignment.consumer.grpc.Trade,
      al.assignment.consumer.grpc.ConsumerStatus> getOnTradeMethod() {
    io.grpc.MethodDescriptor<al.assignment.consumer.grpc.Trade, al.assignment.consumer.grpc.ConsumerStatus> getOnTradeMethod;
    if ((getOnTradeMethod = ConsumerGrpc.getOnTradeMethod) == null) {
      synchronized (ConsumerGrpc.class) {
        if ((getOnTradeMethod = ConsumerGrpc.getOnTradeMethod) == null) {
          ConsumerGrpc.getOnTradeMethod = getOnTradeMethod =
              io.grpc.MethodDescriptor.<al.assignment.consumer.grpc.Trade, al.assignment.consumer.grpc.ConsumerStatus>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "onTrade"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  al.assignment.consumer.grpc.Trade.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  al.assignment.consumer.grpc.ConsumerStatus.getDefaultInstance()))
              .setSchemaDescriptor(new ConsumerMethodDescriptorSupplier("onTrade"))
              .build();
        }
      }
    }
    return getOnTradeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<al.assignment.consumer.grpc.Book,
      al.assignment.consumer.grpc.ConsumerStatus> getOnBookMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "onBook",
      requestType = al.assignment.consumer.grpc.Book.class,
      responseType = al.assignment.consumer.grpc.ConsumerStatus.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<al.assignment.consumer.grpc.Book,
      al.assignment.consumer.grpc.ConsumerStatus> getOnBookMethod() {
    io.grpc.MethodDescriptor<al.assignment.consumer.grpc.Book, al.assignment.consumer.grpc.ConsumerStatus> getOnBookMethod;
    if ((getOnBookMethod = ConsumerGrpc.getOnBookMethod) == null) {
      synchronized (ConsumerGrpc.class) {
        if ((getOnBookMethod = ConsumerGrpc.getOnBookMethod) == null) {
          ConsumerGrpc.getOnBookMethod = getOnBookMethod =
              io.grpc.MethodDescriptor.<al.assignment.consumer.grpc.Book, al.assignment.consumer.grpc.ConsumerStatus>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "onBook"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  al.assignment.consumer.grpc.Book.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  al.assignment.consumer.grpc.ConsumerStatus.getDefaultInstance()))
              .setSchemaDescriptor(new ConsumerMethodDescriptorSupplier("onBook"))
              .build();
        }
      }
    }
    return getOnBookMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ConsumerStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ConsumerStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ConsumerStub>() {
        @java.lang.Override
        public ConsumerStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ConsumerStub(channel, callOptions);
        }
      };
    return ConsumerStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ConsumerBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ConsumerBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ConsumerBlockingStub>() {
        @java.lang.Override
        public ConsumerBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ConsumerBlockingStub(channel, callOptions);
        }
      };
    return ConsumerBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ConsumerFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ConsumerFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ConsumerFutureStub>() {
        @java.lang.Override
        public ConsumerFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ConsumerFutureStub(channel, callOptions);
        }
      };
    return ConsumerFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class ConsumerImplBase implements io.grpc.BindableService {

    /**
     */
    public void onTrade(al.assignment.consumer.grpc.Trade request,
        io.grpc.stub.StreamObserver<al.assignment.consumer.grpc.ConsumerStatus> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getOnTradeMethod(), responseObserver);
    }

    /**
     */
    public void onBook(al.assignment.consumer.grpc.Book request,
        io.grpc.stub.StreamObserver<al.assignment.consumer.grpc.ConsumerStatus> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getOnBookMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getOnTradeMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                al.assignment.consumer.grpc.Trade,
                al.assignment.consumer.grpc.ConsumerStatus>(
                  this, METHODID_ON_TRADE)))
          .addMethod(
            getOnBookMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                al.assignment.consumer.grpc.Book,
                al.assignment.consumer.grpc.ConsumerStatus>(
                  this, METHODID_ON_BOOK)))
          .build();
    }
  }

  /**
   */
  public static final class ConsumerStub extends io.grpc.stub.AbstractAsyncStub<ConsumerStub> {
    private ConsumerStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ConsumerStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ConsumerStub(channel, callOptions);
    }

    /**
     */
    public void onTrade(al.assignment.consumer.grpc.Trade request,
        io.grpc.stub.StreamObserver<al.assignment.consumer.grpc.ConsumerStatus> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getOnTradeMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void onBook(al.assignment.consumer.grpc.Book request,
        io.grpc.stub.StreamObserver<al.assignment.consumer.grpc.ConsumerStatus> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getOnBookMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class ConsumerBlockingStub extends io.grpc.stub.AbstractBlockingStub<ConsumerBlockingStub> {
    private ConsumerBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ConsumerBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ConsumerBlockingStub(channel, callOptions);
    }

    /**
     */
    public al.assignment.consumer.grpc.ConsumerStatus onTrade(al.assignment.consumer.grpc.Trade request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getOnTradeMethod(), getCallOptions(), request);
    }

    /**
     */
    public al.assignment.consumer.grpc.ConsumerStatus onBook(al.assignment.consumer.grpc.Book request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getOnBookMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class ConsumerFutureStub extends io.grpc.stub.AbstractFutureStub<ConsumerFutureStub> {
    private ConsumerFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ConsumerFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ConsumerFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<al.assignment.consumer.grpc.ConsumerStatus> onTrade(
        al.assignment.consumer.grpc.Trade request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getOnTradeMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<al.assignment.consumer.grpc.ConsumerStatus> onBook(
        al.assignment.consumer.grpc.Book request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getOnBookMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_ON_TRADE = 0;
  private static final int METHODID_ON_BOOK = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ConsumerImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ConsumerImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_ON_TRADE:
          serviceImpl.onTrade((al.assignment.consumer.grpc.Trade) request,
              (io.grpc.stub.StreamObserver<al.assignment.consumer.grpc.ConsumerStatus>) responseObserver);
          break;
        case METHODID_ON_BOOK:
          serviceImpl.onBook((al.assignment.consumer.grpc.Book) request,
              (io.grpc.stub.StreamObserver<al.assignment.consumer.grpc.ConsumerStatus>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class ConsumerBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ConsumerBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return al.assignment.consumer.grpc.ConsumerInterface.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Consumer");
    }
  }

  private static final class ConsumerFileDescriptorSupplier
      extends ConsumerBaseDescriptorSupplier {
    ConsumerFileDescriptorSupplier() {}
  }

  private static final class ConsumerMethodDescriptorSupplier
      extends ConsumerBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ConsumerMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (ConsumerGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ConsumerFileDescriptorSupplier())
              .addMethod(getOnTradeMethod())
              .addMethod(getOnBookMethod())
              .build();
        }
      }
    }
    return result;
  }
}
