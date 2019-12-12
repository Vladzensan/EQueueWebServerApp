package by.equeue.webserverapp.model.queues;

import by.equeue.webserverapp.model.users.User;

public interface QueueService {
    void addUserToQueue(Queue queue, User user);
    void removeUserFromQueue(Long queueId, Long userId);
}
