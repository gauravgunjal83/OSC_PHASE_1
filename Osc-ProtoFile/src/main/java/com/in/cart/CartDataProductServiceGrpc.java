package com.in.cart;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.53.0)",
    comments = "Source: CartDetails.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class CartDataProductServiceGrpc {

  private CartDataProductServiceGrpc() {}

  public static final String SERVICE_NAME = "CartDataProductService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.in.cart.CartProductDataRequest,
      com.google.protobuf.Empty> getAddProductToCartMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "addProductToCart",
      requestType = com.in.cart.CartProductDataRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.in.cart.CartProductDataRequest,
      com.google.protobuf.Empty> getAddProductToCartMethod() {
    io.grpc.MethodDescriptor<com.in.cart.CartProductDataRequest, com.google.protobuf.Empty> getAddProductToCartMethod;
    if ((getAddProductToCartMethod = CartDataProductServiceGrpc.getAddProductToCartMethod) == null) {
      synchronized (CartDataProductServiceGrpc.class) {
        if ((getAddProductToCartMethod = CartDataProductServiceGrpc.getAddProductToCartMethod) == null) {
          CartDataProductServiceGrpc.getAddProductToCartMethod = getAddProductToCartMethod =
              io.grpc.MethodDescriptor.<com.in.cart.CartProductDataRequest, com.google.protobuf.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "addProductToCart"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.in.cart.CartProductDataRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setSchemaDescriptor(new CartDataProductServiceMethodDescriptorSupplier("addProductToCart"))
              .build();
        }
      }
    }
    return getAddProductToCartMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.in.cart.CartProductDataRequest,
      com.google.protobuf.Empty> getDecreaseQuantityOfProductToCartMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "decreaseQuantityOfProductToCart",
      requestType = com.in.cart.CartProductDataRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.in.cart.CartProductDataRequest,
      com.google.protobuf.Empty> getDecreaseQuantityOfProductToCartMethod() {
    io.grpc.MethodDescriptor<com.in.cart.CartProductDataRequest, com.google.protobuf.Empty> getDecreaseQuantityOfProductToCartMethod;
    if ((getDecreaseQuantityOfProductToCartMethod = CartDataProductServiceGrpc.getDecreaseQuantityOfProductToCartMethod) == null) {
      synchronized (CartDataProductServiceGrpc.class) {
        if ((getDecreaseQuantityOfProductToCartMethod = CartDataProductServiceGrpc.getDecreaseQuantityOfProductToCartMethod) == null) {
          CartDataProductServiceGrpc.getDecreaseQuantityOfProductToCartMethod = getDecreaseQuantityOfProductToCartMethod =
              io.grpc.MethodDescriptor.<com.in.cart.CartProductDataRequest, com.google.protobuf.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "decreaseQuantityOfProductToCart"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.in.cart.CartProductDataRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setSchemaDescriptor(new CartDataProductServiceMethodDescriptorSupplier("decreaseQuantityOfProductToCart"))
              .build();
        }
      }
    }
    return getDecreaseQuantityOfProductToCartMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.in.cart.RemoveProductDataRequest,
      com.google.protobuf.Empty> getRemoveProductFromCartMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "removeProductFromCart",
      requestType = com.in.cart.RemoveProductDataRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.in.cart.RemoveProductDataRequest,
      com.google.protobuf.Empty> getRemoveProductFromCartMethod() {
    io.grpc.MethodDescriptor<com.in.cart.RemoveProductDataRequest, com.google.protobuf.Empty> getRemoveProductFromCartMethod;
    if ((getRemoveProductFromCartMethod = CartDataProductServiceGrpc.getRemoveProductFromCartMethod) == null) {
      synchronized (CartDataProductServiceGrpc.class) {
        if ((getRemoveProductFromCartMethod = CartDataProductServiceGrpc.getRemoveProductFromCartMethod) == null) {
          CartDataProductServiceGrpc.getRemoveProductFromCartMethod = getRemoveProductFromCartMethod =
              io.grpc.MethodDescriptor.<com.in.cart.RemoveProductDataRequest, com.google.protobuf.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "removeProductFromCart"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.in.cart.RemoveProductDataRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setSchemaDescriptor(new CartDataProductServiceMethodDescriptorSupplier("removeProductFromCart"))
              .build();
        }
      }
    }
    return getRemoveProductFromCartMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.in.cart.ViewCartProductRequest,
      com.in.cart.ViewCartProductResponse> getFetchCartOfProductMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "fetchCartOfProduct",
      requestType = com.in.cart.ViewCartProductRequest.class,
      responseType = com.in.cart.ViewCartProductResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.in.cart.ViewCartProductRequest,
      com.in.cart.ViewCartProductResponse> getFetchCartOfProductMethod() {
    io.grpc.MethodDescriptor<com.in.cart.ViewCartProductRequest, com.in.cart.ViewCartProductResponse> getFetchCartOfProductMethod;
    if ((getFetchCartOfProductMethod = CartDataProductServiceGrpc.getFetchCartOfProductMethod) == null) {
      synchronized (CartDataProductServiceGrpc.class) {
        if ((getFetchCartOfProductMethod = CartDataProductServiceGrpc.getFetchCartOfProductMethod) == null) {
          CartDataProductServiceGrpc.getFetchCartOfProductMethod = getFetchCartOfProductMethod =
              io.grpc.MethodDescriptor.<com.in.cart.ViewCartProductRequest, com.in.cart.ViewCartProductResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "fetchCartOfProduct"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.in.cart.ViewCartProductRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.in.cart.ViewCartProductResponse.getDefaultInstance()))
              .setSchemaDescriptor(new CartDataProductServiceMethodDescriptorSupplier("fetchCartOfProduct"))
              .build();
        }
      }
    }
    return getFetchCartOfProductMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.in.cart.ViewCartProductRequest,
      com.google.protobuf.Empty> getSaveCartOfProductMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "saveCartOfProduct",
      requestType = com.in.cart.ViewCartProductRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.in.cart.ViewCartProductRequest,
      com.google.protobuf.Empty> getSaveCartOfProductMethod() {
    io.grpc.MethodDescriptor<com.in.cart.ViewCartProductRequest, com.google.protobuf.Empty> getSaveCartOfProductMethod;
    if ((getSaveCartOfProductMethod = CartDataProductServiceGrpc.getSaveCartOfProductMethod) == null) {
      synchronized (CartDataProductServiceGrpc.class) {
        if ((getSaveCartOfProductMethod = CartDataProductServiceGrpc.getSaveCartOfProductMethod) == null) {
          CartDataProductServiceGrpc.getSaveCartOfProductMethod = getSaveCartOfProductMethod =
              io.grpc.MethodDescriptor.<com.in.cart.ViewCartProductRequest, com.google.protobuf.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "saveCartOfProduct"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.in.cart.ViewCartProductRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setSchemaDescriptor(new CartDataProductServiceMethodDescriptorSupplier("saveCartOfProduct"))
              .build();
        }
      }
    }
    return getSaveCartOfProductMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static CartDataProductServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CartDataProductServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CartDataProductServiceStub>() {
        @java.lang.Override
        public CartDataProductServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CartDataProductServiceStub(channel, callOptions);
        }
      };
    return CartDataProductServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static CartDataProductServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CartDataProductServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CartDataProductServiceBlockingStub>() {
        @java.lang.Override
        public CartDataProductServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CartDataProductServiceBlockingStub(channel, callOptions);
        }
      };
    return CartDataProductServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static CartDataProductServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CartDataProductServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CartDataProductServiceFutureStub>() {
        @java.lang.Override
        public CartDataProductServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CartDataProductServiceFutureStub(channel, callOptions);
        }
      };
    return CartDataProductServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class CartDataProductServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void addProductToCart(com.in.cart.CartProductDataRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getAddProductToCartMethod(), responseObserver);
    }

    /**
     */
    public void decreaseQuantityOfProductToCart(com.in.cart.CartProductDataRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDecreaseQuantityOfProductToCartMethod(), responseObserver);
    }

    /**
     */
    public void removeProductFromCart(com.in.cart.RemoveProductDataRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getRemoveProductFromCartMethod(), responseObserver);
    }

    /**
     */
    public void fetchCartOfProduct(com.in.cart.ViewCartProductRequest request,
        io.grpc.stub.StreamObserver<com.in.cart.ViewCartProductResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getFetchCartOfProductMethod(), responseObserver);
    }

    /**
     */
    public void saveCartOfProduct(com.in.cart.ViewCartProductRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSaveCartOfProductMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getAddProductToCartMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.in.cart.CartProductDataRequest,
                com.google.protobuf.Empty>(
                  this, METHODID_ADD_PRODUCT_TO_CART)))
          .addMethod(
            getDecreaseQuantityOfProductToCartMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.in.cart.CartProductDataRequest,
                com.google.protobuf.Empty>(
                  this, METHODID_DECREASE_QUANTITY_OF_PRODUCT_TO_CART)))
          .addMethod(
            getRemoveProductFromCartMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.in.cart.RemoveProductDataRequest,
                com.google.protobuf.Empty>(
                  this, METHODID_REMOVE_PRODUCT_FROM_CART)))
          .addMethod(
            getFetchCartOfProductMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.in.cart.ViewCartProductRequest,
                com.in.cart.ViewCartProductResponse>(
                  this, METHODID_FETCH_CART_OF_PRODUCT)))
          .addMethod(
            getSaveCartOfProductMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.in.cart.ViewCartProductRequest,
                com.google.protobuf.Empty>(
                  this, METHODID_SAVE_CART_OF_PRODUCT)))
          .build();
    }
  }

  /**
   */
  public static final class CartDataProductServiceStub extends io.grpc.stub.AbstractAsyncStub<CartDataProductServiceStub> {
    private CartDataProductServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CartDataProductServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CartDataProductServiceStub(channel, callOptions);
    }

    /**
     */
    public void addProductToCart(com.in.cart.CartProductDataRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getAddProductToCartMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void decreaseQuantityOfProductToCart(com.in.cart.CartProductDataRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDecreaseQuantityOfProductToCartMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void removeProductFromCart(com.in.cart.RemoveProductDataRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRemoveProductFromCartMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void fetchCartOfProduct(com.in.cart.ViewCartProductRequest request,
        io.grpc.stub.StreamObserver<com.in.cart.ViewCartProductResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getFetchCartOfProductMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void saveCartOfProduct(com.in.cart.ViewCartProductRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSaveCartOfProductMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class CartDataProductServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<CartDataProductServiceBlockingStub> {
    private CartDataProductServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CartDataProductServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CartDataProductServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.google.protobuf.Empty addProductToCart(com.in.cart.CartProductDataRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAddProductToCartMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.google.protobuf.Empty decreaseQuantityOfProductToCart(com.in.cart.CartProductDataRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDecreaseQuantityOfProductToCartMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.google.protobuf.Empty removeProductFromCart(com.in.cart.RemoveProductDataRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRemoveProductFromCartMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.in.cart.ViewCartProductResponse fetchCartOfProduct(com.in.cart.ViewCartProductRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getFetchCartOfProductMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.google.protobuf.Empty saveCartOfProduct(com.in.cart.ViewCartProductRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSaveCartOfProductMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class CartDataProductServiceFutureStub extends io.grpc.stub.AbstractFutureStub<CartDataProductServiceFutureStub> {
    private CartDataProductServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CartDataProductServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CartDataProductServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> addProductToCart(
        com.in.cart.CartProductDataRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getAddProductToCartMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> decreaseQuantityOfProductToCart(
        com.in.cart.CartProductDataRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDecreaseQuantityOfProductToCartMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> removeProductFromCart(
        com.in.cart.RemoveProductDataRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRemoveProductFromCartMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.in.cart.ViewCartProductResponse> fetchCartOfProduct(
        com.in.cart.ViewCartProductRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getFetchCartOfProductMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> saveCartOfProduct(
        com.in.cart.ViewCartProductRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSaveCartOfProductMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_ADD_PRODUCT_TO_CART = 0;
  private static final int METHODID_DECREASE_QUANTITY_OF_PRODUCT_TO_CART = 1;
  private static final int METHODID_REMOVE_PRODUCT_FROM_CART = 2;
  private static final int METHODID_FETCH_CART_OF_PRODUCT = 3;
  private static final int METHODID_SAVE_CART_OF_PRODUCT = 4;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final CartDataProductServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(CartDataProductServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_ADD_PRODUCT_TO_CART:
          serviceImpl.addProductToCart((com.in.cart.CartProductDataRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_DECREASE_QUANTITY_OF_PRODUCT_TO_CART:
          serviceImpl.decreaseQuantityOfProductToCart((com.in.cart.CartProductDataRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_REMOVE_PRODUCT_FROM_CART:
          serviceImpl.removeProductFromCart((com.in.cart.RemoveProductDataRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_FETCH_CART_OF_PRODUCT:
          serviceImpl.fetchCartOfProduct((com.in.cart.ViewCartProductRequest) request,
              (io.grpc.stub.StreamObserver<com.in.cart.ViewCartProductResponse>) responseObserver);
          break;
        case METHODID_SAVE_CART_OF_PRODUCT:
          serviceImpl.saveCartOfProduct((com.in.cart.ViewCartProductRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
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

  private static abstract class CartDataProductServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    CartDataProductServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.in.cart.CartDetails.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("CartDataProductService");
    }
  }

  private static final class CartDataProductServiceFileDescriptorSupplier
      extends CartDataProductServiceBaseDescriptorSupplier {
    CartDataProductServiceFileDescriptorSupplier() {}
  }

  private static final class CartDataProductServiceMethodDescriptorSupplier
      extends CartDataProductServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    CartDataProductServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (CartDataProductServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new CartDataProductServiceFileDescriptorSupplier())
              .addMethod(getAddProductToCartMethod())
              .addMethod(getDecreaseQuantityOfProductToCartMethod())
              .addMethod(getRemoveProductFromCartMethod())
              .addMethod(getFetchCartOfProductMethod())
              .addMethod(getSaveCartOfProductMethod())
              .build();
        }
      }
    }
    return result;
  }
}
