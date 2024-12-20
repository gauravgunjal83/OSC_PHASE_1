// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Dashboard.proto

package com.in.dashboard;

/**
 * Protobuf type {@code ProductDataResponse}
 */
public  final class ProductDataResponse extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:ProductDataResponse)
    ProductDataResponseOrBuilder {
private static final long serialVersionUID = 0L;
  // Use ProductDataResponse.newBuilder() to construct.
  private ProductDataResponse(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private ProductDataResponse() {
    similarProducts_ = java.util.Collections.emptyList();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private ProductDataResponse(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    int mutable_bitField0_ = 0;
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          case 10: {
            com.in.dashboard.Product.Builder subBuilder = null;
            if (product_ != null) {
              subBuilder = product_.toBuilder();
            }
            product_ = input.readMessage(com.in.dashboard.Product.parser(), extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(product_);
              product_ = subBuilder.buildPartial();
            }

            break;
          }
          case 18: {
            if (!((mutable_bitField0_ & 0x00000002) == 0x00000002)) {
              similarProducts_ = new java.util.ArrayList<com.in.dashboard.Product>();
              mutable_bitField0_ |= 0x00000002;
            }
            similarProducts_.add(
                input.readMessage(com.in.dashboard.Product.parser(), extensionRegistry));
            break;
          }
          default: {
            if (!parseUnknownFieldProto3(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      if (((mutable_bitField0_ & 0x00000002) == 0x00000002)) {
        similarProducts_ = java.util.Collections.unmodifiableList(similarProducts_);
      }
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return com.in.dashboard.Dashboard.internal_static_ProductDataResponse_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.in.dashboard.Dashboard.internal_static_ProductDataResponse_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.in.dashboard.ProductDataResponse.class, com.in.dashboard.ProductDataResponse.Builder.class);
  }

  private int bitField0_;
  public static final int PRODUCT_FIELD_NUMBER = 1;
  private com.in.dashboard.Product product_;
  /**
   * <code>.Product product = 1;</code>
   */
  public boolean hasProduct() {
    return product_ != null;
  }
  /**
   * <code>.Product product = 1;</code>
   */
  public com.in.dashboard.Product getProduct() {
    return product_ == null ? com.in.dashboard.Product.getDefaultInstance() : product_;
  }
  /**
   * <code>.Product product = 1;</code>
   */
  public com.in.dashboard.ProductOrBuilder getProductOrBuilder() {
    return getProduct();
  }

  public static final int SIMILARPRODUCTS_FIELD_NUMBER = 2;
  private java.util.List<com.in.dashboard.Product> similarProducts_;
  /**
   * <code>repeated .Product similarProducts = 2;</code>
   */
  public java.util.List<com.in.dashboard.Product> getSimilarProductsList() {
    return similarProducts_;
  }
  /**
   * <code>repeated .Product similarProducts = 2;</code>
   */
  public java.util.List<? extends com.in.dashboard.ProductOrBuilder> 
      getSimilarProductsOrBuilderList() {
    return similarProducts_;
  }
  /**
   * <code>repeated .Product similarProducts = 2;</code>
   */
  public int getSimilarProductsCount() {
    return similarProducts_.size();
  }
  /**
   * <code>repeated .Product similarProducts = 2;</code>
   */
  public com.in.dashboard.Product getSimilarProducts(int index) {
    return similarProducts_.get(index);
  }
  /**
   * <code>repeated .Product similarProducts = 2;</code>
   */
  public com.in.dashboard.ProductOrBuilder getSimilarProductsOrBuilder(
      int index) {
    return similarProducts_.get(index);
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (product_ != null) {
      output.writeMessage(1, getProduct());
    }
    for (int i = 0; i < similarProducts_.size(); i++) {
      output.writeMessage(2, similarProducts_.get(i));
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (product_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(1, getProduct());
    }
    for (int i = 0; i < similarProducts_.size(); i++) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(2, similarProducts_.get(i));
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof com.in.dashboard.ProductDataResponse)) {
      return super.equals(obj);
    }
    com.in.dashboard.ProductDataResponse other = (com.in.dashboard.ProductDataResponse) obj;

    boolean result = true;
    result = result && (hasProduct() == other.hasProduct());
    if (hasProduct()) {
      result = result && getProduct()
          .equals(other.getProduct());
    }
    result = result && getSimilarProductsList()
        .equals(other.getSimilarProductsList());
    result = result && unknownFields.equals(other.unknownFields);
    return result;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    if (hasProduct()) {
      hash = (37 * hash) + PRODUCT_FIELD_NUMBER;
      hash = (53 * hash) + getProduct().hashCode();
    }
    if (getSimilarProductsCount() > 0) {
      hash = (37 * hash) + SIMILARPRODUCTS_FIELD_NUMBER;
      hash = (53 * hash) + getSimilarProductsList().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.in.dashboard.ProductDataResponse parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.in.dashboard.ProductDataResponse parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.in.dashboard.ProductDataResponse parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.in.dashboard.ProductDataResponse parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.in.dashboard.ProductDataResponse parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.in.dashboard.ProductDataResponse parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.in.dashboard.ProductDataResponse parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.in.dashboard.ProductDataResponse parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.in.dashboard.ProductDataResponse parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.in.dashboard.ProductDataResponse parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.in.dashboard.ProductDataResponse parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.in.dashboard.ProductDataResponse parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(com.in.dashboard.ProductDataResponse prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code ProductDataResponse}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:ProductDataResponse)
      com.in.dashboard.ProductDataResponseOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.in.dashboard.Dashboard.internal_static_ProductDataResponse_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.in.dashboard.Dashboard.internal_static_ProductDataResponse_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.in.dashboard.ProductDataResponse.class, com.in.dashboard.ProductDataResponse.Builder.class);
    }

    // Construct using com.in.dashboard.ProductDataResponse.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
        getSimilarProductsFieldBuilder();
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      if (productBuilder_ == null) {
        product_ = null;
      } else {
        product_ = null;
        productBuilder_ = null;
      }
      if (similarProductsBuilder_ == null) {
        similarProducts_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000002);
      } else {
        similarProductsBuilder_.clear();
      }
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.in.dashboard.Dashboard.internal_static_ProductDataResponse_descriptor;
    }

    @java.lang.Override
    public com.in.dashboard.ProductDataResponse getDefaultInstanceForType() {
      return com.in.dashboard.ProductDataResponse.getDefaultInstance();
    }

    @java.lang.Override
    public com.in.dashboard.ProductDataResponse build() {
      com.in.dashboard.ProductDataResponse result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.in.dashboard.ProductDataResponse buildPartial() {
      com.in.dashboard.ProductDataResponse result = new com.in.dashboard.ProductDataResponse(this);
      int from_bitField0_ = bitField0_;
      int to_bitField0_ = 0;
      if (productBuilder_ == null) {
        result.product_ = product_;
      } else {
        result.product_ = productBuilder_.build();
      }
      if (similarProductsBuilder_ == null) {
        if (((bitField0_ & 0x00000002) == 0x00000002)) {
          similarProducts_ = java.util.Collections.unmodifiableList(similarProducts_);
          bitField0_ = (bitField0_ & ~0x00000002);
        }
        result.similarProducts_ = similarProducts_;
      } else {
        result.similarProducts_ = similarProductsBuilder_.build();
      }
      result.bitField0_ = to_bitField0_;
      onBuilt();
      return result;
    }

    @java.lang.Override
    public Builder clone() {
      return (Builder) super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return (Builder) super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return (Builder) super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return (Builder) super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return (Builder) super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return (Builder) super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof com.in.dashboard.ProductDataResponse) {
        return mergeFrom((com.in.dashboard.ProductDataResponse)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.in.dashboard.ProductDataResponse other) {
      if (other == com.in.dashboard.ProductDataResponse.getDefaultInstance()) return this;
      if (other.hasProduct()) {
        mergeProduct(other.getProduct());
      }
      if (similarProductsBuilder_ == null) {
        if (!other.similarProducts_.isEmpty()) {
          if (similarProducts_.isEmpty()) {
            similarProducts_ = other.similarProducts_;
            bitField0_ = (bitField0_ & ~0x00000002);
          } else {
            ensureSimilarProductsIsMutable();
            similarProducts_.addAll(other.similarProducts_);
          }
          onChanged();
        }
      } else {
        if (!other.similarProducts_.isEmpty()) {
          if (similarProductsBuilder_.isEmpty()) {
            similarProductsBuilder_.dispose();
            similarProductsBuilder_ = null;
            similarProducts_ = other.similarProducts_;
            bitField0_ = (bitField0_ & ~0x00000002);
            similarProductsBuilder_ = 
              com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders ?
                 getSimilarProductsFieldBuilder() : null;
          } else {
            similarProductsBuilder_.addAllMessages(other.similarProducts_);
          }
        }
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      com.in.dashboard.ProductDataResponse parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.in.dashboard.ProductDataResponse) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    private com.in.dashboard.Product product_ = null;
    private com.google.protobuf.SingleFieldBuilderV3<
        com.in.dashboard.Product, com.in.dashboard.Product.Builder, com.in.dashboard.ProductOrBuilder> productBuilder_;
    /**
     * <code>.Product product = 1;</code>
     */
    public boolean hasProduct() {
      return productBuilder_ != null || product_ != null;
    }
    /**
     * <code>.Product product = 1;</code>
     */
    public com.in.dashboard.Product getProduct() {
      if (productBuilder_ == null) {
        return product_ == null ? com.in.dashboard.Product.getDefaultInstance() : product_;
      } else {
        return productBuilder_.getMessage();
      }
    }
    /**
     * <code>.Product product = 1;</code>
     */
    public Builder setProduct(com.in.dashboard.Product value) {
      if (productBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        product_ = value;
        onChanged();
      } else {
        productBuilder_.setMessage(value);
      }

      return this;
    }
    /**
     * <code>.Product product = 1;</code>
     */
    public Builder setProduct(
        com.in.dashboard.Product.Builder builderForValue) {
      if (productBuilder_ == null) {
        product_ = builderForValue.build();
        onChanged();
      } else {
        productBuilder_.setMessage(builderForValue.build());
      }

      return this;
    }
    /**
     * <code>.Product product = 1;</code>
     */
    public Builder mergeProduct(com.in.dashboard.Product value) {
      if (productBuilder_ == null) {
        if (product_ != null) {
          product_ =
            com.in.dashboard.Product.newBuilder(product_).mergeFrom(value).buildPartial();
        } else {
          product_ = value;
        }
        onChanged();
      } else {
        productBuilder_.mergeFrom(value);
      }

      return this;
    }
    /**
     * <code>.Product product = 1;</code>
     */
    public Builder clearProduct() {
      if (productBuilder_ == null) {
        product_ = null;
        onChanged();
      } else {
        product_ = null;
        productBuilder_ = null;
      }

      return this;
    }
    /**
     * <code>.Product product = 1;</code>
     */
    public com.in.dashboard.Product.Builder getProductBuilder() {
      
      onChanged();
      return getProductFieldBuilder().getBuilder();
    }
    /**
     * <code>.Product product = 1;</code>
     */
    public com.in.dashboard.ProductOrBuilder getProductOrBuilder() {
      if (productBuilder_ != null) {
        return productBuilder_.getMessageOrBuilder();
      } else {
        return product_ == null ?
            com.in.dashboard.Product.getDefaultInstance() : product_;
      }
    }
    /**
     * <code>.Product product = 1;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        com.in.dashboard.Product, com.in.dashboard.Product.Builder, com.in.dashboard.ProductOrBuilder> 
        getProductFieldBuilder() {
      if (productBuilder_ == null) {
        productBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            com.in.dashboard.Product, com.in.dashboard.Product.Builder, com.in.dashboard.ProductOrBuilder>(
                getProduct(),
                getParentForChildren(),
                isClean());
        product_ = null;
      }
      return productBuilder_;
    }

    private java.util.List<com.in.dashboard.Product> similarProducts_ =
      java.util.Collections.emptyList();
    private void ensureSimilarProductsIsMutable() {
      if (!((bitField0_ & 0x00000002) == 0x00000002)) {
        similarProducts_ = new java.util.ArrayList<com.in.dashboard.Product>(similarProducts_);
        bitField0_ |= 0x00000002;
       }
    }

    private com.google.protobuf.RepeatedFieldBuilderV3<
        com.in.dashboard.Product, com.in.dashboard.Product.Builder, com.in.dashboard.ProductOrBuilder> similarProductsBuilder_;

    /**
     * <code>repeated .Product similarProducts = 2;</code>
     */
    public java.util.List<com.in.dashboard.Product> getSimilarProductsList() {
      if (similarProductsBuilder_ == null) {
        return java.util.Collections.unmodifiableList(similarProducts_);
      } else {
        return similarProductsBuilder_.getMessageList();
      }
    }
    /**
     * <code>repeated .Product similarProducts = 2;</code>
     */
    public int getSimilarProductsCount() {
      if (similarProductsBuilder_ == null) {
        return similarProducts_.size();
      } else {
        return similarProductsBuilder_.getCount();
      }
    }
    /**
     * <code>repeated .Product similarProducts = 2;</code>
     */
    public com.in.dashboard.Product getSimilarProducts(int index) {
      if (similarProductsBuilder_ == null) {
        return similarProducts_.get(index);
      } else {
        return similarProductsBuilder_.getMessage(index);
      }
    }
    /**
     * <code>repeated .Product similarProducts = 2;</code>
     */
    public Builder setSimilarProducts(
        int index, com.in.dashboard.Product value) {
      if (similarProductsBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureSimilarProductsIsMutable();
        similarProducts_.set(index, value);
        onChanged();
      } else {
        similarProductsBuilder_.setMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .Product similarProducts = 2;</code>
     */
    public Builder setSimilarProducts(
        int index, com.in.dashboard.Product.Builder builderForValue) {
      if (similarProductsBuilder_ == null) {
        ensureSimilarProductsIsMutable();
        similarProducts_.set(index, builderForValue.build());
        onChanged();
      } else {
        similarProductsBuilder_.setMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .Product similarProducts = 2;</code>
     */
    public Builder addSimilarProducts(com.in.dashboard.Product value) {
      if (similarProductsBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureSimilarProductsIsMutable();
        similarProducts_.add(value);
        onChanged();
      } else {
        similarProductsBuilder_.addMessage(value);
      }
      return this;
    }
    /**
     * <code>repeated .Product similarProducts = 2;</code>
     */
    public Builder addSimilarProducts(
        int index, com.in.dashboard.Product value) {
      if (similarProductsBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureSimilarProductsIsMutable();
        similarProducts_.add(index, value);
        onChanged();
      } else {
        similarProductsBuilder_.addMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .Product similarProducts = 2;</code>
     */
    public Builder addSimilarProducts(
        com.in.dashboard.Product.Builder builderForValue) {
      if (similarProductsBuilder_ == null) {
        ensureSimilarProductsIsMutable();
        similarProducts_.add(builderForValue.build());
        onChanged();
      } else {
        similarProductsBuilder_.addMessage(builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .Product similarProducts = 2;</code>
     */
    public Builder addSimilarProducts(
        int index, com.in.dashboard.Product.Builder builderForValue) {
      if (similarProductsBuilder_ == null) {
        ensureSimilarProductsIsMutable();
        similarProducts_.add(index, builderForValue.build());
        onChanged();
      } else {
        similarProductsBuilder_.addMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .Product similarProducts = 2;</code>
     */
    public Builder addAllSimilarProducts(
        java.lang.Iterable<? extends com.in.dashboard.Product> values) {
      if (similarProductsBuilder_ == null) {
        ensureSimilarProductsIsMutable();
        com.google.protobuf.AbstractMessageLite.Builder.addAll(
            values, similarProducts_);
        onChanged();
      } else {
        similarProductsBuilder_.addAllMessages(values);
      }
      return this;
    }
    /**
     * <code>repeated .Product similarProducts = 2;</code>
     */
    public Builder clearSimilarProducts() {
      if (similarProductsBuilder_ == null) {
        similarProducts_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000002);
        onChanged();
      } else {
        similarProductsBuilder_.clear();
      }
      return this;
    }
    /**
     * <code>repeated .Product similarProducts = 2;</code>
     */
    public Builder removeSimilarProducts(int index) {
      if (similarProductsBuilder_ == null) {
        ensureSimilarProductsIsMutable();
        similarProducts_.remove(index);
        onChanged();
      } else {
        similarProductsBuilder_.remove(index);
      }
      return this;
    }
    /**
     * <code>repeated .Product similarProducts = 2;</code>
     */
    public com.in.dashboard.Product.Builder getSimilarProductsBuilder(
        int index) {
      return getSimilarProductsFieldBuilder().getBuilder(index);
    }
    /**
     * <code>repeated .Product similarProducts = 2;</code>
     */
    public com.in.dashboard.ProductOrBuilder getSimilarProductsOrBuilder(
        int index) {
      if (similarProductsBuilder_ == null) {
        return similarProducts_.get(index);  } else {
        return similarProductsBuilder_.getMessageOrBuilder(index);
      }
    }
    /**
     * <code>repeated .Product similarProducts = 2;</code>
     */
    public java.util.List<? extends com.in.dashboard.ProductOrBuilder> 
         getSimilarProductsOrBuilderList() {
      if (similarProductsBuilder_ != null) {
        return similarProductsBuilder_.getMessageOrBuilderList();
      } else {
        return java.util.Collections.unmodifiableList(similarProducts_);
      }
    }
    /**
     * <code>repeated .Product similarProducts = 2;</code>
     */
    public com.in.dashboard.Product.Builder addSimilarProductsBuilder() {
      return getSimilarProductsFieldBuilder().addBuilder(
          com.in.dashboard.Product.getDefaultInstance());
    }
    /**
     * <code>repeated .Product similarProducts = 2;</code>
     */
    public com.in.dashboard.Product.Builder addSimilarProductsBuilder(
        int index) {
      return getSimilarProductsFieldBuilder().addBuilder(
          index, com.in.dashboard.Product.getDefaultInstance());
    }
    /**
     * <code>repeated .Product similarProducts = 2;</code>
     */
    public java.util.List<com.in.dashboard.Product.Builder> 
         getSimilarProductsBuilderList() {
      return getSimilarProductsFieldBuilder().getBuilderList();
    }
    private com.google.protobuf.RepeatedFieldBuilderV3<
        com.in.dashboard.Product, com.in.dashboard.Product.Builder, com.in.dashboard.ProductOrBuilder> 
        getSimilarProductsFieldBuilder() {
      if (similarProductsBuilder_ == null) {
        similarProductsBuilder_ = new com.google.protobuf.RepeatedFieldBuilderV3<
            com.in.dashboard.Product, com.in.dashboard.Product.Builder, com.in.dashboard.ProductOrBuilder>(
                similarProducts_,
                ((bitField0_ & 0x00000002) == 0x00000002),
                getParentForChildren(),
                isClean());
        similarProducts_ = null;
      }
      return similarProductsBuilder_;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFieldsProto3(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:ProductDataResponse)
  }

  // @@protoc_insertion_point(class_scope:ProductDataResponse)
  private static final com.in.dashboard.ProductDataResponse DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.in.dashboard.ProductDataResponse();
  }

  public static com.in.dashboard.ProductDataResponse getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<ProductDataResponse>
      PARSER = new com.google.protobuf.AbstractParser<ProductDataResponse>() {
    @java.lang.Override
    public ProductDataResponse parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new ProductDataResponse(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<ProductDataResponse> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<ProductDataResponse> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.in.dashboard.ProductDataResponse getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

