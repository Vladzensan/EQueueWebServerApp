package by.equeue.webserverapp.repository;

import by.equeue.webserverapp.model.users.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{
    User findByUsername(String username);
}
