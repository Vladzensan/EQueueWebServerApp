package by.equeue.webserverapp.model.users;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserQueueDao extends CrudRepository<UserQueuePosition, UserQueueKey> {
    @Query("SELECT pos.user FROM UserQueuePosition pos WHERE pos.queue.id = :queueId")
    List<User> getQueueUsers(@Param("queueId") Long queueId);
}
