package by.equeue.webserverapp.model.groups;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupDao extends CrudRepository<Group, Long> {
}