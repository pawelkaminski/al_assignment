package al.assignment.utils;

import java.util.concurrent.ArrayBlockingQueue;

public class SubscriptionUpdatesQueue extends ArrayBlockingQueue<SubscriptionUpdate> {
    public SubscriptionUpdatesQueue() {
        super(100000);
    }
}



