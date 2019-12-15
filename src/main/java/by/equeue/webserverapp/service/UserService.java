package by.equeue.webserverapp.service;

import by.equeue.webserverapp.model.groups.Group;
import by.equeue.webserverapp.model.queues.Queue;
import by.equeue.webserverapp.model.users.User;

import java.util.List;

public interface UserService {
    User register(User user);

    User findByUsername(String username);

    User findById(Long id);

    List<Group> getUsersGroups(Long userId);

    List<Queue> getQueuesOfUser(Long userId);

}
