package al.assignment.symbolprocessor;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.util.concurrent.BlockingQueue;

public class SybmbolProcessor implements Runnable {
    private final BlockingQueue<String> queue;
    private final String symbol;
    private int counter;
    JSONParser parser;

    public SybmbolProcessor(String symbol, BlockingQueue<String> queue) {
        this.queue = queue;
        this.symbol = symbol;
        this.counter = 0;
        this.parser = new JSONParser();
    }

    public void run() {
        prepareInitialBook();
        runQueueProcessing();
    }

    void prepareInitialBook() {
        System.out.println("cleaned!");
    }

    void runQueueProcessing() {
        try {
            while (true) {
                consume(queue.take());
            }
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }


    void consume(String message) {
        JSONObject cleanedMessage;
        try {
            cleanedMessage = (JSONObject) parser.parse(message);
        } catch (ParseException exception) {
            exception.printStackTrace();
            return;
        }

        if (!cleanedMessage.containsKey("type")) {
            return;
        }

        counter ++;
        if (counter % 100 == 0) {
            System.out.printf("message %d\n", counter);
        }
    }

}
