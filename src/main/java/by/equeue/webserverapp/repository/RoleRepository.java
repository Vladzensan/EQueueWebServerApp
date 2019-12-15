package by.equeue.webserverapp.repository;

import by.equeue.webserverapp.model.users.Role;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends CrudRepository<Role, Long> {
    Role findByName(String name);
}
