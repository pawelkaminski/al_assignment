package al.assignment.utils;

import java.util.concurrent.ArrayBlockingQueue;

public class WebSocketQueue extends ArrayBlockingQueue<String> {

    public WebSocketQueue() {
        super(100000);
    }
}
