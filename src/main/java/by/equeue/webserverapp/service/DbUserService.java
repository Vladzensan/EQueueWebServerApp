package by.equeue.webserverapp.service;

import by.equeue.webserverapp.model.groups.Group;
import by.equeue.webserverapp.model.queues.Queue;
import by.equeue.webserverapp.model.users.Role;
import by.equeue.webserverapp.model.users.User;
import by.equeue.webserverapp.repository.GroupRepository;
import by.equeue.webserverapp.repository.QueueRepository;
import by.equeue.webserverapp.repository.RoleRepository;
import by.equeue.webserverapp.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DbUserService implements UserService {
    private final RoleRepository roleRepository;
    private final UserRepository userRepository;
    private final GroupRepository groupRepository;
    private final QueueRepository queueRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public DbUserService(RoleRepository roleRepository, UserRepository userRepository, GroupRepository groupRepository, QueueRepository queueRepository, BCryptPasswordEncoder passwordEncoder) {
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
        this.groupRepository = groupRepository;
        this.queueRepository = queueRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User register(User user) {
        Role roleUser = roleRepository.findByName("ROLE_USER");
        List<Role> userRoles = new ArrayList<>();
        userRoles.add(roleUser);

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(userRoles);

        User registeredUser = userRepository.save(user);
        return registeredUser;
    }

    @Override
    public User findByUsername(String username) {
        User user = userRepository.findByUsername(username);
        return user;
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public List<Group> getUsersGroups(Long userId) {
        return groupRepository.getUsersGroups(userId);
    }

    @Override
    public List<Queue> getQueuesOfUser(Long userId) {
        return queueRepository.getQueuesOfUser(userId);
    }
}
