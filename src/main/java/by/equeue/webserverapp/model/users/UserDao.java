package by.equeue.webserverapp.model.users;

import by.equeue.webserverapp.model.groups.Group;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface UserDao extends CrudRepository<User, Long>{
//  //  @Query("SELECT g FROM Group g JOIN User u WHERE u.id = :userID")
//    Set<Group> getUserGroups(@Param("userID") Long userID);
//
//   // @Query("SELECT q FROM Queue q JOIN User u WHERE u.id = :userID")
//    Set<Group> getUserQueues(@Param("userID") Long userID);
}
