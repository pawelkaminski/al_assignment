package al.assignment.utils;

import java.util.concurrent.ArrayBlockingQueue;

public class MessagesToClientQueue extends ArrayBlockingQueue<MessageToClient> {
    public MessagesToClientQueue() {
        super(100000);
    }
}
