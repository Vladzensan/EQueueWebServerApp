package by.equeue.webserverapp.repository;

import by.equeue.webserverapp.model.queues.Queue;
import by.equeue.webserverapp.model.users.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface QueueRepository extends CrudRepository<Queue, Long> {

    @Modifying
    @Query(value = "INSERT INTO USER_QUEUE ", nativeQuery = true)
    @Transactional
    void addUserToQueue(@Param("user") User user);

    @Query("SELECT q FROM Queue q JOIN UserQueuePosition pos WHERE pos.user.id = :userId")
    List<Queue> getQueuesOfUser(@Param("userId") Long userId);

}