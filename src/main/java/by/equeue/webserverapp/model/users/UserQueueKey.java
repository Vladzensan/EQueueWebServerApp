package by.equeue.webserverapp.model.users;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class UserQueueKey implements Serializable {
    @Column(name = "user_id")
    Long userId;

    @Column(name = "queue_id")
    Long queueId;

    public UserQueueKey(Long userId, Long queueId) {
        this.userId = userId;
        this.queueId = queueId;
    }

    public UserQueueKey() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserQueueKey)) return false;
        UserQueueKey that = (UserQueueKey) o;
        return userId == that.userId &&
                queueId == that.queueId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, queueId);
    }


    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getQueueId() {
        return queueId;
    }

    public void setQueueId(Long queueId) {
        this.queueId = queueId;
    }
}
