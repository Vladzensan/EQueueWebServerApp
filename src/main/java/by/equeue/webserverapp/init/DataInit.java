package by.equeue.webserverapp.init;

import by.equeue.webserverapp.model.groups.Group;
import by.equeue.webserverapp.model.groups.GroupDao;
import by.equeue.webserverapp.model.groups.GroupService;
import by.equeue.webserverapp.model.queues.DbQueueService;
import by.equeue.webserverapp.model.queues.Queue;
import by.equeue.webserverapp.model.queues.QueueDao;
import by.equeue.webserverapp.model.queues.QueueService;
import by.equeue.webserverapp.model.users.User;
import by.equeue.webserverapp.model.users.UserDao;
import by.equeue.webserverapp.model.users.UserQueueDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInit implements ApplicationRunner {
    private final UserDao userDao;

    private final GroupDao groupDao;

    private final QueueDao queueDao;
    private final UserQueueDao userQueueDao;
    private final QueueService queueService;
    private final GroupService groupService;

    public DataInit(UserDao userDao, GroupDao groupDao, QueueDao queueDao, UserQueueDao userQueueDao, QueueService queueService, GroupService groupService) {
        this.userDao = userDao;
        this.groupDao = groupDao;
        this.queueDao = queueDao;
        this.userQueueDao = userQueueDao;
        this.queueService = queueService;
        this.groupService = groupService;
    }

    @Override
    public void run(ApplicationArguments args) {
        long count = userDao.count();

        if (count == 0) {
            User user = new User();
            user.setName("VLad");
            user.setSurname("Dovgulev");

            User user1 = new User();
            user1.setName("Alex");
            user1.setSurname("Kashirsky");

            userDao.save(user);
            userDao.save(user1);


            user.setName("Robert");
            userDao.save(user);

            Group group = new Group();
            group.setTitle("dw");
            groupDao.save(group);


            Queue queue = new Queue();
            queue.setTitle("tittle");
            queue.setDescription("fefwwf");
            queueDao.save(queue);
            // groupDao.findAll().forEach(group1 -> group1.getQueues().add(queue));


            queueService.addUserToQueue(queue, user);

            groupService.addQueueToGroup(group,queue);
            groupService.addUserToGroup(group, user);


            System.out.println(userQueueDao.getQueueUsers(1L));
            System.out.println(user.getPositions());


        }

    }

}