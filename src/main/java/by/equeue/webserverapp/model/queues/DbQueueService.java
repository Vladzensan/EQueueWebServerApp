package by.equeue.webserverapp.model.queues;

import by.equeue.webserverapp.model.users.User;
import by.equeue.webserverapp.model.users.UserQueueDao;
import by.equeue.webserverapp.model.users.UserQueueKey;
import by.equeue.webserverapp.model.users.UserQueuePosition;
import org.springframework.stereotype.Service;

@Service
public class DbQueueService implements QueueService {

    private final UserQueueDao userQueueDao;
    private final QueueDao queueDao;

    public DbQueueService(UserQueueDao userQueueDao, QueueDao queueDao) {
        this.userQueueDao = userQueueDao;
        this.queueDao = queueDao;
    }


    @Override
    public void addUserToQueue(Queue queue, User user) {
        long queueUserCount = queue.getPositions().size();
        UserQueuePosition pos = new UserQueuePosition(queue, user, queueUserCount);
        user.getPositions().add(pos);
        queue.getPositions().add(pos);
        userQueueDao.save(pos);
    }

    @Override
    public void removeUserFromQueue(Long queueId, Long userId) {
        userQueueDao.deleteById(new UserQueueKey(userId, queueId));

    }

}