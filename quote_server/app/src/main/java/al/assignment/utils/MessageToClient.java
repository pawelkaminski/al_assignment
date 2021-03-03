package al.assignment.utils;

import al.assignment.consumer.grpc.Book;
import al.assignment.consumer.grpc.Trade;

public class MessageToClient {
    public Trade trade;
    public Book book;

    MessageToClient(Trade trade) {
        this.trade = trade;
    }

    MessageToClient(Book book) {
        this.book = book;
    }

}
