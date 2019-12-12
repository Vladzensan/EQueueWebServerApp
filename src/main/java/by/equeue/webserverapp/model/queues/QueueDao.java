package by.equeue.webserverapp.model.queues;

import by.equeue.webserverapp.model.users.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;

@Repository
public interface QueueDao extends CrudRepository<Queue, Long> {
//    //@Query(value) TODO
//    Set<Queue> getUserQueues(@Param("userID") Long userID);
    @Modifying
    @Query(value ="INSERT INTO USER_QUEUE ", nativeQuery = true)
    @Transactional
    void addUserToQueue(@Param("user") User user);
}