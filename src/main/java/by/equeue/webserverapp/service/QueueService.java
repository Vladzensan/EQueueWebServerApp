package by.equeue.webserverapp.service;

import by.equeue.webserverapp.model.queues.Queue;
import by.equeue.webserverapp.model.users.User;

public interface QueueService {
    void addUserToQueue(Queue queue, User user);

    void removeUserFromQueue(Queue queue, User user);

}
