package by.equeue.webserverapp.service;

import by.equeue.webserverapp.model.groups.Group;
import by.equeue.webserverapp.model.queues.Queue;
import by.equeue.webserverapp.model.users.User;

import java.util.List;

public interface GroupService {
    void addQueueToGroup(Group group, Queue queue);

    void addUserToGroup(Group group, User user);

    List<Group> getAllGroups();

    List<Queue> getGroupsQueues(Long groupId);


}
