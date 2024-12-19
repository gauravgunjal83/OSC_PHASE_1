package com.in.ProductHistory;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.53.0)",
    comments = "Source: ProductHistory.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class RecentlyViewServiceGrpc {

  private RecentlyViewServiceGrpc() {}

  public static final String SERVICE_NAME = "RecentlyViewService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.in.ProductHistory.RecentlyViewRequest,
      com.in.ProductHistory.RecentlyViewResponse> getFetchRecentlyViewedHistoryMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "fetchRecentlyViewedHistory",
      requestType = com.in.ProductHistory.RecentlyViewRequest.class,
      responseType = com.in.ProductHistory.RecentlyViewResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.in.ProductHistory.RecentlyViewRequest,
      com.in.ProductHistory.RecentlyViewResponse> getFetchRecentlyViewedHistoryMethod() {
    io.grpc.MethodDescriptor<com.in.ProductHistory.RecentlyViewRequest, com.in.ProductHistory.RecentlyViewResponse> getFetchRecentlyViewedHistoryMethod;
    if ((getFetchRecentlyViewedHistoryMethod = RecentlyViewServiceGrpc.getFetchRecentlyViewedHistoryMethod) == null) {
      synchronized (RecentlyViewServiceGrpc.class) {
        if ((getFetchRecentlyViewedHistoryMethod = RecentlyViewServiceGrpc.getFetchRecentlyViewedHistoryMethod) == null) {
          RecentlyViewServiceGrpc.getFetchRecentlyViewedHistoryMethod = getFetchRecentlyViewedHistoryMethod =
              io.grpc.MethodDescriptor.<com.in.ProductHistory.RecentlyViewRequest, com.in.ProductHistory.RecentlyViewResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "fetchRecentlyViewedHistory"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.in.ProductHistory.RecentlyViewRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.in.ProductHistory.RecentlyViewResponse.getDefaultInstance()))
              .setSchemaDescriptor(new RecentlyViewServiceMethodDescriptorSupplier("fetchRecentlyViewedHistory"))
              .build();
        }
      }
    }
    return getFetchRecentlyViewedHistoryMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.in.ProductHistory.UpdateRecentViewRequest,
      com.in.ProductHistory.UpdateRecentViewResponse> getUpdatedRecentlyViewProductsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "updatedRecentlyViewProducts",
      requestType = com.in.ProductHistory.UpdateRecentViewRequest.class,
      responseType = com.in.ProductHistory.UpdateRecentViewResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.in.ProductHistory.UpdateRecentViewRequest,
      com.in.ProductHistory.UpdateRecentViewResponse> getUpdatedRecentlyViewProductsMethod() {
    io.grpc.MethodDescriptor<com.in.ProductHistory.UpdateRecentViewRequest, com.in.ProductHistory.UpdateRecentViewResponse> getUpdatedRecentlyViewProductsMethod;
    if ((getUpdatedRecentlyViewProductsMethod = RecentlyViewServiceGrpc.getUpdatedRecentlyViewProductsMethod) == null) {
      synchronized (RecentlyViewServiceGrpc.class) {
        if ((getUpdatedRecentlyViewProductsMethod = RecentlyViewServiceGrpc.getUpdatedRecentlyViewProductsMethod) == null) {
          RecentlyViewServiceGrpc.getUpdatedRecentlyViewProductsMethod = getUpdatedRecentlyViewProductsMethod =
              io.grpc.MethodDescriptor.<com.in.ProductHistory.UpdateRecentViewRequest, com.in.ProductHistory.UpdateRecentViewResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "updatedRecentlyViewProducts"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.in.ProductHistory.UpdateRecentViewRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.in.ProductHistory.UpdateRecentViewResponse.getDefaultInstance()))
              .setSchemaDescriptor(new RecentlyViewServiceMethodDescriptorSupplier("updatedRecentlyViewProducts"))
              .build();
        }
      }
    }
    return getUpdatedRecentlyViewProductsMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static RecentlyViewServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<RecentlyViewServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<RecentlyViewServiceStub>() {
        @java.lang.Override
        public RecentlyViewServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new RecentlyViewServiceStub(channel, callOptions);
        }
      };
    return RecentlyViewServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static RecentlyViewServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<RecentlyViewServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<RecentlyViewServiceBlockingStub>() {
        @java.lang.Override
        public RecentlyViewServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new RecentlyViewServiceBlockingStub(channel, callOptions);
        }
      };
    return RecentlyViewServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static RecentlyViewServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<RecentlyViewServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<RecentlyViewServiceFutureStub>() {
        @java.lang.Override
        public RecentlyViewServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new RecentlyViewServiceFutureStub(channel, callOptions);
        }
      };
    return RecentlyViewServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class RecentlyViewServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void fetchRecentlyViewedHistory(com.in.ProductHistory.RecentlyViewRequest request,
        io.grpc.stub.StreamObserver<com.in.ProductHistory.RecentlyViewResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getFetchRecentlyViewedHistoryMethod(), responseObserver);
    }

    /**
     */
    public void updatedRecentlyViewProducts(com.in.ProductHistory.UpdateRecentViewRequest request,
        io.grpc.stub.StreamObserver<com.in.ProductHistory.UpdateRecentViewResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdatedRecentlyViewProductsMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getFetchRecentlyViewedHistoryMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.in.ProductHistory.RecentlyViewRequest,
                com.in.ProductHistory.RecentlyViewResponse>(
                  this, METHODID_FETCH_RECENTLY_VIEWED_HISTORY)))
          .addMethod(
            getUpdatedRecentlyViewProductsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.in.ProductHistory.UpdateRecentViewRequest,
                com.in.ProductHistory.UpdateRecentViewResponse>(
                  this, METHODID_UPDATED_RECENTLY_VIEW_PRODUCTS)))
          .build();
    }
  }

  /**
   */
  public static final class RecentlyViewServiceStub extends io.grpc.stub.AbstractAsyncStub<RecentlyViewServiceStub> {
    private RecentlyViewServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RecentlyViewServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RecentlyViewServiceStub(channel, callOptions);
    }

    /**
     */
    public void fetchRecentlyViewedHistory(com.in.ProductHistory.RecentlyViewRequest request,
        io.grpc.stub.StreamObserver<com.in.ProductHistory.RecentlyViewResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getFetchRecentlyViewedHistoryMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void updatedRecentlyViewProducts(com.in.ProductHistory.UpdateRecentViewRequest request,
        io.grpc.stub.StreamObserver<com.in.ProductHistory.UpdateRecentViewResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdatedRecentlyViewProductsMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class RecentlyViewServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<RecentlyViewServiceBlockingStub> {
    private RecentlyViewServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RecentlyViewServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RecentlyViewServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.in.ProductHistory.RecentlyViewResponse fetchRecentlyViewedHistory(com.in.ProductHistory.RecentlyViewRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getFetchRecentlyViewedHistoryMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.in.ProductHistory.UpdateRecentViewResponse updatedRecentlyViewProducts(com.in.ProductHistory.UpdateRecentViewRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdatedRecentlyViewProductsMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class RecentlyViewServiceFutureStub extends io.grpc.stub.AbstractFutureStub<RecentlyViewServiceFutureStub> {
    private RecentlyViewServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RecentlyViewServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RecentlyViewServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.in.ProductHistory.RecentlyViewResponse> fetchRecentlyViewedHistory(
        com.in.ProductHistory.RecentlyViewRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getFetchRecentlyViewedHistoryMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.in.ProductHistory.UpdateRecentViewResponse> updatedRecentlyViewProducts(
        com.in.ProductHistory.UpdateRecentViewRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdatedRecentlyViewProductsMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_FETCH_RECENTLY_VIEWED_HISTORY = 0;
  private static final int METHODID_UPDATED_RECENTLY_VIEW_PRODUCTS = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final RecentlyViewServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(RecentlyViewServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_FETCH_RECENTLY_VIEWED_HISTORY:
          serviceImpl.fetchRecentlyViewedHistory((com.in.ProductHistory.RecentlyViewRequest) request,
              (io.grpc.stub.StreamObserver<com.in.ProductHistory.RecentlyViewResponse>) responseObserver);
          break;
        case METHODID_UPDATED_RECENTLY_VIEW_PRODUCTS:
          serviceImpl.updatedRecentlyViewProducts((com.in.ProductHistory.UpdateRecentViewRequest) request,
              (io.grpc.stub.StreamObserver<com.in.ProductHistory.UpdateRecentViewResponse>) responseObserver);
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

  private static abstract class RecentlyViewServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    RecentlyViewServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.in.ProductHistory.ProductHistory.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("RecentlyViewService");
    }
  }

  private static final class RecentlyViewServiceFileDescriptorSupplier
      extends RecentlyViewServiceBaseDescriptorSupplier {
    RecentlyViewServiceFileDescriptorSupplier() {}
  }

  private static final class RecentlyViewServiceMethodDescriptorSupplier
      extends RecentlyViewServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    RecentlyViewServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (RecentlyViewServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new RecentlyViewServiceFileDescriptorSupplier())
              .addMethod(getFetchRecentlyViewedHistoryMethod())
              .addMethod(getUpdatedRecentlyViewProductsMethod())
              .build();
        }
      }
    }
    return result;
  }
}
