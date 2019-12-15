package by.equeue.webserverapp.repository;

import by.equeue.webserverapp.model.users.User;
import by.equeue.webserverapp.model.users.UserQueueKey;
import by.equeue.webserverapp.model.users.UserQueuePosition;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserQueueRepository extends CrudRepository<UserQueuePosition, UserQueueKey> {
    @Query("SELECT pos.user FROM UserQueuePosition pos WHERE pos.queue.id = :queueId")
    List<User> getQueueUsers(@Param("queueId") Long queueId);
}
