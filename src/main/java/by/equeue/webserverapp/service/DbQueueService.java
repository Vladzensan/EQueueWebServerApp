package by.equeue.webserverapp.service;

import by.equeue.webserverapp.model.queues.Queue;
import by.equeue.webserverapp.model.users.User;
import by.equeue.webserverapp.model.users.UserQueueKey;
import by.equeue.webserverapp.model.users.UserQueuePosition;
import by.equeue.webserverapp.repository.QueueRepository;
import by.equeue.webserverapp.repository.UserQueueRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DbQueueService implements QueueService {

    private final UserQueueRepository userQueueRepository;
    private final QueueRepository queueRepository;

    public DbQueueService(UserQueueRepository userQueueRepository, QueueRepository queueRepository) {
        this.userQueueRepository = userQueueRepository;
        this.queueRepository = queueRepository;
    }


    @Override
    public void addUserToQueue(Queue queue, User user) {
        long queueUserCount = queue.getPositions().size();
        UserQueuePosition pos = new UserQueuePosition(queue, user, queueUserCount);
        user.getPositions().add(pos);
        queue.getPositions().add(pos);
        userQueueRepository.save(pos);
    }

    @Override
    public void removeUserFromQueue(Queue queue, User user) {
        userQueueRepository.deleteById(new UserQueueKey(user.getId(), queue.getId()));

    }

}