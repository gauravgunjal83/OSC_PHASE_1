// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Dashboard.proto

package com.in.dashboard;

/**
 * Protobuf type {@code FilterProductRequest}
 */
public  final class FilterProductRequest extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:FilterProductRequest)
    FilterProductRequestOrBuilder {
private static final long serialVersionUID = 0L;
  // Use FilterProductRequest.newBuilder() to construct.
  private FilterProductRequest(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private FilterProductRequest() {
    categoryId_ = "";
    filter_ = 0;
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private FilterProductRequest(
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

            categoryId_ = s;
            break;
          }
          case 16: {
            int rawValue = input.readEnum();

            filter_ = rawValue;
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
    return com.in.dashboard.Dashboard.internal_static_FilterProductRequest_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.in.dashboard.Dashboard.internal_static_FilterProductRequest_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.in.dashboard.FilterProductRequest.class, com.in.dashboard.FilterProductRequest.Builder.class);
  }

  /**
   * Protobuf enum {@code FilterProductRequest.Filter}
   */
  public enum Filter
      implements com.google.protobuf.ProtocolMessageEnum {
    /**
     * <code>P = 0;</code>
     */
    P(0),
    /**
     * <code>LH = 1;</code>
     */
    LH(1),
    /**
     * <code>HL = 2;</code>
     */
    HL(2),
    /**
     * <code>NF = 3;</code>
     */
    NF(3),
    UNRECOGNIZED(-1),
    ;

    /**
     * <code>P = 0;</code>
     */
    public static final int P_VALUE = 0;
    /**
     * <code>LH = 1;</code>
     */
    public static final int LH_VALUE = 1;
    /**
     * <code>HL = 2;</code>
     */
    public static final int HL_VALUE = 2;
    /**
     * <code>NF = 3;</code>
     */
    public static final int NF_VALUE = 3;


    public final int getNumber() {
      if (this == UNRECOGNIZED) {
        throw new java.lang.IllegalArgumentException(
            "Can't get the number of an unknown enum value.");
      }
      return value;
    }

    /**
     * @deprecated Use {@link #forNumber(int)} instead.
     */
    @java.lang.Deprecated
    public static Filter valueOf(int value) {
      return forNumber(value);
    }

    public static Filter forNumber(int value) {
      switch (value) {
        case 0: return P;
        case 1: return LH;
        case 2: return HL;
        case 3: return NF;
        default: return null;
      }
    }

    public static com.google.protobuf.Internal.EnumLiteMap<Filter>
        internalGetValueMap() {
      return internalValueMap;
    }
    private static final com.google.protobuf.Internal.EnumLiteMap<
        Filter> internalValueMap =
          new com.google.protobuf.Internal.EnumLiteMap<Filter>() {
            public Filter findValueByNumber(int number) {
              return Filter.forNumber(number);
            }
          };

    public final com.google.protobuf.Descriptors.EnumValueDescriptor
        getValueDescriptor() {
      return getDescriptor().getValues().get(ordinal());
    }
    public final com.google.protobuf.Descriptors.EnumDescriptor
        getDescriptorForType() {
      return getDescriptor();
    }
    public static final com.google.protobuf.Descriptors.EnumDescriptor
        getDescriptor() {
      return com.in.dashboard.FilterProductRequest.getDescriptor().getEnumTypes().get(0);
    }

    private static final Filter[] VALUES = values();

    public static Filter valueOf(
        com.google.protobuf.Descriptors.EnumValueDescriptor desc) {
      if (desc.getType() != getDescriptor()) {
        throw new java.lang.IllegalArgumentException(
          "EnumValueDescriptor is not for this type.");
      }
      if (desc.getIndex() == -1) {
        return UNRECOGNIZED;
      }
      return VALUES[desc.getIndex()];
    }

    private final int value;

    private Filter(int value) {
      this.value = value;
    }

    // @@protoc_insertion_point(enum_scope:FilterProductRequest.Filter)
  }

  public static final int CATEGORYID_FIELD_NUMBER = 1;
  private volatile java.lang.Object categoryId_;
  /**
   * <code>string categoryId = 1;</code>
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
   * <code>string categoryId = 1;</code>
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

  public static final int FILTER_FIELD_NUMBER = 2;
  private int filter_;
  /**
   * <code>.FilterProductRequest.Filter filter = 2;</code>
   */
  public int getFilterValue() {
    return filter_;
  }
  /**
   * <code>.FilterProductRequest.Filter filter = 2;</code>
   */
  public com.in.dashboard.FilterProductRequest.Filter getFilter() {
    @SuppressWarnings("deprecation")
    com.in.dashboard.FilterProductRequest.Filter result = com.in.dashboard.FilterProductRequest.Filter.valueOf(filter_);
    return result == null ? com.in.dashboard.FilterProductRequest.Filter.UNRECOGNIZED : result;
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
    if (!getCategoryIdBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, categoryId_);
    }
    if (filter_ != com.in.dashboard.FilterProductRequest.Filter.P.getNumber()) {
      output.writeEnum(2, filter_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!getCategoryIdBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, categoryId_);
    }
    if (filter_ != com.in.dashboard.FilterProductRequest.Filter.P.getNumber()) {
      size += com.google.protobuf.CodedOutputStream
        .computeEnumSize(2, filter_);
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
    if (!(obj instanceof com.in.dashboard.FilterProductRequest)) {
      return super.equals(obj);
    }
    com.in.dashboard.FilterProductRequest other = (com.in.dashboard.FilterProductRequest) obj;

    boolean result = true;
    result = result && getCategoryId()
        .equals(other.getCategoryId());
    result = result && filter_ == other.filter_;
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
    hash = (37 * hash) + CATEGORYID_FIELD_NUMBER;
    hash = (53 * hash) + getCategoryId().hashCode();
    hash = (37 * hash) + FILTER_FIELD_NUMBER;
    hash = (53 * hash) + filter_;
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.in.dashboard.FilterProductRequest parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.in.dashboard.FilterProductRequest parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.in.dashboard.FilterProductRequest parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.in.dashboard.FilterProductRequest parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.in.dashboard.FilterProductRequest parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.in.dashboard.FilterProductRequest parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.in.dashboard.FilterProductRequest parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.in.dashboard.FilterProductRequest parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.in.dashboard.FilterProductRequest parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.in.dashboard.FilterProductRequest parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.in.dashboard.FilterProductRequest parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.in.dashboard.FilterProductRequest parseFrom(
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
  public static Builder newBuilder(com.in.dashboard.FilterProductRequest prototype) {
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
   * Protobuf type {@code FilterProductRequest}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:FilterProductRequest)
      com.in.dashboard.FilterProductRequestOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.in.dashboard.Dashboard.internal_static_FilterProductRequest_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.in.dashboard.Dashboard.internal_static_FilterProductRequest_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.in.dashboard.FilterProductRequest.class, com.in.dashboard.FilterProductRequest.Builder.class);
    }

    // Construct using com.in.dashboard.FilterProductRequest.newBuilder()
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
      categoryId_ = "";

      filter_ = 0;

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.in.dashboard.Dashboard.internal_static_FilterProductRequest_descriptor;
    }

    @java.lang.Override
    public com.in.dashboard.FilterProductRequest getDefaultInstanceForType() {
      return com.in.dashboard.FilterProductRequest.getDefaultInstance();
    }

    @java.lang.Override
    public com.in.dashboard.FilterProductRequest build() {
      com.in.dashboard.FilterProductRequest result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.in.dashboard.FilterProductRequest buildPartial() {
      com.in.dashboard.FilterProductRequest result = new com.in.dashboard.FilterProductRequest(this);
      result.categoryId_ = categoryId_;
      result.filter_ = filter_;
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
      if (other instanceof com.in.dashboard.FilterProductRequest) {
        return mergeFrom((com.in.dashboard.FilterProductRequest)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.in.dashboard.FilterProductRequest other) {
      if (other == com.in.dashboard.FilterProductRequest.getDefaultInstance()) return this;
      if (!other.getCategoryId().isEmpty()) {
        categoryId_ = other.categoryId_;
        onChanged();
      }
      if (other.filter_ != 0) {
        setFilterValue(other.getFilterValue());
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
      com.in.dashboard.FilterProductRequest parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.in.dashboard.FilterProductRequest) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private java.lang.Object categoryId_ = "";
    /**
     * <code>string categoryId = 1;</code>
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
     * <code>string categoryId = 1;</code>
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
     * <code>string categoryId = 1;</code>
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
     * <code>string categoryId = 1;</code>
     */
    public Builder clearCategoryId() {
      
      categoryId_ = getDefaultInstance().getCategoryId();
      onChanged();
      return this;
    }
    /**
     * <code>string categoryId = 1;</code>
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

    private int filter_ = 0;
    /**
     * <code>.FilterProductRequest.Filter filter = 2;</code>
     */
    public int getFilterValue() {
      return filter_;
    }
    /**
     * <code>.FilterProductRequest.Filter filter = 2;</code>
     */
    public Builder setFilterValue(int value) {
      filter_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>.FilterProductRequest.Filter filter = 2;</code>
     */
    public com.in.dashboard.FilterProductRequest.Filter getFilter() {
      @SuppressWarnings("deprecation")
      com.in.dashboard.FilterProductRequest.Filter result = com.in.dashboard.FilterProductRequest.Filter.valueOf(filter_);
      return result == null ? com.in.dashboard.FilterProductRequest.Filter.UNRECOGNIZED : result;
    }
    /**
     * <code>.FilterProductRequest.Filter filter = 2;</code>
     */
    public Builder setFilter(com.in.dashboard.FilterProductRequest.Filter value) {
      if (value == null) {
        throw new NullPointerException();
      }
      
      filter_ = value.getNumber();
      onChanged();
      return this;
    }
    /**
     * <code>.FilterProductRequest.Filter filter = 2;</code>
     */
    public Builder clearFilter() {
      
      filter_ = 0;
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


    // @@protoc_insertion_point(builder_scope:FilterProductRequest)
  }

  // @@protoc_insertion_point(class_scope:FilterProductRequest)
  private static final com.in.dashboard.FilterProductRequest DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.in.dashboard.FilterProductRequest();
  }

  public static com.in.dashboard.FilterProductRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<FilterProductRequest>
      PARSER = new com.google.protobuf.AbstractParser<FilterProductRequest>() {
    @java.lang.Override
    public FilterProductRequest parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new FilterProductRequest(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<FilterProductRequest> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<FilterProductRequest> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.in.dashboard.FilterProductRequest getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}
