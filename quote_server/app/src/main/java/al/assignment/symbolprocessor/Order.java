package al.assignment.symbolprocessor;

import al.assignment.consumer.grpc.Book;

import java.util.Arrays;

public class Order {
    boolean isBuy;
    String price;
    String quantity;
    
    public Order (boolean isBuy, String price, String quantity) {
        this.isBuy = isBuy;
        this.price = price;
        this.quantity = quantity;
    }

    public Book getBookProto(String symbol, String orderId, boolean isDelete) {
        if (quantity.equals("0")) {
            isDelete = true;
        }
        return Book.newBuilder()
            .setIsBuy(this.isBuy)
            .setIsDelete(isDelete)
            .setSymbol(symbol)
            .setPrice(price)
            .setQuantity(quantity)
            .setOrderId(orderId)
            .build();
    }

    public void decreaseQuantity(String other) {
        if (quantity.equals(other)) {
            this.quantity = "0";
            return;
        }

        var otherArr = other.split("\\.");
        var thisArr = this.quantity.split("\\.");

        long first = Long.parseLong(thisArr[0]) - Long.parseLong(otherArr[0]);
        if (otherArr.length == 1) {
            if (thisArr.length == 1) {
                makeQuantity(first, 0L);
            } else {
                makeQuantity(first, Long.parseLong(thisArr[1]));
            }
            return;
        }

        long second;
        if (thisArr.length == 1) {
            first -= 1L;
            second = getPow10(1L, otherArr[1].length());
            second -= Long.parseLong(otherArr[1]);
            makeQuantity(first, second, otherArr[1].length());
            return;
        }

        int diffPrecision = otherArr[1].length() - thisArr[1].length();
        int expectedPrecision = Math.max(otherArr[1].length(),thisArr[1].length());
        second = getPow10(Long.parseLong(thisArr[1]), diffPrecision)
                - getPow10(Long.parseLong(otherArr[1]), diffPrecision);
        if (second < 0) {
            first -= 1L;
            second += getPow10(1L, expectedPrecision);
        }
        makeQuantity(first, second, expectedPrecision);

    }

    private void makeQuantity(long first, long second) {
        if (second == 0L){
            this.quantity = first + "";
        } else {
            this.quantity = first + "." + second;
        }
    }

    private void makeQuantity(long first, long second, int precision) {
        if (second == 0L){
            this.quantity = first + "";
            return;
        }

        char[] chars = new char[precision];
        Arrays.fill(chars, '0');

        int idx = precision - 1;
        while(second > 0L) {
            chars[idx] = (char) (48L + second % 10L);
            idx --;
            second /= 10L;
        }
        String string = new String(chars);

        this.quantity = first + "." + string;
    }

    private long getPow10(long result, int size) {
        for (int idx = 0; idx < size; ++idx) {
            result *= 10L;
        }
        return result;
    }
}
