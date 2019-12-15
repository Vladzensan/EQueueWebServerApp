package by.equeue.webserverapp.model.queues;

import by.equeue.webserverapp.model.groups.Group;
import by.equeue.webserverapp.model.users.UserQueuePosition;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name = "queues")
public class Queue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", length = 64, nullable = false)
    private String title;

    @Column(name = "description", length = 64, nullable = false)
    private String description;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group group;

    @JsonIgnore
    @OneToMany(mappedBy = "queue")
    List<UserQueuePosition> positions = new LinkedList<>();


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<UserQueuePosition> getPositions() {
        return positions;
    }

    public void setPositions(List<UserQueuePosition> positions) {
        this.positions = positions;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

}