package by.equeue.webserverapp.service;

import by.equeue.webserverapp.model.groups.Group;
import by.equeue.webserverapp.model.queues.Queue;
import by.equeue.webserverapp.repository.QueueRepository;
import by.equeue.webserverapp.model.users.User;
import by.equeue.webserverapp.repository.UserRepository;
import by.equeue.webserverapp.repository.GroupRepository;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class DbGroupService implements GroupService {
    private final QueueRepository queueRepository;
    private final GroupRepository groupRepository;
    private final UserRepository userRepository;

    public DbGroupService(QueueRepository queueRepository, GroupRepository groupRepository, UserRepository userRepository) {
        this.queueRepository = queueRepository;
        this.groupRepository = groupRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void addQueueToGroup(Group group, Queue queue) {
        if (queue.getGroup() == null) {
            queue.setGroup(group);
            group.getQueues().add(queue);
            queueRepository.save(queue);
        } else {
            throw new IllegalArgumentException("Queue already belongs to group " + queue.getGroup().getTitle());
        }

    }

    @Override
    public void addUserToGroup(Group group, User user) {
        group.getUsers().add(user);
        user.getGroups().add(group);
        //groupDao.save(group);
        userRepository.save(user);


    }

    @Override
    public List<Group> getAllGroups() {
        List<Group> groups = new LinkedList<>();
        Iterable<Group> itGroups = groupRepository.findAll();
        itGroups.forEach(group -> groups.add(group));
        return groups;
    }

    @Override
    public List<Queue> getGroupsQueues(Long groupId) {
       return groupRepository.findById(groupId).get().getQueues();
    }
}
