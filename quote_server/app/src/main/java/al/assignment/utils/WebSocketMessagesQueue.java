package al.assignment.utils;

import java.util.concurrent.ArrayBlockingQueue;

public class WebSocketMessagesQueue extends ArrayBlockingQueue<String> {

    public WebSocketMessagesQueue() {
        super(100000);
    }
}
