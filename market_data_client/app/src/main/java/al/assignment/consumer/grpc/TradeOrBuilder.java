// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: consumer.proto

package al.assignment.consumer.grpc;

public interface TradeOrBuilder extends
    // @@protoc_insertion_point(interface_extends:Trade)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>bool isBuy = 1;</code>
   * @return The isBuy.
   */
  boolean getIsBuy();

  /**
   * <code>string price = 2;</code>
   * @return The price.
   */
  java.lang.String getPrice();
  /**
   * <code>string price = 2;</code>
   * @return The bytes for price.
   */
  com.google.protobuf.ByteString
      getPriceBytes();

  /**
   * <code>string quantity = 3;</code>
   * @return The quantity.
   */
  java.lang.String getQuantity();
  /**
   * <code>string quantity = 3;</code>
   * @return The bytes for quantity.
   */
  com.google.protobuf.ByteString
      getQuantityBytes();

  /**
   * <code>string symbol = 4;</code>
   * @return The symbol.
   */
  java.lang.String getSymbol();
  /**
   * <code>string symbol = 4;</code>
   * @return The bytes for symbol.
   */
  com.google.protobuf.ByteString
      getSymbolBytes();
}
