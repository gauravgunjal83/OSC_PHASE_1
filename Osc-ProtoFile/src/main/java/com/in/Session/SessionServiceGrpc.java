package com.in.Session;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.53.0)",
    comments = "Source: session.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class SessionServiceGrpc {

  private SessionServiceGrpc() {}

  public static final String SERVICE_NAME = "SessionService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.in.Session.CreateSessionRequest,
      com.in.Session.CreateSessionResponse> getCreateSessionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateSession",
      requestType = com.in.Session.CreateSessionRequest.class,
      responseType = com.in.Session.CreateSessionResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.in.Session.CreateSessionRequest,
      com.in.Session.CreateSessionResponse> getCreateSessionMethod() {
    io.grpc.MethodDescriptor<com.in.Session.CreateSessionRequest, com.in.Session.CreateSessionResponse> getCreateSessionMethod;
    if ((getCreateSessionMethod = SessionServiceGrpc.getCreateSessionMethod) == null) {
      synchronized (SessionServiceGrpc.class) {
        if ((getCreateSessionMethod = SessionServiceGrpc.getCreateSessionMethod) == null) {
          SessionServiceGrpc.getCreateSessionMethod = getCreateSessionMethod =
              io.grpc.MethodDescriptor.<com.in.Session.CreateSessionRequest, com.in.Session.CreateSessionResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateSession"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.in.Session.CreateSessionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.in.Session.CreateSessionResponse.getDefaultInstance()))
              .setSchemaDescriptor(new SessionServiceMethodDescriptorSupplier("CreateSession"))
              .build();
        }
      }
    }
    return getCreateSessionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.in.Session.ValidateSessionRequest,
      com.in.Session.SessionStatusResponse> getValidateSessionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ValidateSession",
      requestType = com.in.Session.ValidateSessionRequest.class,
      responseType = com.in.Session.SessionStatusResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.in.Session.ValidateSessionRequest,
      com.in.Session.SessionStatusResponse> getValidateSessionMethod() {
    io.grpc.MethodDescriptor<com.in.Session.ValidateSessionRequest, com.in.Session.SessionStatusResponse> getValidateSessionMethod;
    if ((getValidateSessionMethod = SessionServiceGrpc.getValidateSessionMethod) == null) {
      synchronized (SessionServiceGrpc.class) {
        if ((getValidateSessionMethod = SessionServiceGrpc.getValidateSessionMethod) == null) {
          SessionServiceGrpc.getValidateSessionMethod = getValidateSessionMethod =
              io.grpc.MethodDescriptor.<com.in.Session.ValidateSessionRequest, com.in.Session.SessionStatusResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ValidateSession"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.in.Session.ValidateSessionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.in.Session.SessionStatusResponse.getDefaultInstance()))
              .setSchemaDescriptor(new SessionServiceMethodDescriptorSupplier("ValidateSession"))
              .build();
        }
      }
    }
    return getValidateSessionMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static SessionServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SessionServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<SessionServiceStub>() {
        @java.lang.Override
        public SessionServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new SessionServiceStub(channel, callOptions);
        }
      };
    return SessionServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static SessionServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SessionServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<SessionServiceBlockingStub>() {
        @java.lang.Override
        public SessionServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new SessionServiceBlockingStub(channel, callOptions);
        }
      };
    return SessionServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static SessionServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SessionServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<SessionServiceFutureStub>() {
        @java.lang.Override
        public SessionServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new SessionServiceFutureStub(channel, callOptions);
        }
      };
    return SessionServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class SessionServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void createSession(com.in.Session.CreateSessionRequest request,
        io.grpc.stub.StreamObserver<com.in.Session.CreateSessionResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateSessionMethod(), responseObserver);
    }

    /**
     */
    public void validateSession(com.in.Session.ValidateSessionRequest request,
        io.grpc.stub.StreamObserver<com.in.Session.SessionStatusResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getValidateSessionMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getCreateSessionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.in.Session.CreateSessionRequest,
                com.in.Session.CreateSessionResponse>(
                  this, METHODID_CREATE_SESSION)))
          .addMethod(
            getValidateSessionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.in.Session.ValidateSessionRequest,
                com.in.Session.SessionStatusResponse>(
                  this, METHODID_VALIDATE_SESSION)))
          .build();
    }
  }

  /**
   */
  public static final class SessionServiceStub extends io.grpc.stub.AbstractAsyncStub<SessionServiceStub> {
    private SessionServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SessionServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SessionServiceStub(channel, callOptions);
    }

    /**
     */
    public void createSession(com.in.Session.CreateSessionRequest request,
        io.grpc.stub.StreamObserver<com.in.Session.CreateSessionResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateSessionMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void validateSession(com.in.Session.ValidateSessionRequest request,
        io.grpc.stub.StreamObserver<com.in.Session.SessionStatusResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getValidateSessionMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class SessionServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<SessionServiceBlockingStub> {
    private SessionServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SessionServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SessionServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.in.Session.CreateSessionResponse createSession(com.in.Session.CreateSessionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateSessionMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.in.Session.SessionStatusResponse validateSession(com.in.Session.ValidateSessionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getValidateSessionMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class SessionServiceFutureStub extends io.grpc.stub.AbstractFutureStub<SessionServiceFutureStub> {
    private SessionServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SessionServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SessionServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.in.Session.CreateSessionResponse> createSession(
        com.in.Session.CreateSessionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateSessionMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.in.Session.SessionStatusResponse> validateSession(
        com.in.Session.ValidateSessionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getValidateSessionMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_SESSION = 0;
  private static final int METHODID_VALIDATE_SESSION = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final SessionServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(SessionServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CREATE_SESSION:
          serviceImpl.createSession((com.in.Session.CreateSessionRequest) request,
              (io.grpc.stub.StreamObserver<com.in.Session.CreateSessionResponse>) responseObserver);
          break;
        case METHODID_VALIDATE_SESSION:
          serviceImpl.validateSession((com.in.Session.ValidateSessionRequest) request,
              (io.grpc.stub.StreamObserver<com.in.Session.SessionStatusResponse>) responseObserver);
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

  private static abstract class SessionServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    SessionServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.in.Session.Session.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("SessionService");
    }
  }

  private static final class SessionServiceFileDescriptorSupplier
      extends SessionServiceBaseDescriptorSupplier {
    SessionServiceFileDescriptorSupplier() {}
  }

  private static final class SessionServiceMethodDescriptorSupplier
      extends SessionServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    SessionServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (SessionServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new SessionServiceFileDescriptorSupplier())
              .addMethod(getCreateSessionMethod())
              .addMethod(getValidateSessionMethod())
              .build();
        }
      }
    }
    return result;
  }
}
