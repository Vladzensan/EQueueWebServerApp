package by.equeue.webserverapp.web.controllers;

import by.equeue.webserverapp.model.groups.Group;
import by.equeue.webserverapp.model.users.User;
import by.equeue.webserverapp.model.users.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
public class TestController {
    @Autowired
    private UserDao userDao;

    @GetMapping(value = "/test")
    User getSomething() {
        return userDao.findById(1L).get();
    }

    @GetMapping(value = "/")
    Set<Group> defaultGet() {
        return userDao.findById(1L).get().getGroups();
    }
}
