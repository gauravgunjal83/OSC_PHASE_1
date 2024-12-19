package com.in.dashboard;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.53.0)",
    comments = "Source: Dashboard.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class ProductDashboardServiceGrpc {

  private ProductDashboardServiceGrpc() {}

  public static final String SERVICE_NAME = "ProductDashboardService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.in.dashboard.DashboardRequest,
      com.in.dashboard.DashboardResponse> getFetchProductForDashboardMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "fetchProductForDashboard",
      requestType = com.in.dashboard.DashboardRequest.class,
      responseType = com.in.dashboard.DashboardResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.in.dashboard.DashboardRequest,
      com.in.dashboard.DashboardResponse> getFetchProductForDashboardMethod() {
    io.grpc.MethodDescriptor<com.in.dashboard.DashboardRequest, com.in.dashboard.DashboardResponse> getFetchProductForDashboardMethod;
    if ((getFetchProductForDashboardMethod = ProductDashboardServiceGrpc.getFetchProductForDashboardMethod) == null) {
      synchronized (ProductDashboardServiceGrpc.class) {
        if ((getFetchProductForDashboardMethod = ProductDashboardServiceGrpc.getFetchProductForDashboardMethod) == null) {
          ProductDashboardServiceGrpc.getFetchProductForDashboardMethod = getFetchProductForDashboardMethod =
              io.grpc.MethodDescriptor.<com.in.dashboard.DashboardRequest, com.in.dashboard.DashboardResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "fetchProductForDashboard"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.in.dashboard.DashboardRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.in.dashboard.DashboardResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ProductDashboardServiceMethodDescriptorSupplier("fetchProductForDashboard"))
              .build();
        }
      }
    }
    return getFetchProductForDashboardMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.in.dashboard.ProductDataRequest,
      com.in.dashboard.ProductDataResponse> getFetchProductDetailsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "fetchProductDetails",
      requestType = com.in.dashboard.ProductDataRequest.class,
      responseType = com.in.dashboard.ProductDataResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.in.dashboard.ProductDataRequest,
      com.in.dashboard.ProductDataResponse> getFetchProductDetailsMethod() {
    io.grpc.MethodDescriptor<com.in.dashboard.ProductDataRequest, com.in.dashboard.ProductDataResponse> getFetchProductDetailsMethod;
    if ((getFetchProductDetailsMethod = ProductDashboardServiceGrpc.getFetchProductDetailsMethod) == null) {
      synchronized (ProductDashboardServiceGrpc.class) {
        if ((getFetchProductDetailsMethod = ProductDashboardServiceGrpc.getFetchProductDetailsMethod) == null) {
          ProductDashboardServiceGrpc.getFetchProductDetailsMethod = getFetchProductDetailsMethod =
              io.grpc.MethodDescriptor.<com.in.dashboard.ProductDataRequest, com.in.dashboard.ProductDataResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "fetchProductDetails"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.in.dashboard.ProductDataRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.in.dashboard.ProductDataResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ProductDashboardServiceMethodDescriptorSupplier("fetchProductDetails"))
              .build();
        }
      }
    }
    return getFetchProductDetailsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.in.dashboard.FilterProductRequest,
      com.in.dashboard.FilterProductResponse> getFilterProductDataMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "filterProductData",
      requestType = com.in.dashboard.FilterProductRequest.class,
      responseType = com.in.dashboard.FilterProductResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.in.dashboard.FilterProductRequest,
      com.in.dashboard.FilterProductResponse> getFilterProductDataMethod() {
    io.grpc.MethodDescriptor<com.in.dashboard.FilterProductRequest, com.in.dashboard.FilterProductResponse> getFilterProductDataMethod;
    if ((getFilterProductDataMethod = ProductDashboardServiceGrpc.getFilterProductDataMethod) == null) {
      synchronized (ProductDashboardServiceGrpc.class) {
        if ((getFilterProductDataMethod = ProductDashboardServiceGrpc.getFilterProductDataMethod) == null) {
          ProductDashboardServiceGrpc.getFilterProductDataMethod = getFilterProductDataMethod =
              io.grpc.MethodDescriptor.<com.in.dashboard.FilterProductRequest, com.in.dashboard.FilterProductResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "filterProductData"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.in.dashboard.FilterProductRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.in.dashboard.FilterProductResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ProductDashboardServiceMethodDescriptorSupplier("filterProductData"))
              .build();
        }
      }
    }
    return getFilterProductDataMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.in.dashboard.DashboardRequest,
      com.in.dashboard.ViewCartResponse> getAddProductToCartMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "addProductToCart",
      requestType = com.in.dashboard.DashboardRequest.class,
      responseType = com.in.dashboard.ViewCartResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.in.dashboard.DashboardRequest,
      com.in.dashboard.ViewCartResponse> getAddProductToCartMethod() {
    io.grpc.MethodDescriptor<com.in.dashboard.DashboardRequest, com.in.dashboard.ViewCartResponse> getAddProductToCartMethod;
    if ((getAddProductToCartMethod = ProductDashboardServiceGrpc.getAddProductToCartMethod) == null) {
      synchronized (ProductDashboardServiceGrpc.class) {
        if ((getAddProductToCartMethod = ProductDashboardServiceGrpc.getAddProductToCartMethod) == null) {
          ProductDashboardServiceGrpc.getAddProductToCartMethod = getAddProductToCartMethod =
              io.grpc.MethodDescriptor.<com.in.dashboard.DashboardRequest, com.in.dashboard.ViewCartResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "addProductToCart"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.in.dashboard.DashboardRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.in.dashboard.ViewCartResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ProductDashboardServiceMethodDescriptorSupplier("addProductToCart"))
              .build();
        }
      }
    }
    return getAddProductToCartMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ProductDashboardServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ProductDashboardServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ProductDashboardServiceStub>() {
        @java.lang.Override
        public ProductDashboardServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ProductDashboardServiceStub(channel, callOptions);
        }
      };
    return ProductDashboardServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ProductDashboardServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ProductDashboardServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ProductDashboardServiceBlockingStub>() {
        @java.lang.Override
        public ProductDashboardServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ProductDashboardServiceBlockingStub(channel, callOptions);
        }
      };
    return ProductDashboardServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ProductDashboardServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ProductDashboardServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ProductDashboardServiceFutureStub>() {
        @java.lang.Override
        public ProductDashboardServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ProductDashboardServiceFutureStub(channel, callOptions);
        }
      };
    return ProductDashboardServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class ProductDashboardServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void fetchProductForDashboard(com.in.dashboard.DashboardRequest request,
        io.grpc.stub.StreamObserver<com.in.dashboard.DashboardResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getFetchProductForDashboardMethod(), responseObserver);
    }

    /**
     */
    public void fetchProductDetails(com.in.dashboard.ProductDataRequest request,
        io.grpc.stub.StreamObserver<com.in.dashboard.ProductDataResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getFetchProductDetailsMethod(), responseObserver);
    }

    /**
     */
    public void filterProductData(com.in.dashboard.FilterProductRequest request,
        io.grpc.stub.StreamObserver<com.in.dashboard.FilterProductResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getFilterProductDataMethod(), responseObserver);
    }

    /**
     */
    public void addProductToCart(com.in.dashboard.DashboardRequest request,
        io.grpc.stub.StreamObserver<com.in.dashboard.ViewCartResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getAddProductToCartMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getFetchProductForDashboardMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.in.dashboard.DashboardRequest,
                com.in.dashboard.DashboardResponse>(
                  this, METHODID_FETCH_PRODUCT_FOR_DASHBOARD)))
          .addMethod(
            getFetchProductDetailsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.in.dashboard.ProductDataRequest,
                com.in.dashboard.ProductDataResponse>(
                  this, METHODID_FETCH_PRODUCT_DETAILS)))
          .addMethod(
            getFilterProductDataMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.in.dashboard.FilterProductRequest,
                com.in.dashboard.FilterProductResponse>(
                  this, METHODID_FILTER_PRODUCT_DATA)))
          .addMethod(
            getAddProductToCartMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.in.dashboard.DashboardRequest,
                com.in.dashboard.ViewCartResponse>(
                  this, METHODID_ADD_PRODUCT_TO_CART)))
          .build();
    }
  }

  /**
   */
  public static final class ProductDashboardServiceStub extends io.grpc.stub.AbstractAsyncStub<ProductDashboardServiceStub> {
    private ProductDashboardServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ProductDashboardServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ProductDashboardServiceStub(channel, callOptions);
    }

    /**
     */
    public void fetchProductForDashboard(com.in.dashboard.DashboardRequest request,
        io.grpc.stub.StreamObserver<com.in.dashboard.DashboardResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getFetchProductForDashboardMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void fetchProductDetails(com.in.dashboard.ProductDataRequest request,
        io.grpc.stub.StreamObserver<com.in.dashboard.ProductDataResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getFetchProductDetailsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void filterProductData(com.in.dashboard.FilterProductRequest request,
        io.grpc.stub.StreamObserver<com.in.dashboard.FilterProductResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getFilterProductDataMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void addProductToCart(com.in.dashboard.DashboardRequest request,
        io.grpc.stub.StreamObserver<com.in.dashboard.ViewCartResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getAddProductToCartMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class ProductDashboardServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<ProductDashboardServiceBlockingStub> {
    private ProductDashboardServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ProductDashboardServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ProductDashboardServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.in.dashboard.DashboardResponse fetchProductForDashboard(com.in.dashboard.DashboardRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getFetchProductForDashboardMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.in.dashboard.ProductDataResponse fetchProductDetails(com.in.dashboard.ProductDataRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getFetchProductDetailsMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.in.dashboard.FilterProductResponse filterProductData(com.in.dashboard.FilterProductRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getFilterProductDataMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.in.dashboard.ViewCartResponse addProductToCart(com.in.dashboard.DashboardRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAddProductToCartMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class ProductDashboardServiceFutureStub extends io.grpc.stub.AbstractFutureStub<ProductDashboardServiceFutureStub> {
    private ProductDashboardServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ProductDashboardServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ProductDashboardServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.in.dashboard.DashboardResponse> fetchProductForDashboard(
        com.in.dashboard.DashboardRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getFetchProductForDashboardMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.in.dashboard.ProductDataResponse> fetchProductDetails(
        com.in.dashboard.ProductDataRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getFetchProductDetailsMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.in.dashboard.FilterProductResponse> filterProductData(
        com.in.dashboard.FilterProductRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getFilterProductDataMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.in.dashboard.ViewCartResponse> addProductToCart(
        com.in.dashboard.DashboardRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getAddProductToCartMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_FETCH_PRODUCT_FOR_DASHBOARD = 0;
  private static final int METHODID_FETCH_PRODUCT_DETAILS = 1;
  private static final int METHODID_FILTER_PRODUCT_DATA = 2;
  private static final int METHODID_ADD_PRODUCT_TO_CART = 3;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ProductDashboardServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ProductDashboardServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_FETCH_PRODUCT_FOR_DASHBOARD:
          serviceImpl.fetchProductForDashboard((com.in.dashboard.DashboardRequest) request,
              (io.grpc.stub.StreamObserver<com.in.dashboard.DashboardResponse>) responseObserver);
          break;
        case METHODID_FETCH_PRODUCT_DETAILS:
          serviceImpl.fetchProductDetails((com.in.dashboard.ProductDataRequest) request,
              (io.grpc.stub.StreamObserver<com.in.dashboard.ProductDataResponse>) responseObserver);
          break;
        case METHODID_FILTER_PRODUCT_DATA:
          serviceImpl.filterProductData((com.in.dashboard.FilterProductRequest) request,
              (io.grpc.stub.StreamObserver<com.in.dashboard.FilterProductResponse>) responseObserver);
          break;
        case METHODID_ADD_PRODUCT_TO_CART:
          serviceImpl.addProductToCart((com.in.dashboard.DashboardRequest) request,
              (io.grpc.stub.StreamObserver<com.in.dashboard.ViewCartResponse>) responseObserver);
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

  private static abstract class ProductDashboardServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ProductDashboardServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.in.dashboard.Dashboard.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ProductDashboardService");
    }
  }

  private static final class ProductDashboardServiceFileDescriptorSupplier
      extends ProductDashboardServiceBaseDescriptorSupplier {
    ProductDashboardServiceFileDescriptorSupplier() {}
  }

  private static final class ProductDashboardServiceMethodDescriptorSupplier
      extends ProductDashboardServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ProductDashboardServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (ProductDashboardServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ProductDashboardServiceFileDescriptorSupplier())
              .addMethod(getFetchProductForDashboardMethod())
              .addMethod(getFetchProductDetailsMethod())
              .addMethod(getFilterProductDataMethod())
              .addMethod(getAddProductToCartMethod())
              .build();
        }
      }
    }
    return result;
  }
}
