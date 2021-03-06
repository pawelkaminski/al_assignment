package al.assignment.subscriber.grpc;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.36.0)",
    comments = "Source: subscriber.proto")
public final class SubscriberGrpc {

  private SubscriberGrpc() {}

  public static final String SERVICE_NAME = "Subscriber";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<al.assignment.subscriber.grpc.Subscriptions,
      al.assignment.subscriber.grpc.ProducerStatus> getSubscribeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "subscribe",
      requestType = al.assignment.subscriber.grpc.Subscriptions.class,
      responseType = al.assignment.subscriber.grpc.ProducerStatus.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<al.assignment.subscriber.grpc.Subscriptions,
      al.assignment.subscriber.grpc.ProducerStatus> getSubscribeMethod() {
    io.grpc.MethodDescriptor<al.assignment.subscriber.grpc.Subscriptions, al.assignment.subscriber.grpc.ProducerStatus> getSubscribeMethod;
    if ((getSubscribeMethod = SubscriberGrpc.getSubscribeMethod) == null) {
      synchronized (SubscriberGrpc.class) {
        if ((getSubscribeMethod = SubscriberGrpc.getSubscribeMethod) == null) {
          SubscriberGrpc.getSubscribeMethod = getSubscribeMethod =
              io.grpc.MethodDescriptor.<al.assignment.subscriber.grpc.Subscriptions, al.assignment.subscriber.grpc.ProducerStatus>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "subscribe"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  al.assignment.subscriber.grpc.Subscriptions.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  al.assignment.subscriber.grpc.ProducerStatus.getDefaultInstance()))
              .setSchemaDescriptor(new SubscriberMethodDescriptorSupplier("subscribe"))
              .build();
        }
      }
    }
    return getSubscribeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<al.assignment.subscriber.grpc.ProducerStatus,
      al.assignment.subscriber.grpc.ProducerStatus> getIsHealthyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "isHealthy",
      requestType = al.assignment.subscriber.grpc.ProducerStatus.class,
      responseType = al.assignment.subscriber.grpc.ProducerStatus.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<al.assignment.subscriber.grpc.ProducerStatus,
      al.assignment.subscriber.grpc.ProducerStatus> getIsHealthyMethod() {
    io.grpc.MethodDescriptor<al.assignment.subscriber.grpc.ProducerStatus, al.assignment.subscriber.grpc.ProducerStatus> getIsHealthyMethod;
    if ((getIsHealthyMethod = SubscriberGrpc.getIsHealthyMethod) == null) {
      synchronized (SubscriberGrpc.class) {
        if ((getIsHealthyMethod = SubscriberGrpc.getIsHealthyMethod) == null) {
          SubscriberGrpc.getIsHealthyMethod = getIsHealthyMethod =
              io.grpc.MethodDescriptor.<al.assignment.subscriber.grpc.ProducerStatus, al.assignment.subscriber.grpc.ProducerStatus>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "isHealthy"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  al.assignment.subscriber.grpc.ProducerStatus.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  al.assignment.subscriber.grpc.ProducerStatus.getDefaultInstance()))
              .setSchemaDescriptor(new SubscriberMethodDescriptorSupplier("isHealthy"))
              .build();
        }
      }
    }
    return getIsHealthyMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static SubscriberStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SubscriberStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<SubscriberStub>() {
        @java.lang.Override
        public SubscriberStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new SubscriberStub(channel, callOptions);
        }
      };
    return SubscriberStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static SubscriberBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SubscriberBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<SubscriberBlockingStub>() {
        @java.lang.Override
        public SubscriberBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new SubscriberBlockingStub(channel, callOptions);
        }
      };
    return SubscriberBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static SubscriberFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SubscriberFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<SubscriberFutureStub>() {
        @java.lang.Override
        public SubscriberFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new SubscriberFutureStub(channel, callOptions);
        }
      };
    return SubscriberFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class SubscriberImplBase implements io.grpc.BindableService {

    /**
     */
    public void subscribe(al.assignment.subscriber.grpc.Subscriptions request,
        io.grpc.stub.StreamObserver<al.assignment.subscriber.grpc.ProducerStatus> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSubscribeMethod(), responseObserver);
    }

    /**
     */
    public void isHealthy(al.assignment.subscriber.grpc.ProducerStatus request,
        io.grpc.stub.StreamObserver<al.assignment.subscriber.grpc.ProducerStatus> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getIsHealthyMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getSubscribeMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                al.assignment.subscriber.grpc.Subscriptions,
                al.assignment.subscriber.grpc.ProducerStatus>(
                  this, METHODID_SUBSCRIBE)))
          .addMethod(
            getIsHealthyMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                al.assignment.subscriber.grpc.ProducerStatus,
                al.assignment.subscriber.grpc.ProducerStatus>(
                  this, METHODID_IS_HEALTHY)))
          .build();
    }
  }

  /**
   */
  public static final class SubscriberStub extends io.grpc.stub.AbstractAsyncStub<SubscriberStub> {
    private SubscriberStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SubscriberStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SubscriberStub(channel, callOptions);
    }

    /**
     */
    public void subscribe(al.assignment.subscriber.grpc.Subscriptions request,
        io.grpc.stub.StreamObserver<al.assignment.subscriber.grpc.ProducerStatus> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSubscribeMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void isHealthy(al.assignment.subscriber.grpc.ProducerStatus request,
        io.grpc.stub.StreamObserver<al.assignment.subscriber.grpc.ProducerStatus> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getIsHealthyMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class SubscriberBlockingStub extends io.grpc.stub.AbstractBlockingStub<SubscriberBlockingStub> {
    private SubscriberBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SubscriberBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SubscriberBlockingStub(channel, callOptions);
    }

    /**
     */
    public al.assignment.subscriber.grpc.ProducerStatus subscribe(al.assignment.subscriber.grpc.Subscriptions request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSubscribeMethod(), getCallOptions(), request);
    }

    /**
     */
    public al.assignment.subscriber.grpc.ProducerStatus isHealthy(al.assignment.subscriber.grpc.ProducerStatus request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getIsHealthyMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class SubscriberFutureStub extends io.grpc.stub.AbstractFutureStub<SubscriberFutureStub> {
    private SubscriberFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SubscriberFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SubscriberFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<al.assignment.subscriber.grpc.ProducerStatus> subscribe(
        al.assignment.subscriber.grpc.Subscriptions request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSubscribeMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<al.assignment.subscriber.grpc.ProducerStatus> isHealthy(
        al.assignment.subscriber.grpc.ProducerStatus request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getIsHealthyMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_SUBSCRIBE = 0;
  private static final int METHODID_IS_HEALTHY = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final SubscriberImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(SubscriberImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SUBSCRIBE:
          serviceImpl.subscribe((al.assignment.subscriber.grpc.Subscriptions) request,
              (io.grpc.stub.StreamObserver<al.assignment.subscriber.grpc.ProducerStatus>) responseObserver);
          break;
        case METHODID_IS_HEALTHY:
          serviceImpl.isHealthy((al.assignment.subscriber.grpc.ProducerStatus) request,
              (io.grpc.stub.StreamObserver<al.assignment.subscriber.grpc.ProducerStatus>) responseObserver);
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

  private static abstract class SubscriberBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    SubscriberBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return al.assignment.subscriber.grpc.QuotaServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Subscriber");
    }
  }

  private static final class SubscriberFileDescriptorSupplier
      extends SubscriberBaseDescriptorSupplier {
    SubscriberFileDescriptorSupplier() {}
  }

  private static final class SubscriberMethodDescriptorSupplier
      extends SubscriberBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    SubscriberMethodDescriptorSupplier(String methodName) {
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
      synchronized (SubscriberGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new SubscriberFileDescriptorSupplier())
              .addMethod(getSubscribeMethod())
              .addMethod(getIsHealthyMethod())
              .build();
        }
      }
    }
    return result;
  }
}
