package by.equeue.webserverapp.model.users;

import by.equeue.webserverapp.model.queues.Queue;

import javax.persistence.*;

@Entity
@Table(name = "user_queue")
public class UserQueuePosition {

    @EmbeddedId
    UserQueueKey id;

    @ManyToOne
    @MapsId("user_id")
    @JoinColumn(name = "user_id")
    User user;

    @ManyToOne
    @MapsId("queue_id")
    @JoinColumn(name = "queue_id")
    Queue queue;


    public UserQueuePosition() {
    }

    public UserQueuePosition(Queue queue, User user, long position){
        UserQueueKey key = new UserQueueKey(user.getId(), queue.getId());
        this.setPosition(position);
        this.setId(key);
    }
    private long position;


    public UserQueueKey getId() {
        return id;
    }

    public void setId(UserQueueKey id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Queue getQueue() {
        return queue;
    }

    public void setQueue(Queue queue) {
        this.queue = queue;
    }

    public long getPosition() {
        return position;
    }

    public void setPosition(long position) {
        this.position = position;
    }
}
