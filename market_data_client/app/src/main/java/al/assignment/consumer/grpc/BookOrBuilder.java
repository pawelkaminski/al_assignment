// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: consumer.proto

package al.assignment.consumer.grpc;

public interface BookOrBuilder extends
    // @@protoc_insertion_point(interface_extends:Book)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>bool isBuy = 1;</code>
   * @return The isBuy.
   */
  boolean getIsBuy();

  /**
   * <code>bool isDelete = 2;</code>
   * @return The isDelete.
   */
  boolean getIsDelete();

  /**
   * <code>string price = 3;</code>
   * @return The price.
   */
  java.lang.String getPrice();
  /**
   * <code>string price = 3;</code>
   * @return The bytes for price.
   */
  com.google.protobuf.ByteString
      getPriceBytes();

  /**
   * <code>string quantity = 4;</code>
   * @return The quantity.
   */
  java.lang.String getQuantity();
  /**
   * <code>string quantity = 4;</code>
   * @return The bytes for quantity.
   */
  com.google.protobuf.ByteString
      getQuantityBytes();

  /**
   * <code>string orderId = 5;</code>
   * @return The orderId.
   */
  java.lang.String getOrderId();
  /**
   * <code>string orderId = 5;</code>
   * @return The bytes for orderId.
   */
  com.google.protobuf.ByteString
      getOrderIdBytes();

  /**
   * <code>string symbol = 6;</code>
   * @return The symbol.
   */
  java.lang.String getSymbol();
  /**
   * <code>string symbol = 6;</code>
   * @return The bytes for symbol.
   */
  com.google.protobuf.ByteString
      getSymbolBytes();
}
