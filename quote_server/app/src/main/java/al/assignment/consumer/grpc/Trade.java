// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: consumer.proto

package al.assignment.consumer.grpc;

/**
 * Protobuf type {@code Trade}
 */
public final class Trade extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:Trade)
    TradeOrBuilder {
private static final long serialVersionUID = 0L;
  // Use Trade.newBuilder() to construct.
  private Trade(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private Trade() {
    price_ = "";
    quantity_ = "";
  }

  @Override
  @SuppressWarnings({"unused"})
  protected Object newInstance(
      UnusedPrivateParameter unused) {
    return new Trade();
  }

  @Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private Trade(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new NullPointerException();
    }
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
          case 8: {

            isBuy_ = input.readBool();
            break;
          }
          case 18: {
            String s = input.readStringRequireUtf8();

            price_ = s;
            break;
          }
          case 26: {
            String s = input.readStringRequireUtf8();

            quantity_ = s;
            break;
          }
          default: {
            if (!parseUnknownField(
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
    return ConsumerInterface.internal_static_Trade_descriptor;
  }

  @Override
  protected FieldAccessorTable
      internalGetFieldAccessorTable() {
    return ConsumerInterface.internal_static_Trade_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            Trade.class, Builder.class);
  }

  public static final int ISBUY_FIELD_NUMBER = 1;
  private boolean isBuy_;
  /**
   * <code>bool isBuy = 1;</code>
   * @return The isBuy.
   */
  @Override
  public boolean getIsBuy() {
    return isBuy_;
  }

  public static final int PRICE_FIELD_NUMBER = 2;
  private volatile Object price_;
  /**
   * <code>string price = 2;</code>
   * @return The price.
   */
  @Override
  public String getPrice() {
    Object ref = price_;
    if (ref instanceof String) {
      return (String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      String s = bs.toStringUtf8();
      price_ = s;
      return s;
    }
  }
  /**
   * <code>string price = 2;</code>
   * @return The bytes for price.
   */
  @Override
  public com.google.protobuf.ByteString
      getPriceBytes() {
    Object ref = price_;
    if (ref instanceof String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (String) ref);
      price_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int QUANTITY_FIELD_NUMBER = 3;
  private volatile Object quantity_;
  /**
   * <code>string quantity = 3;</code>
   * @return The quantity.
   */
  @Override
  public String getQuantity() {
    Object ref = quantity_;
    if (ref instanceof String) {
      return (String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      String s = bs.toStringUtf8();
      quantity_ = s;
      return s;
    }
  }
  /**
   * <code>string quantity = 3;</code>
   * @return The bytes for quantity.
   */
  @Override
  public com.google.protobuf.ByteString
      getQuantityBytes() {
    Object ref = quantity_;
    if (ref instanceof String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (String) ref);
      quantity_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  private byte memoizedIsInitialized = -1;
  @Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (isBuy_ != false) {
      output.writeBool(1, isBuy_);
    }
    if (!getPriceBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 2, price_);
    }
    if (!getQuantityBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 3, quantity_);
    }
    unknownFields.writeTo(output);
  }

  @Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (isBuy_ != false) {
      size += com.google.protobuf.CodedOutputStream
        .computeBoolSize(1, isBuy_);
    }
    if (!getPriceBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, price_);
    }
    if (!getQuantityBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(3, quantity_);
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof Trade)) {
      return super.equals(obj);
    }
    Trade other = (Trade) obj;

    if (getIsBuy()
        != other.getIsBuy()) return false;
    if (!getPrice()
        .equals(other.getPrice())) return false;
    if (!getQuantity()
        .equals(other.getQuantity())) return false;
    if (!unknownFields.equals(other.unknownFields)) return false;
    return true;
  }

  @Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + ISBUY_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashBoolean(
        getIsBuy());
    hash = (37 * hash) + PRICE_FIELD_NUMBER;
    hash = (53 * hash) + getPrice().hashCode();
    hash = (37 * hash) + QUANTITY_FIELD_NUMBER;
    hash = (53 * hash) + getQuantity().hashCode();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static Trade parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static Trade parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static Trade parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static Trade parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static Trade parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static Trade parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static Trade parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static Trade parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static Trade parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static Trade parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static Trade parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static Trade parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(Trade prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @Override
  protected Builder newBuilderForType(
      BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code Trade}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:Trade)
      TradeOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return ConsumerInterface.internal_static_Trade_descriptor;
    }

    @Override
    protected FieldAccessorTable
        internalGetFieldAccessorTable() {
      return ConsumerInterface.internal_static_Trade_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              Trade.class, Builder.class);
    }

    // Construct using al.assignment.consumer.grpc.Trade.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
      }
    }
    @Override
    public Builder clear() {
      super.clear();
      isBuy_ = false;

      price_ = "";

      quantity_ = "";

      return this;
    }

    @Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return ConsumerInterface.internal_static_Trade_descriptor;
    }

    @Override
    public Trade getDefaultInstanceForType() {
      return Trade.getDefaultInstance();
    }

    @Override
    public Trade build() {
      Trade result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @Override
    public Trade buildPartial() {
      Trade result = new Trade(this);
      result.isBuy_ = isBuy_;
      result.price_ = price_;
      result.quantity_ = quantity_;
      onBuilt();
      return result;
    }

    @Override
    public Builder clone() {
      return super.clone();
    }
    @Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        Object value) {
      return super.setField(field, value);
    }
    @Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return super.clearField(field);
    }
    @Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return super.clearOneof(oneof);
    }
    @Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, Object value) {
      return super.setRepeatedField(field, index, value);
    }
    @Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        Object value) {
      return super.addRepeatedField(field, value);
    }
    @Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof Trade) {
        return mergeFrom((Trade)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(Trade other) {
      if (other == Trade.getDefaultInstance()) return this;
      if (other.getIsBuy() != false) {
        setIsBuy(other.getIsBuy());
      }
      if (!other.getPrice().isEmpty()) {
        price_ = other.price_;
        onChanged();
      }
      if (!other.getQuantity().isEmpty()) {
        quantity_ = other.quantity_;
        onChanged();
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    @Override
    public final boolean isInitialized() {
      return true;
    }

    @Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      Trade parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (Trade) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private boolean isBuy_ ;
    /**
     * <code>bool isBuy = 1;</code>
     * @return The isBuy.
     */
    @Override
    public boolean getIsBuy() {
      return isBuy_;
    }
    /**
     * <code>bool isBuy = 1;</code>
     * @param value The isBuy to set.
     * @return This builder for chaining.
     */
    public Builder setIsBuy(boolean value) {
      
      isBuy_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>bool isBuy = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearIsBuy() {
      
      isBuy_ = false;
      onChanged();
      return this;
    }

    private Object price_ = "";
    /**
     * <code>string price = 2;</code>
     * @return The price.
     */
    public String getPrice() {
      Object ref = price_;
      if (!(ref instanceof String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        String s = bs.toStringUtf8();
        price_ = s;
        return s;
      } else {
        return (String) ref;
      }
    }
    /**
     * <code>string price = 2;</code>
     * @return The bytes for price.
     */
    public com.google.protobuf.ByteString
        getPriceBytes() {
      Object ref = price_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (String) ref);
        price_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string price = 2;</code>
     * @param value The price to set.
     * @return This builder for chaining.
     */
    public Builder setPrice(
        String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      price_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string price = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearPrice() {
      
      price_ = getDefaultInstance().getPrice();
      onChanged();
      return this;
    }
    /**
     * <code>string price = 2;</code>
     * @param value The bytes for price to set.
     * @return This builder for chaining.
     */
    public Builder setPriceBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      price_ = value;
      onChanged();
      return this;
    }

    private Object quantity_ = "";
    /**
     * <code>string quantity = 3;</code>
     * @return The quantity.
     */
    public String getQuantity() {
      Object ref = quantity_;
      if (!(ref instanceof String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        String s = bs.toStringUtf8();
        quantity_ = s;
        return s;
      } else {
        return (String) ref;
      }
    }
    /**
     * <code>string quantity = 3;</code>
     * @return The bytes for quantity.
     */
    public com.google.protobuf.ByteString
        getQuantityBytes() {
      Object ref = quantity_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (String) ref);
        quantity_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string quantity = 3;</code>
     * @param value The quantity to set.
     * @return This builder for chaining.
     */
    public Builder setQuantity(
        String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      quantity_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string quantity = 3;</code>
     * @return This builder for chaining.
     */
    public Builder clearQuantity() {
      
      quantity_ = getDefaultInstance().getQuantity();
      onChanged();
      return this;
    }
    /**
     * <code>string quantity = 3;</code>
     * @param value The bytes for quantity to set.
     * @return This builder for chaining.
     */
    public Builder setQuantityBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      quantity_ = value;
      onChanged();
      return this;
    }
    @Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    @Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:Trade)
  }

  // @@protoc_insertion_point(class_scope:Trade)
  private static final Trade DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new Trade();
  }

  public static Trade getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<Trade>
      PARSER = new com.google.protobuf.AbstractParser<Trade>() {
    @Override
    public Trade parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new Trade(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<Trade> parser() {
    return PARSER;
  }

  @Override
  public com.google.protobuf.Parser<Trade> getParserForType() {
    return PARSER;
  }

  @Override
  public Trade getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

