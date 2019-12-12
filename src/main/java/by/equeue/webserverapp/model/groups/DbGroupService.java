package by.equeue.webserverapp.model.groups;

import by.equeue.webserverapp.model.queues.Queue;
import by.equeue.webserverapp.model.queues.QueueDao;
import by.equeue.webserverapp.model.users.User;
import by.equeue.webserverapp.model.users.UserDao;
import org.springframework.stereotype.Service;

@Service
public class DbGroupService implements GroupService {
    private final QueueDao queueDao;
    private final GroupDao groupDao;
    private final UserDao userDao;

    public DbGroupService(QueueDao queueDao, GroupDao groupDao, UserDao userDao) {
        this.queueDao = queueDao;
        this.groupDao = groupDao;
        this.userDao = userDao;
    }

    @Override
    public void addQueueToGroup(Group group, Queue queue) {
        if (queue.getGroup() == null) {
            queue.setGroup(group);
            group.getQueues().add(queue);
            queueDao.save(queue);
        } else {
            throw new IllegalArgumentException("Queue already belongs to group " + queue.getGroup().getTitle());
        }

    }

    @Override
    public void addUserToGroup(Group group, User user) {
        group.getUsers().add(user);
        user.getGroups().add(group);
        //groupDao.save(group);
        userDao.save(user);


    }
}
