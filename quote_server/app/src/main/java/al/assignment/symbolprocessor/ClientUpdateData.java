package al.assignment.symbolprocessor;

import al.assignment.utils.ClientAddress;
import al.assignment.utils.MessagesToClientQueue;

public class ClientUpdateData {
    boolean isDelete;
    ClientAddress client;
    MessagesToClientQueue queue;

    ClientUpdateData(ClientAddress client) {
        this.client = client;
        this.isDelete = true;
    }

    ClientUpdateData(ClientAddress client, MessagesToClientQueue queue) {
        this.client = client;
        this.queue = queue;
        this.isDelete = false;
    }

}
