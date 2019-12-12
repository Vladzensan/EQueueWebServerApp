package by.equeue.webserverapp.model.groups;

import by.equeue.webserverapp.model.queues.Queue;
import by.equeue.webserverapp.model.users.User;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "groups")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", length = 64, nullable = false)
    private String title;

    @ManyToMany(mappedBy = "groups")
    private Set<User> users = new HashSet<>();

    @OneToMany(targetEntity = by.equeue.webserverapp.model.queues.Queue.class, mappedBy = "group")
    private Set<Queue> queues = new HashSet<>();

    public Group() {
    }

    public Group(String title) {
        this.title = title;
    }

    public Set<Queue> getQueues() {
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

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public void setQueues(Set<Queue> queues) {
        this.queues = queues;
    }
}