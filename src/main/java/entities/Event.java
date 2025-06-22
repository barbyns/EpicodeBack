package entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.ManyToOne;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

@Entity
public class Event {
    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String description;
    private LocalDateTime dateTime;
    private String location;
    private int availableSeats;

    @ManyToOne
    private SecurityProperties.User creator;

    // getter, setter, costruttori
}
