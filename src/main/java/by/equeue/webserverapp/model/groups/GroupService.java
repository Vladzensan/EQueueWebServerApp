package by.equeue.webserverapp.model.groups;

import by.equeue.webserverapp.model.queues.Queue;
import by.equeue.webserverapp.model.users.User;

public interface GroupService {
    void addQueueToGroup(Group group, Queue queue);
    void addUserToGroup(Group group, User user);
}
