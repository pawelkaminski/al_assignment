package al.assignment.utils;

import java.util.concurrent.ArrayBlockingQueue;

public class SubscriptionUpdatesQueue extends ArrayBlockingQueue<SubscriptionUpdate> {

    private static volatile SubscriptionUpdatesQueue instance;
    
    public static SubscriptionUpdatesQueue getInstance() {

        SubscriptionUpdatesQueue result = instance;
        if (result != null) {
            System.out.println("USED OLD QUEUE!");
            return result;
        }
        synchronized(SubscriptionUpdatesQueue.class) {
            System.out.println("QUEUE CREATED!");
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



