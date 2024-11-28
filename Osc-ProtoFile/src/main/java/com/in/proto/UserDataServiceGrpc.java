package com.in.proto;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.53.0)",
    comments = "Source: user.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class UserDataServiceGrpc {

  private UserDataServiceGrpc() {}

  public static final String SERVICE_NAME = "UserDataService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.in.proto.RegisterUserRequest,
      com.in.proto.RegisterUserResponse> getRegisterUserMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RegisterUser",
      requestType = com.in.proto.RegisterUserRequest.class,
      responseType = com.in.proto.RegisterUserResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.in.proto.RegisterUserRequest,
      com.in.proto.RegisterUserResponse> getRegisterUserMethod() {
    io.grpc.MethodDescriptor<com.in.proto.RegisterUserRequest, com.in.proto.RegisterUserResponse> getRegisterUserMethod;
    if ((getRegisterUserMethod = UserDataServiceGrpc.getRegisterUserMethod) == null) {
      synchronized (UserDataServiceGrpc.class) {
        if ((getRegisterUserMethod = UserDataServiceGrpc.getRegisterUserMethod) == null) {
          UserDataServiceGrpc.getRegisterUserMethod = getRegisterUserMethod =
              io.grpc.MethodDescriptor.<com.in.proto.RegisterUserRequest, com.in.proto.RegisterUserResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "RegisterUser"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.in.proto.RegisterUserRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.in.proto.RegisterUserResponse.getDefaultInstance()))
              .setSchemaDescriptor(new UserDataServiceMethodDescriptorSupplier("RegisterUser"))
              .build();
        }
      }
    }
    return getRegisterUserMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.in.proto.UniqueEmailRequest,
      com.in.proto.UniqueEmailResponse> getVerifyEmailAddressIsUniqueMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "verifyEmailAddressIsUnique",
      requestType = com.in.proto.UniqueEmailRequest.class,
      responseType = com.in.proto.UniqueEmailResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.in.proto.UniqueEmailRequest,
      com.in.proto.UniqueEmailResponse> getVerifyEmailAddressIsUniqueMethod() {
    io.grpc.MethodDescriptor<com.in.proto.UniqueEmailRequest, com.in.proto.UniqueEmailResponse> getVerifyEmailAddressIsUniqueMethod;
    if ((getVerifyEmailAddressIsUniqueMethod = UserDataServiceGrpc.getVerifyEmailAddressIsUniqueMethod) == null) {
      synchronized (UserDataServiceGrpc.class) {
        if ((getVerifyEmailAddressIsUniqueMethod = UserDataServiceGrpc.getVerifyEmailAddressIsUniqueMethod) == null) {
          UserDataServiceGrpc.getVerifyEmailAddressIsUniqueMethod = getVerifyEmailAddressIsUniqueMethod =
              io.grpc.MethodDescriptor.<com.in.proto.UniqueEmailRequest, com.in.proto.UniqueEmailResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "verifyEmailAddressIsUnique"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.in.proto.UniqueEmailRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.in.proto.UniqueEmailResponse.getDefaultInstance()))
              .setSchemaDescriptor(new UserDataServiceMethodDescriptorSupplier("verifyEmailAddressIsUnique"))
              .build();
        }
      }
    }
    return getVerifyEmailAddressIsUniqueMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.in.proto.UniqueEmailRequest,
      com.in.proto.UniqueEmailResponse> getIsEmailPresentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "isEmailPresent",
      requestType = com.in.proto.UniqueEmailRequest.class,
      responseType = com.in.proto.UniqueEmailResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.in.proto.UniqueEmailRequest,
      com.in.proto.UniqueEmailResponse> getIsEmailPresentMethod() {
    io.grpc.MethodDescriptor<com.in.proto.UniqueEmailRequest, com.in.proto.UniqueEmailResponse> getIsEmailPresentMethod;
    if ((getIsEmailPresentMethod = UserDataServiceGrpc.getIsEmailPresentMethod) == null) {
      synchronized (UserDataServiceGrpc.class) {
        if ((getIsEmailPresentMethod = UserDataServiceGrpc.getIsEmailPresentMethod) == null) {
          UserDataServiceGrpc.getIsEmailPresentMethod = getIsEmailPresentMethod =
              io.grpc.MethodDescriptor.<com.in.proto.UniqueEmailRequest, com.in.proto.UniqueEmailResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "isEmailPresent"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.in.proto.UniqueEmailRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.in.proto.UniqueEmailResponse.getDefaultInstance()))
              .setSchemaDescriptor(new UserDataServiceMethodDescriptorSupplier("isEmailPresent"))
              .build();
        }
      }
    }
    return getIsEmailPresentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.in.proto.PasswordRequest,
      com.in.proto.PasswordResponse> getResetPasswordMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "resetPassword",
      requestType = com.in.proto.PasswordRequest.class,
      responseType = com.in.proto.PasswordResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.in.proto.PasswordRequest,
      com.in.proto.PasswordResponse> getResetPasswordMethod() {
    io.grpc.MethodDescriptor<com.in.proto.PasswordRequest, com.in.proto.PasswordResponse> getResetPasswordMethod;
    if ((getResetPasswordMethod = UserDataServiceGrpc.getResetPasswordMethod) == null) {
      synchronized (UserDataServiceGrpc.class) {
        if ((getResetPasswordMethod = UserDataServiceGrpc.getResetPasswordMethod) == null) {
          UserDataServiceGrpc.getResetPasswordMethod = getResetPasswordMethod =
              io.grpc.MethodDescriptor.<com.in.proto.PasswordRequest, com.in.proto.PasswordResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "resetPassword"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.in.proto.PasswordRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.in.proto.PasswordResponse.getDefaultInstance()))
              .setSchemaDescriptor(new UserDataServiceMethodDescriptorSupplier("resetPassword"))
              .build();
        }
      }
    }
    return getResetPasswordMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.in.proto.VerifyCredentialsRequest,
      com.in.proto.VerifyCredentialsResponse> getVerifyCredentialsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "VerifyCredentials",
      requestType = com.in.proto.VerifyCredentialsRequest.class,
      responseType = com.in.proto.VerifyCredentialsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.in.proto.VerifyCredentialsRequest,
      com.in.proto.VerifyCredentialsResponse> getVerifyCredentialsMethod() {
    io.grpc.MethodDescriptor<com.in.proto.VerifyCredentialsRequest, com.in.proto.VerifyCredentialsResponse> getVerifyCredentialsMethod;
    if ((getVerifyCredentialsMethod = UserDataServiceGrpc.getVerifyCredentialsMethod) == null) {
      synchronized (UserDataServiceGrpc.class) {
        if ((getVerifyCredentialsMethod = UserDataServiceGrpc.getVerifyCredentialsMethod) == null) {
          UserDataServiceGrpc.getVerifyCredentialsMethod = getVerifyCredentialsMethod =
              io.grpc.MethodDescriptor.<com.in.proto.VerifyCredentialsRequest, com.in.proto.VerifyCredentialsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "VerifyCredentials"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.in.proto.VerifyCredentialsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.in.proto.VerifyCredentialsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new UserDataServiceMethodDescriptorSupplier("VerifyCredentials"))
              .build();
        }
      }
    }
    return getVerifyCredentialsMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static UserDataServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<UserDataServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<UserDataServiceStub>() {
        @java.lang.Override
        public UserDataServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new UserDataServiceStub(channel, callOptions);
        }
      };
    return UserDataServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static UserDataServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<UserDataServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<UserDataServiceBlockingStub>() {
        @java.lang.Override
        public UserDataServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new UserDataServiceBlockingStub(channel, callOptions);
        }
      };
    return UserDataServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static UserDataServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<UserDataServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<UserDataServiceFutureStub>() {
        @java.lang.Override
        public UserDataServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new UserDataServiceFutureStub(channel, callOptions);
        }
      };
    return UserDataServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class UserDataServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void registerUser(com.in.proto.RegisterUserRequest request,
        io.grpc.stub.StreamObserver<com.in.proto.RegisterUserResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getRegisterUserMethod(), responseObserver);
    }

    /**
     */
    public void verifyEmailAddressIsUnique(com.in.proto.UniqueEmailRequest request,
        io.grpc.stub.StreamObserver<com.in.proto.UniqueEmailResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getVerifyEmailAddressIsUniqueMethod(), responseObserver);
    }

    /**
     */
    public void isEmailPresent(com.in.proto.UniqueEmailRequest request,
        io.grpc.stub.StreamObserver<com.in.proto.UniqueEmailResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getIsEmailPresentMethod(), responseObserver);
    }

    /**
     */
    public void resetPassword(com.in.proto.PasswordRequest request,
        io.grpc.stub.StreamObserver<com.in.proto.PasswordResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getResetPasswordMethod(), responseObserver);
    }

    /**
     */
    public void verifyCredentials(com.in.proto.VerifyCredentialsRequest request,
        io.grpc.stub.StreamObserver<com.in.proto.VerifyCredentialsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getVerifyCredentialsMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getRegisterUserMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.in.proto.RegisterUserRequest,
                com.in.proto.RegisterUserResponse>(
                  this, METHODID_REGISTER_USER)))
          .addMethod(
            getVerifyEmailAddressIsUniqueMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.in.proto.UniqueEmailRequest,
                com.in.proto.UniqueEmailResponse>(
                  this, METHODID_VERIFY_EMAIL_ADDRESS_IS_UNIQUE)))
          .addMethod(
            getIsEmailPresentMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.in.proto.UniqueEmailRequest,
                com.in.proto.UniqueEmailResponse>(
                  this, METHODID_IS_EMAIL_PRESENT)))
          .addMethod(
            getResetPasswordMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.in.proto.PasswordRequest,
                com.in.proto.PasswordResponse>(
                  this, METHODID_RESET_PASSWORD)))
          .addMethod(
            getVerifyCredentialsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.in.proto.VerifyCredentialsRequest,
                com.in.proto.VerifyCredentialsResponse>(
                  this, METHODID_VERIFY_CREDENTIALS)))
          .build();
    }
  }

  /**
   */
  public static final class UserDataServiceStub extends io.grpc.stub.AbstractAsyncStub<UserDataServiceStub> {
    private UserDataServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected UserDataServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new UserDataServiceStub(channel, callOptions);
    }

    /**
     */
    public void registerUser(com.in.proto.RegisterUserRequest request,
        io.grpc.stub.StreamObserver<com.in.proto.RegisterUserResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRegisterUserMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void verifyEmailAddressIsUnique(com.in.proto.UniqueEmailRequest request,
        io.grpc.stub.StreamObserver<com.in.proto.UniqueEmailResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getVerifyEmailAddressIsUniqueMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void isEmailPresent(com.in.proto.UniqueEmailRequest request,
        io.grpc.stub.StreamObserver<com.in.proto.UniqueEmailResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getIsEmailPresentMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void resetPassword(com.in.proto.PasswordRequest request,
        io.grpc.stub.StreamObserver<com.in.proto.PasswordResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getResetPasswordMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void verifyCredentials(com.in.proto.VerifyCredentialsRequest request,
        io.grpc.stub.StreamObserver<com.in.proto.VerifyCredentialsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getVerifyCredentialsMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class UserDataServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<UserDataServiceBlockingStub> {
    private UserDataServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected UserDataServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new UserDataServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.in.proto.RegisterUserResponse registerUser(com.in.proto.RegisterUserRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRegisterUserMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.in.proto.UniqueEmailResponse verifyEmailAddressIsUnique(com.in.proto.UniqueEmailRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getVerifyEmailAddressIsUniqueMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.in.proto.UniqueEmailResponse isEmailPresent(com.in.proto.UniqueEmailRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getIsEmailPresentMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.in.proto.PasswordResponse resetPassword(com.in.proto.PasswordRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getResetPasswordMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.in.proto.VerifyCredentialsResponse verifyCredentials(com.in.proto.VerifyCredentialsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getVerifyCredentialsMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class UserDataServiceFutureStub extends io.grpc.stub.AbstractFutureStub<UserDataServiceFutureStub> {
    private UserDataServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected UserDataServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new UserDataServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.in.proto.RegisterUserResponse> registerUser(
        com.in.proto.RegisterUserRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRegisterUserMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.in.proto.UniqueEmailResponse> verifyEmailAddressIsUnique(
        com.in.proto.UniqueEmailRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getVerifyEmailAddressIsUniqueMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.in.proto.UniqueEmailResponse> isEmailPresent(
        com.in.proto.UniqueEmailRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getIsEmailPresentMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.in.proto.PasswordResponse> resetPassword(
        com.in.proto.PasswordRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getResetPasswordMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.in.proto.VerifyCredentialsResponse> verifyCredentials(
        com.in.proto.VerifyCredentialsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getVerifyCredentialsMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_REGISTER_USER = 0;
  private static final int METHODID_VERIFY_EMAIL_ADDRESS_IS_UNIQUE = 1;
  private static final int METHODID_IS_EMAIL_PRESENT = 2;
  private static final int METHODID_RESET_PASSWORD = 3;
  private static final int METHODID_VERIFY_CREDENTIALS = 4;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final UserDataServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(UserDataServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_REGISTER_USER:
          serviceImpl.registerUser((com.in.proto.RegisterUserRequest) request,
              (io.grpc.stub.StreamObserver<com.in.proto.RegisterUserResponse>) responseObserver);
          break;
        case METHODID_VERIFY_EMAIL_ADDRESS_IS_UNIQUE:
          serviceImpl.verifyEmailAddressIsUnique((com.in.proto.UniqueEmailRequest) request,
              (io.grpc.stub.StreamObserver<com.in.proto.UniqueEmailResponse>) responseObserver);
          break;
        case METHODID_IS_EMAIL_PRESENT:
          serviceImpl.isEmailPresent((com.in.proto.UniqueEmailRequest) request,
              (io.grpc.stub.StreamObserver<com.in.proto.UniqueEmailResponse>) responseObserver);
          break;
        case METHODID_RESET_PASSWORD:
          serviceImpl.resetPassword((com.in.proto.PasswordRequest) request,
              (io.grpc.stub.StreamObserver<com.in.proto.PasswordResponse>) responseObserver);
          break;
        case METHODID_VERIFY_CREDENTIALS:
          serviceImpl.verifyCredentials((com.in.proto.VerifyCredentialsRequest) request,
              (io.grpc.stub.StreamObserver<com.in.proto.VerifyCredentialsResponse>) responseObserver);
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

  private static abstract class UserDataServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    UserDataServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.in.proto.User.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("UserDataService");
    }
  }

  private static final class UserDataServiceFileDescriptorSupplier
      extends UserDataServiceBaseDescriptorSupplier {
    UserDataServiceFileDescriptorSupplier() {}
  }

  private static final class UserDataServiceMethodDescriptorSupplier
      extends UserDataServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    UserDataServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (UserDataServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new UserDataServiceFileDescriptorSupplier())
              .addMethod(getRegisterUserMethod())
              .addMethod(getVerifyEmailAddressIsUniqueMethod())
              .addMethod(getIsEmailPresentMethod())
              .addMethod(getResetPasswordMethod())
              .addMethod(getVerifyCredentialsMethod())
              .build();
        }
      }
    }
    return result;
  }
}
