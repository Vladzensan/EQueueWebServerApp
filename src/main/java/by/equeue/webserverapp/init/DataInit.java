package by.equeue.webserverapp.init;

import by.equeue.webserverapp.model.groups.Group;
import by.equeue.webserverapp.model.users.Role;
import by.equeue.webserverapp.repository.*;
import by.equeue.webserverapp.service.GroupService;
import by.equeue.webserverapp.model.queues.Queue;
import by.equeue.webserverapp.service.QueueService;
import by.equeue.webserverapp.model.users.User;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInit implements ApplicationRunner {
    private final UserRepository userRepository;

    private final GroupRepository groupRepository;

    private final QueueRepository queueRepository;
    private final UserQueueRepository userQueueRepository;
    private final QueueService queueService;
    private final GroupService groupService;
    private final RoleRepository roleRepository;

    public DataInit(UserRepository userRepository, GroupRepository groupRepository, QueueRepository queueRepository, UserQueueRepository userQueueRepository, QueueService queueService, GroupService groupService, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.groupRepository = groupRepository;
        this.queueRepository = queueRepository;
        this.userQueueRepository = userQueueRepository;
        this.queueService = queueService;
        this.groupService = groupService;
        this.roleRepository = roleRepository;
    }

    @Override
    public void run(ApplicationArguments args) {
        long count = userRepository.count();

        if (count == 0) {
            User user = new User();
            user.setFirstName("VLad");
            user.setLastName("Dovgulev");

            User user1 = new User();
            user1.setFirstName("Alex");
            user1.setLastName("Kashirsky");

            userRepository.save(user);
            userRepository.save(user1);


            user.setFirstName("Robert");
            user.setPassword("$2a$04$3XLF0J7OjR2WaPWgz8T.0uWUJcB/M.QpoM/qcKVjPjts1XHPr0Ege"); //123
            user.setUsername("vlad");
            Role role = new Role();
            role.setName("user");
            role.getUsers().add(user);
            user.getRoles().add(role);
            roleRepository.save(role);
            userRepository.save(user);

            Group group = new Group();
            group.setTitle("dw");
            groupRepository.save(group);


            Queue queue = new Queue();
            queue.setTitle("tittle");
            queue.setDescription("fefwwf");
            queueRepository.save(queue);
            // groupDao.findAll().forEach(group1 -> group1.getQueues().add(queue));


            queueService.addUserToQueue(queue, user);

            groupService.addQueueToGroup(group,queue);
            groupService.addUserToGroup(group, user);


            System.out.println(userQueueRepository.getQueueUsers(1L));
            System.out.println(user.getPositions());


        }

    }

}