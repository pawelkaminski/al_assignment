// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: consumer.proto

package al.assignment.consumer.grpc;

public final class ConsumerInterface {
  private ConsumerInterface() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_ConsumerStatus_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_ConsumerStatus_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Trade_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Trade_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Book_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Book_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\016consumer.proto\" \n\016ConsumerStatus\022\016\n\006st" +
      "atus\030\001 \001(\010\"7\n\005Trade\022\r\n\005isBuy\030\001 \001(\010\022\r\n\005pr" +
      "ice\030\002 \001(\t\022\020\n\010quantity\030\003 \001(\t\"6\n\004Book\022\r\n\005i" +
      "sBuy\030\001 \001(\010\022\r\n\005price\030\002 \001(\t\022\020\n\010quantity\030\003 " +
      "\001(\t2T\n\010Consumer\022$\n\007onTrade\022\006.Trade\032\017.Con" +
      "sumerStatus\"\000\022\"\n\006onBook\022\005.Book\032\017.Consume" +
      "rStatus\"\000B2\n\033al.assignment.consumer.grpc" +
      "B\021ConsumerInterfaceP\001b\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_ConsumerStatus_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_ConsumerStatus_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_ConsumerStatus_descriptor,
        new java.lang.String[] { "Status", });
    internal_static_Trade_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_Trade_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Trade_descriptor,
        new java.lang.String[] { "IsBuy", "Price", "Quantity", });
    internal_static_Book_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_Book_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Book_descriptor,
        new java.lang.String[] { "IsBuy", "Price", "Quantity", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
