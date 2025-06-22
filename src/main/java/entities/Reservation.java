package entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.ManyToOne;
import org.springframework.data.annotation.Id;
import org.springframework.security.core.userdetails.User;

@Entity
public class Reservation {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private User user;

    @ManyToOne
    private Event event;

    public void setUser(User user) {
    }

    public Thread getUser() {
    }
}
