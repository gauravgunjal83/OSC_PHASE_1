// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Dashboard.proto

package com.in.dashboard;

/**
 * Protobuf type {@code Product}
 */
public  final class Product extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:Product)
    ProductOrBuilder {
private static final long serialVersionUID = 0L;
  // Use Product.newBuilder() to construct.
  private Product(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private Product() {
    productId_ = "";
    categoryId_ = "";
    productName_ = "";
    productDesc_ = "";
    productPrice_ = 0D;
    imagePath_ = "";
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private Product(
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
            java.lang.String s = input.readStringRequireUtf8();

            productId_ = s;
            break;
          }
          case 18: {
            java.lang.String s = input.readStringRequireUtf8();

            categoryId_ = s;
            break;
          }
          case 26: {
            java.lang.String s = input.readStringRequireUtf8();

            productName_ = s;
            break;
          }
          case 34: {
            java.lang.String s = input.readStringRequireUtf8();

            productDesc_ = s;
            break;
          }
          case 41: {

            productPrice_ = input.readDouble();
            break;
          }
          case 50: {
            java.lang.String s = input.readStringRequireUtf8();

            imagePath_ = s;
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
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return com.in.dashboard.Dashboard.internal_static_Product_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.in.dashboard.Dashboard.internal_static_Product_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.in.dashboard.Product.class, com.in.dashboard.Product.Builder.class);
  }

  public static final int PRODUCTID_FIELD_NUMBER = 1;
  private volatile java.lang.Object productId_;
  /**
   * <code>string productId = 1;</code>
   */
  public java.lang.String getProductId() {
    java.lang.Object ref = productId_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      productId_ = s;
      return s;
    }
  }
  /**
   * <code>string productId = 1;</code>
   */
  public com.google.protobuf.ByteString
      getProductIdBytes() {
    java.lang.Object ref = productId_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      productId_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int CATEGORYID_FIELD_NUMBER = 2;
  private volatile java.lang.Object categoryId_;
  /**
   * <code>string categoryId = 2;</code>
   */
  public java.lang.String getCategoryId() {
    java.lang.Object ref = categoryId_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      categoryId_ = s;
      return s;
    }
  }
  /**
   * <code>string categoryId = 2;</code>
   */
  public com.google.protobuf.ByteString
      getCategoryIdBytes() {
    java.lang.Object ref = categoryId_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      categoryId_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int PRODUCTNAME_FIELD_NUMBER = 3;
  private volatile java.lang.Object productName_;
  /**
   * <code>string productName = 3;</code>
   */
  public java.lang.String getProductName() {
    java.lang.Object ref = productName_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      productName_ = s;
      return s;
    }
  }
  /**
   * <code>string productName = 3;</code>
   */
  public com.google.protobuf.ByteString
      getProductNameBytes() {
    java.lang.Object ref = productName_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      productName_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int PRODUCTDESC_FIELD_NUMBER = 4;
  private volatile java.lang.Object productDesc_;
  /**
   * <code>string productDesc = 4;</code>
   */
  public java.lang.String getProductDesc() {
    java.lang.Object ref = productDesc_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      productDesc_ = s;
      return s;
    }
  }
  /**
   * <code>string productDesc = 4;</code>
   */
  public com.google.protobuf.ByteString
      getProductDescBytes() {
    java.lang.Object ref = productDesc_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      productDesc_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int PRODUCTPRICE_FIELD_NUMBER = 5;
  private double productPrice_;
  /**
   * <code>double productPrice = 5;</code>
   */
  public double getProductPrice() {
    return productPrice_;
  }

  public static final int IMAGEPATH_FIELD_NUMBER = 6;
  private volatile java.lang.Object imagePath_;
  /**
   * <code>string imagePath = 6;</code>
   */
  public java.lang.String getImagePath() {
    java.lang.Object ref = imagePath_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      imagePath_ = s;
      return s;
    }
  }
  /**
   * <code>string imagePath = 6;</code>
   */
  public com.google.protobuf.ByteString
      getImagePathBytes() {
    java.lang.Object ref = imagePath_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      imagePath_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
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
    if (!getProductIdBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, productId_);
    }
    if (!getCategoryIdBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 2, categoryId_);
    }
    if (!getProductNameBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 3, productName_);
    }
    if (!getProductDescBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 4, productDesc_);
    }
    if (productPrice_ != 0D) {
      output.writeDouble(5, productPrice_);
    }
    if (!getImagePathBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 6, imagePath_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!getProductIdBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, productId_);
    }
    if (!getCategoryIdBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, categoryId_);
    }
    if (!getProductNameBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(3, productName_);
    }
    if (!getProductDescBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(4, productDesc_);
    }
    if (productPrice_ != 0D) {
      size += com.google.protobuf.CodedOutputStream
        .computeDoubleSize(5, productPrice_);
    }
    if (!getImagePathBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(6, imagePath_);
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
    if (!(obj instanceof com.in.dashboard.Product)) {
      return super.equals(obj);
    }
    com.in.dashboard.Product other = (com.in.dashboard.Product) obj;

    boolean result = true;
    result = result && getProductId()
        .equals(other.getProductId());
    result = result && getCategoryId()
        .equals(other.getCategoryId());
    result = result && getProductName()
        .equals(other.getProductName());
    result = result && getProductDesc()
        .equals(other.getProductDesc());
    result = result && (
        java.lang.Double.doubleToLongBits(getProductPrice())
        == java.lang.Double.doubleToLongBits(
            other.getProductPrice()));
    result = result && getImagePath()
        .equals(other.getImagePath());
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
    hash = (37 * hash) + PRODUCTID_FIELD_NUMBER;
    hash = (53 * hash) + getProductId().hashCode();
    hash = (37 * hash) + CATEGORYID_FIELD_NUMBER;
    hash = (53 * hash) + getCategoryId().hashCode();
    hash = (37 * hash) + PRODUCTNAME_FIELD_NUMBER;
    hash = (53 * hash) + getProductName().hashCode();
    hash = (37 * hash) + PRODUCTDESC_FIELD_NUMBER;
    hash = (53 * hash) + getProductDesc().hashCode();
    hash = (37 * hash) + PRODUCTPRICE_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        java.lang.Double.doubleToLongBits(getProductPrice()));
    hash = (37 * hash) + IMAGEPATH_FIELD_NUMBER;
    hash = (53 * hash) + getImagePath().hashCode();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.in.dashboard.Product parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.in.dashboard.Product parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.in.dashboard.Product parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.in.dashboard.Product parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.in.dashboard.Product parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.in.dashboard.Product parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.in.dashboard.Product parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.in.dashboard.Product parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.in.dashboard.Product parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.in.dashboard.Product parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.in.dashboard.Product parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.in.dashboard.Product parseFrom(
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
  public static Builder newBuilder(com.in.dashboard.Product prototype) {
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
   * Protobuf type {@code Product}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:Product)
      com.in.dashboard.ProductOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.in.dashboard.Dashboard.internal_static_Product_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.in.dashboard.Dashboard.internal_static_Product_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.in.dashboard.Product.class, com.in.dashboard.Product.Builder.class);
    }

    // Construct using com.in.dashboard.Product.newBuilder()
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
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      productId_ = "";

      categoryId_ = "";

      productName_ = "";

      productDesc_ = "";

      productPrice_ = 0D;

      imagePath_ = "";

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.in.dashboard.Dashboard.internal_static_Product_descriptor;
    }

    @java.lang.Override
    public com.in.dashboard.Product getDefaultInstanceForType() {
      return com.in.dashboard.Product.getDefaultInstance();
    }

    @java.lang.Override
    public com.in.dashboard.Product build() {
      com.in.dashboard.Product result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.in.dashboard.Product buildPartial() {
      com.in.dashboard.Product result = new com.in.dashboard.Product(this);
      result.productId_ = productId_;
      result.categoryId_ = categoryId_;
      result.productName_ = productName_;
      result.productDesc_ = productDesc_;
      result.productPrice_ = productPrice_;
      result.imagePath_ = imagePath_;
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
      if (other instanceof com.in.dashboard.Product) {
        return mergeFrom((com.in.dashboard.Product)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.in.dashboard.Product other) {
      if (other == com.in.dashboard.Product.getDefaultInstance()) return this;
      if (!other.getProductId().isEmpty()) {
        productId_ = other.productId_;
        onChanged();
      }
      if (!other.getCategoryId().isEmpty()) {
        categoryId_ = other.categoryId_;
        onChanged();
      }
      if (!other.getProductName().isEmpty()) {
        productName_ = other.productName_;
        onChanged();
      }
      if (!other.getProductDesc().isEmpty()) {
        productDesc_ = other.productDesc_;
        onChanged();
      }
      if (other.getProductPrice() != 0D) {
        setProductPrice(other.getProductPrice());
      }
      if (!other.getImagePath().isEmpty()) {
        imagePath_ = other.imagePath_;
        onChanged();
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
      com.in.dashboard.Product parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.in.dashboard.Product) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private java.lang.Object productId_ = "";
    /**
     * <code>string productId = 1;</code>
     */
    public java.lang.String getProductId() {
      java.lang.Object ref = productId_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        productId_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string productId = 1;</code>
     */
    public com.google.protobuf.ByteString
        getProductIdBytes() {
      java.lang.Object ref = productId_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        productId_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string productId = 1;</code>
     */
    public Builder setProductId(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      productId_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string productId = 1;</code>
     */
    public Builder clearProductId() {
      
      productId_ = getDefaultInstance().getProductId();
      onChanged();
      return this;
    }
    /**
     * <code>string productId = 1;</code>
     */
    public Builder setProductIdBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      productId_ = value;
      onChanged();
      return this;
    }

    private java.lang.Object categoryId_ = "";
    /**
     * <code>string categoryId = 2;</code>
     */
    public java.lang.String getCategoryId() {
      java.lang.Object ref = categoryId_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        categoryId_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string categoryId = 2;</code>
     */
    public com.google.protobuf.ByteString
        getCategoryIdBytes() {
      java.lang.Object ref = categoryId_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        categoryId_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string categoryId = 2;</code>
     */
    public Builder setCategoryId(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      categoryId_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string categoryId = 2;</code>
     */
    public Builder clearCategoryId() {
      
      categoryId_ = getDefaultInstance().getCategoryId();
      onChanged();
      return this;
    }
    /**
     * <code>string categoryId = 2;</code>
     */
    public Builder setCategoryIdBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      categoryId_ = value;
      onChanged();
      return this;
    }

    private java.lang.Object productName_ = "";
    /**
     * <code>string productName = 3;</code>
     */
    public java.lang.String getProductName() {
      java.lang.Object ref = productName_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        productName_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string productName = 3;</code>
     */
    public com.google.protobuf.ByteString
        getProductNameBytes() {
      java.lang.Object ref = productName_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        productName_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string productName = 3;</code>
     */
    public Builder setProductName(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      productName_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string productName = 3;</code>
     */
    public Builder clearProductName() {
      
      productName_ = getDefaultInstance().getProductName();
      onChanged();
      return this;
    }
    /**
     * <code>string productName = 3;</code>
     */
    public Builder setProductNameBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      productName_ = value;
      onChanged();
      return this;
    }

    private java.lang.Object productDesc_ = "";
    /**
     * <code>string productDesc = 4;</code>
     */
    public java.lang.String getProductDesc() {
      java.lang.Object ref = productDesc_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        productDesc_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string productDesc = 4;</code>
     */
    public com.google.protobuf.ByteString
        getProductDescBytes() {
      java.lang.Object ref = productDesc_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        productDesc_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string productDesc = 4;</code>
     */
    public Builder setProductDesc(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      productDesc_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string productDesc = 4;</code>
     */
    public Builder clearProductDesc() {
      
      productDesc_ = getDefaultInstance().getProductDesc();
      onChanged();
      return this;
    }
    /**
     * <code>string productDesc = 4;</code>
     */
    public Builder setProductDescBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      productDesc_ = value;
      onChanged();
      return this;
    }

    private double productPrice_ ;
    /**
     * <code>double productPrice = 5;</code>
     */
    public double getProductPrice() {
      return productPrice_;
    }
    /**
     * <code>double productPrice = 5;</code>
     */
    public Builder setProductPrice(double value) {
      
      productPrice_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>double productPrice = 5;</code>
     */
    public Builder clearProductPrice() {
      
      productPrice_ = 0D;
      onChanged();
      return this;
    }

    private java.lang.Object imagePath_ = "";
    /**
     * <code>string imagePath = 6;</code>
     */
    public java.lang.String getImagePath() {
      java.lang.Object ref = imagePath_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        imagePath_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string imagePath = 6;</code>
     */
    public com.google.protobuf.ByteString
        getImagePathBytes() {
      java.lang.Object ref = imagePath_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        imagePath_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string imagePath = 6;</code>
     */
    public Builder setImagePath(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      imagePath_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string imagePath = 6;</code>
     */
    public Builder clearImagePath() {
      
      imagePath_ = getDefaultInstance().getImagePath();
      onChanged();
      return this;
    }
    /**
     * <code>string imagePath = 6;</code>
     */
    public Builder setImagePathBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      imagePath_ = value;
      onChanged();
      return this;
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


    // @@protoc_insertion_point(builder_scope:Product)
  }

  // @@protoc_insertion_point(class_scope:Product)
  private static final com.in.dashboard.Product DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.in.dashboard.Product();
  }

  public static com.in.dashboard.Product getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<Product>
      PARSER = new com.google.protobuf.AbstractParser<Product>() {
    @java.lang.Override
    public Product parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new Product(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<Product> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<Product> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.in.dashboard.Product getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

