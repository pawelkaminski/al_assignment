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
        Book.Builder builder = Book.newBuilder();
        builder.setIsBuy(this.isBuy);
        builder.setIsDelete(isDelete);
        builder.setSymbol(symbol);
        builder.setPrice(price);
        builder.setQuantity(quantity);
        builder.setOrderId(orderId);
        return builder.build();
    }

    public boolean decreaseQuantity(String other) {
        if (quantity.equals(other)) {
            this.quantity = "0";
            return true;
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
            return false;
        }

        long second;
        if (thisArr.length == 1) {
            first -= 1L;
            second = getMul(1L, otherArr[1].length());
            second -= Long.parseLong(otherArr[1]);
            makeQuantity(first, second, otherArr[1].length());
            return false;
        }

        int diff = otherArr[1].length() - thisArr[1].length();
        int max = Math.max(otherArr[1].length(),thisArr[1].length());
        second = getMul(Long.parseLong(thisArr[1]), diff) - getMul(Long.parseLong(otherArr[1]), diff);
        if (second < 0) {
            first -= 1L;
            second += getMul(1L, max);
        }
        makeQuantity(first, second, max);

        return false;
    }

    private void makeQuantity(long first, long second) {
        if (second == 0L){
            this.quantity = first + "";
        } else {
            this.quantity = first + "." + second;
        }
    }

    private void makeQuantity(long first, long second, int size) {
        if (second == 0L){
            this.quantity = first + "";
            return;
        }

        char[] chars = new char[size];
        Arrays.fill(chars, '0');

        int idx = size - 1;
        while(second > 0L) {
            chars[idx] = (char) (48L + second % 10L);
            idx --;
            second /= 10L;
        }
        String string = new String(chars);

        this.quantity = first + "." + string;
    }

    private long getMul(long result, int size) {
        for (int idx = 0; idx < size; ++idx) {
            result *= 10L;
        }
        return result;
    }
}
