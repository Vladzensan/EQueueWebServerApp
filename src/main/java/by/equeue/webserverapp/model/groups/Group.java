package by.equeue.webserverapp.model.groups;

import by.equeue.webserverapp.model.queues.Queue;
import by.equeue.webserverapp.model.users.User;

import javax.persistence.*;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name = "groups")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", length = 64, nullable = false)
    private String title;

    @ManyToMany(mappedBy = "groups")
    private List<User> users = new LinkedList<>();

    @OneToMany(targetEntity = by.equeue.webserverapp.model.queues.Queue.class, mappedBy = "group")
    private List<Queue> queues = new LinkedList<>();

    public Group() {
    }

    public Group(String title) {
        this.title = title;
    }

    public List<Queue> getQueues() {
        return queues;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public void setQueues(List<Queue> queues) {
        this.queues = queues;
    }
}