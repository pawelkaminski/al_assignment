// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: subscriber.proto

package al.assignment.subscriber.grpc;

/**
 * Protobuf type {@code Subscriptions}
 */
public final class Subscriptions extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:Subscriptions)
    SubscriptionsOrBuilder {
private static final long serialVersionUID = 0L;
  // Use Subscriptions.newBuilder() to construct.
  private Subscriptions(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private Subscriptions() {
    host_ = "";
    port_ = "";
    subscription_ = com.google.protobuf.LazyStringArrayList.EMPTY;
  }

  @Override
  @SuppressWarnings({"unused"})
  protected Object newInstance(
      UnusedPrivateParameter unused) {
    return new Subscriptions();
  }

  @Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private Subscriptions(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new NullPointerException();
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
            String s = input.readStringRequireUtf8();

            host_ = s;
            break;
          }
          case 18: {
            String s = input.readStringRequireUtf8();

            port_ = s;
            break;
          }
          case 26: {
            String s = input.readStringRequireUtf8();
            if (!((mutable_bitField0_ & 0x00000001) != 0)) {
              subscription_ = new com.google.protobuf.LazyStringArrayList();
              mutable_bitField0_ |= 0x00000001;
            }
            subscription_.add(s);
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
      if (((mutable_bitField0_ & 0x00000001) != 0)) {
        subscription_ = subscription_.getUnmodifiableView();
      }
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return QuotaServiceProto.internal_static_Subscriptions_descriptor;
  }

  @Override
  protected FieldAccessorTable
      internalGetFieldAccessorTable() {
    return QuotaServiceProto.internal_static_Subscriptions_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            Subscriptions.class, Builder.class);
  }

  public static final int HOST_FIELD_NUMBER = 1;
  private volatile Object host_;
  /**
   * <code>string host = 1;</code>
   * @return The host.
   */
  @Override
  public String getHost() {
    Object ref = host_;
    if (ref instanceof String) {
      return (String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      String s = bs.toStringUtf8();
      host_ = s;
      return s;
    }
  }
  /**
   * <code>string host = 1;</code>
   * @return The bytes for host.
   */
  @Override
  public com.google.protobuf.ByteString
      getHostBytes() {
    Object ref = host_;
    if (ref instanceof String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (String) ref);
      host_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int PORT_FIELD_NUMBER = 2;
  private volatile Object port_;
  /**
   * <code>string port = 2;</code>
   * @return The port.
   */
  @Override
  public String getPort() {
    Object ref = port_;
    if (ref instanceof String) {
      return (String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      String s = bs.toStringUtf8();
      port_ = s;
      return s;
    }
  }
  /**
   * <code>string port = 2;</code>
   * @return The bytes for port.
   */
  @Override
  public com.google.protobuf.ByteString
      getPortBytes() {
    Object ref = port_;
    if (ref instanceof String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (String) ref);
      port_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int SUBSCRIPTION_FIELD_NUMBER = 3;
  private com.google.protobuf.LazyStringList subscription_;
  /**
   * <code>repeated string subscription = 3;</code>
   * @return A list containing the subscription.
   */
  public com.google.protobuf.ProtocolStringList
      getSubscriptionList() {
    return subscription_;
  }
  /**
   * <code>repeated string subscription = 3;</code>
   * @return The count of subscription.
   */
  public int getSubscriptionCount() {
    return subscription_.size();
  }
  /**
   * <code>repeated string subscription = 3;</code>
   * @param index The index of the element to return.
   * @return The subscription at the given index.
   */
  public String getSubscription(int index) {
    return subscription_.get(index);
  }
  /**
   * <code>repeated string subscription = 3;</code>
   * @param index The index of the value to return.
   * @return The bytes of the subscription at the given index.
   */
  public com.google.protobuf.ByteString
      getSubscriptionBytes(int index) {
    return subscription_.getByteString(index);
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
    if (!getHostBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, host_);
    }
    if (!getPortBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 2, port_);
    }
    for (int i = 0; i < subscription_.size(); i++) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 3, subscription_.getRaw(i));
    }
    unknownFields.writeTo(output);
  }

  @Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!getHostBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, host_);
    }
    if (!getPortBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, port_);
    }
    {
      int dataSize = 0;
      for (int i = 0; i < subscription_.size(); i++) {
        dataSize += computeStringSizeNoTag(subscription_.getRaw(i));
      }
      size += dataSize;
      size += 1 * getSubscriptionList().size();
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
    if (!(obj instanceof Subscriptions)) {
      return super.equals(obj);
    }
    Subscriptions other = (Subscriptions) obj;

    if (!getHost()
        .equals(other.getHost())) return false;
    if (!getPort()
        .equals(other.getPort())) return false;
    if (!getSubscriptionList()
        .equals(other.getSubscriptionList())) return false;
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
    hash = (37 * hash) + HOST_FIELD_NUMBER;
    hash = (53 * hash) + getHost().hashCode();
    hash = (37 * hash) + PORT_FIELD_NUMBER;
    hash = (53 * hash) + getPort().hashCode();
    if (getSubscriptionCount() > 0) {
      hash = (37 * hash) + SUBSCRIPTION_FIELD_NUMBER;
      hash = (53 * hash) + getSubscriptionList().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static Subscriptions parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static Subscriptions parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static Subscriptions parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static Subscriptions parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static Subscriptions parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static Subscriptions parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static Subscriptions parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static Subscriptions parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static Subscriptions parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static Subscriptions parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static Subscriptions parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static Subscriptions parseFrom(
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
  public static Builder newBuilder(Subscriptions prototype) {
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
   * Protobuf type {@code Subscriptions}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:Subscriptions)
      SubscriptionsOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return QuotaServiceProto.internal_static_Subscriptions_descriptor;
    }

    @Override
    protected FieldAccessorTable
        internalGetFieldAccessorTable() {
      return QuotaServiceProto.internal_static_Subscriptions_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              Subscriptions.class, Builder.class);
    }

    // Construct using al.assignment.subscriber.grpc.Subscriptions.newBuilder()
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
      host_ = "";

      port_ = "";

      subscription_ = com.google.protobuf.LazyStringArrayList.EMPTY;
      bitField0_ = (bitField0_ & ~0x00000001);
      return this;
    }

    @Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return QuotaServiceProto.internal_static_Subscriptions_descriptor;
    }

    @Override
    public Subscriptions getDefaultInstanceForType() {
      return Subscriptions.getDefaultInstance();
    }

    @Override
    public Subscriptions build() {
      Subscriptions result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @Override
    public Subscriptions buildPartial() {
      Subscriptions result = new Subscriptions(this);
      int from_bitField0_ = bitField0_;
      result.host_ = host_;
      result.port_ = port_;
      if (((bitField0_ & 0x00000001) != 0)) {
        subscription_ = subscription_.getUnmodifiableView();
        bitField0_ = (bitField0_ & ~0x00000001);
      }
      result.subscription_ = subscription_;
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
      if (other instanceof Subscriptions) {
        return mergeFrom((Subscriptions)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(Subscriptions other) {
      if (other == Subscriptions.getDefaultInstance()) return this;
      if (!other.getHost().isEmpty()) {
        host_ = other.host_;
        onChanged();
      }
      if (!other.getPort().isEmpty()) {
        port_ = other.port_;
        onChanged();
      }
      if (!other.subscription_.isEmpty()) {
        if (subscription_.isEmpty()) {
          subscription_ = other.subscription_;
          bitField0_ = (bitField0_ & ~0x00000001);
        } else {
          ensureSubscriptionIsMutable();
          subscription_.addAll(other.subscription_);
        }
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
      Subscriptions parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (Subscriptions) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    private Object host_ = "";
    /**
     * <code>string host = 1;</code>
     * @return The host.
     */
    public String getHost() {
      Object ref = host_;
      if (!(ref instanceof String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        String s = bs.toStringUtf8();
        host_ = s;
        return s;
      } else {
        return (String) ref;
      }
    }
    /**
     * <code>string host = 1;</code>
     * @return The bytes for host.
     */
    public com.google.protobuf.ByteString
        getHostBytes() {
      Object ref = host_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (String) ref);
        host_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string host = 1;</code>
     * @param value The host to set.
     * @return This builder for chaining.
     */
    public Builder setHost(
        String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      host_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string host = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearHost() {
      
      host_ = getDefaultInstance().getHost();
      onChanged();
      return this;
    }
    /**
     * <code>string host = 1;</code>
     * @param value The bytes for host to set.
     * @return This builder for chaining.
     */
    public Builder setHostBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      host_ = value;
      onChanged();
      return this;
    }

    private Object port_ = "";
    /**
     * <code>string port = 2;</code>
     * @return The port.
     */
    public String getPort() {
      Object ref = port_;
      if (!(ref instanceof String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        String s = bs.toStringUtf8();
        port_ = s;
        return s;
      } else {
        return (String) ref;
      }
    }
    /**
     * <code>string port = 2;</code>
     * @return The bytes for port.
     */
    public com.google.protobuf.ByteString
        getPortBytes() {
      Object ref = port_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (String) ref);
        port_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string port = 2;</code>
     * @param value The port to set.
     * @return This builder for chaining.
     */
    public Builder setPort(
        String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      port_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string port = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearPort() {
      
      port_ = getDefaultInstance().getPort();
      onChanged();
      return this;
    }
    /**
     * <code>string port = 2;</code>
     * @param value The bytes for port to set.
     * @return This builder for chaining.
     */
    public Builder setPortBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      port_ = value;
      onChanged();
      return this;
    }

    private com.google.protobuf.LazyStringList subscription_ = com.google.protobuf.LazyStringArrayList.EMPTY;
    private void ensureSubscriptionIsMutable() {
      if (!((bitField0_ & 0x00000001) != 0)) {
        subscription_ = new com.google.protobuf.LazyStringArrayList(subscription_);
        bitField0_ |= 0x00000001;
       }
    }
    /**
     * <code>repeated string subscription = 3;</code>
     * @return A list containing the subscription.
     */
    public com.google.protobuf.ProtocolStringList
        getSubscriptionList() {
      return subscription_.getUnmodifiableView();
    }
    /**
     * <code>repeated string subscription = 3;</code>
     * @return The count of subscription.
     */
    public int getSubscriptionCount() {
      return subscription_.size();
    }
    /**
     * <code>repeated string subscription = 3;</code>
     * @param index The index of the element to return.
     * @return The subscription at the given index.
     */
    public String getSubscription(int index) {
      return subscription_.get(index);
    }
    /**
     * <code>repeated string subscription = 3;</code>
     * @param index The index of the value to return.
     * @return The bytes of the subscription at the given index.
     */
    public com.google.protobuf.ByteString
        getSubscriptionBytes(int index) {
      return subscription_.getByteString(index);
    }
    /**
     * <code>repeated string subscription = 3;</code>
     * @param index The index to set the value at.
     * @param value The subscription to set.
     * @return This builder for chaining.
     */
    public Builder setSubscription(
        int index, String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  ensureSubscriptionIsMutable();
      subscription_.set(index, value);
      onChanged();
      return this;
    }
    /**
     * <code>repeated string subscription = 3;</code>
     * @param value The subscription to add.
     * @return This builder for chaining.
     */
    public Builder addSubscription(
        String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  ensureSubscriptionIsMutable();
      subscription_.add(value);
      onChanged();
      return this;
    }
    /**
     * <code>repeated string subscription = 3;</code>
     * @param values The subscription to add.
     * @return This builder for chaining.
     */
    public Builder addAllSubscription(
        Iterable<String> values) {
      ensureSubscriptionIsMutable();
      com.google.protobuf.AbstractMessageLite.Builder.addAll(
          values, subscription_);
      onChanged();
      return this;
    }
    /**
     * <code>repeated string subscription = 3;</code>
     * @return This builder for chaining.
     */
    public Builder clearSubscription() {
      subscription_ = com.google.protobuf.LazyStringArrayList.EMPTY;
      bitField0_ = (bitField0_ & ~0x00000001);
      onChanged();
      return this;
    }
    /**
     * <code>repeated string subscription = 3;</code>
     * @param value The bytes of the subscription to add.
     * @return This builder for chaining.
     */
    public Builder addSubscriptionBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      ensureSubscriptionIsMutable();
      subscription_.add(value);
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


    // @@protoc_insertion_point(builder_scope:Subscriptions)
  }

  // @@protoc_insertion_point(class_scope:Subscriptions)
  private static final Subscriptions DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new Subscriptions();
  }

  public static Subscriptions getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<Subscriptions>
      PARSER = new com.google.protobuf.AbstractParser<Subscriptions>() {
    @Override
    public Subscriptions parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new Subscriptions(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<Subscriptions> parser() {
    return PARSER;
  }

  @Override
  public com.google.protobuf.Parser<Subscriptions> getParserForType() {
    return PARSER;
  }

  @Override
  public Subscriptions getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

