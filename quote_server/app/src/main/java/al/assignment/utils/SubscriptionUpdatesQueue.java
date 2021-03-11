package al.assignment.utils;

import java.util.concurrent.ArrayBlockingQueue;

public class SubscriptionUpdatesQueue extends ArrayBlockingQueue<SubscriptionUpdate> {

    private static volatile SubscriptionUpdatesQueue instance;
    
    public static SubscriptionUpdatesQueue getInstance() {

        SubscriptionUpdatesQueue result = instance;
        if (result != null) {
            return result;
        }
        synchronized(SubscriptionUpdatesQueue.class) {
            if (instance == null) {
                instance = new SubscriptionUpdatesQueue();
            }
            return instance;
        }
    }


    private SubscriptionUpdatesQueue() {
        super(100000);
    }
}



