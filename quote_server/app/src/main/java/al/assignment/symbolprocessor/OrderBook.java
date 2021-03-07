package al.assignment.symbolprocessor;

import al.assignment.consumer.grpc.Book;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class OrderBook extends HashMap<String, Order> {

    public List<Book> prepareBookMessages(String symbol) {
        List<Book> result = new ArrayList<>();
        for (Entry<String, Order> entry: entrySet()) {
            result.add(entry.getValue().getBookProto(symbol, entry.getKey(), false));
        }
        return result;
    }
}
