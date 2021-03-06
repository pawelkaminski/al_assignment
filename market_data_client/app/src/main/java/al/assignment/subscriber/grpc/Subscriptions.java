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

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new Subscriptions();
  }

  @java.lang.Override
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

            host_ = s;
            break;
          }
          case 18: {
            java.lang.String s = input.readStringRequireUtf8();

            port_ = s;
            break;
          }
          case 26: {
            java.lang.String s = input.readStringRequireUtf8();
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
    return al.assignment.subscriber.grpc.QuotaServiceProto.internal_static_Subscriptions_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return al.assignment.subscriber.grpc.QuotaServiceProto.internal_static_Subscriptions_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            al.assignment.subscriber.grpc.Subscriptions.class, al.assignment.subscriber.grpc.Subscriptions.Builder.class);
  }

  public static final int HOST_FIELD_NUMBER = 1;
  private volatile java.lang.Object host_;
  /**
   * <code>string host = 1;</code>
   * @return The host.
   */
  @java.lang.Override
  public java.lang.String getHost() {
    java.lang.Object ref = host_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      host_ = s;
      return s;
    }
  }
  /**
   * <code>string host = 1;</code>
   * @return The bytes for host.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getHostBytes() {
    java.lang.Object ref = host_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      host_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int PORT_FIELD_NUMBER = 2;
  private volatile java.lang.Object port_;
  /**
   * <code>string port = 2;</code>
   * @return The port.
   */
  @java.lang.Override
  public java.lang.String getPort() {
    java.lang.Object ref = port_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      port_ = s;
      return s;
    }
  }
  /**
   * <code>string port = 2;</code>
   * @return The bytes for port.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getPortBytes() {
    java.lang.Object ref = port_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
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
  public java.lang.String getSubscription(int index) {
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

  @java.lang.Override
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

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof al.assignment.subscriber.grpc.Subscriptions)) {
      return super.equals(obj);
    }
    al.assignment.subscriber.grpc.Subscriptions other = (al.assignment.subscriber.grpc.Subscriptions) obj;

    if (!getHost()
        .equals(other.getHost())) return false;
    if (!getPort()
        .equals(other.getPort())) return false;
    if (!getSubscriptionList()
        .equals(other.getSubscriptionList())) return false;
    if (!unknownFields.equals(other.unknownFields)) return false;
    return true;
  }

  @java.lang.Override
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

  public static al.assignment.subscriber.grpc.Subscriptions parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static al.assignment.subscriber.grpc.Subscriptions parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static al.assignment.subscriber.grpc.Subscriptions parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static al.assignment.subscriber.grpc.Subscriptions parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static al.assignment.subscriber.grpc.Subscriptions parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static al.assignment.subscriber.grpc.Subscriptions parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static al.assignment.subscriber.grpc.Subscriptions parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static al.assignment.subscriber.grpc.Subscriptions parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static al.assignment.subscriber.grpc.Subscriptions parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static al.assignment.subscriber.grpc.Subscriptions parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static al.assignment.subscriber.grpc.Subscriptions parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static al.assignment.subscriber.grpc.Subscriptions parseFrom(
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
  public static Builder newBuilder(al.assignment.subscriber.grpc.Subscriptions prototype) {
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
   * Protobuf type {@code Subscriptions}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:Subscriptions)
      al.assignment.subscriber.grpc.SubscriptionsOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return al.assignment.subscriber.grpc.QuotaServiceProto.internal_static_Subscriptions_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return al.assignment.subscriber.grpc.QuotaServiceProto.internal_static_Subscriptions_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              al.assignment.subscriber.grpc.Subscriptions.class, al.assignment.subscriber.grpc.Subscriptions.Builder.class);
    }

    // Construct using al.assignment.subscriber.grpc.Subscriptions.newBuilder()
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
      host_ = "";

      port_ = "";

      subscription_ = com.google.protobuf.LazyStringArrayList.EMPTY;
      bitField0_ = (bitField0_ & ~0x00000001);
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return al.assignment.subscriber.grpc.QuotaServiceProto.internal_static_Subscriptions_descriptor;
    }

    @java.lang.Override
    public al.assignment.subscriber.grpc.Subscriptions getDefaultInstanceForType() {
      return al.assignment.subscriber.grpc.Subscriptions.getDefaultInstance();
    }

    @java.lang.Override
    public al.assignment.subscriber.grpc.Subscriptions build() {
      al.assignment.subscriber.grpc.Subscriptions result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public al.assignment.subscriber.grpc.Subscriptions buildPartial() {
      al.assignment.subscriber.grpc.Subscriptions result = new al.assignment.subscriber.grpc.Subscriptions(this);
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

    @java.lang.Override
    public Builder clone() {
      return super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof al.assignment.subscriber.grpc.Subscriptions) {
        return mergeFrom((al.assignment.subscriber.grpc.Subscriptions)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(al.assignment.subscriber.grpc.Subscriptions other) {
      if (other == al.assignment.subscriber.grpc.Subscriptions.getDefaultInstance()) return this;
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

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      al.assignment.subscriber.grpc.Subscriptions parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (al.assignment.subscriber.grpc.Subscriptions) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    private java.lang.Object host_ = "";
    /**
     * <code>string host = 1;</code>
     * @return The host.
     */
    public java.lang.String getHost() {
      java.lang.Object ref = host_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        host_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string host = 1;</code>
     * @return The bytes for host.
     */
    public com.google.protobuf.ByteString
        getHostBytes() {
      java.lang.Object ref = host_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
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
        java.lang.String value) {
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

    private java.lang.Object port_ = "";
    /**
     * <code>string port = 2;</code>
     * @return The port.
     */
    public java.lang.String getPort() {
      java.lang.Object ref = port_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        port_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string port = 2;</code>
     * @return The bytes for port.
     */
    public com.google.protobuf.ByteString
        getPortBytes() {
      java.lang.Object ref = port_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
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
        java.lang.String value) {
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
    public java.lang.String getSubscription(int index) {
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
        int index, java.lang.String value) {
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
        java.lang.String value) {
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
        java.lang.Iterable<java.lang.String> values) {
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
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:Subscriptions)
  }

  // @@protoc_insertion_point(class_scope:Subscriptions)
  private static final al.assignment.subscriber.grpc.Subscriptions DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new al.assignment.subscriber.grpc.Subscriptions();
  }

  public static al.assignment.subscriber.grpc.Subscriptions getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<Subscriptions>
      PARSER = new com.google.protobuf.AbstractParser<Subscriptions>() {
    @java.lang.Override
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

  @java.lang.Override
  public com.google.protobuf.Parser<Subscriptions> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public al.assignment.subscriber.grpc.Subscriptions getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

