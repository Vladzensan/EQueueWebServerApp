package by.equeue.webserverapp.repository;

import by.equeue.webserverapp.model.groups.Group;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GroupRepository extends CrudRepository<Group, Long> {
    @Query("SELECT g FROM Group g where g.id = :userId")
    List<Group> getUsersGroups(@Param("userId") Long userId);
}