package repository;

import entities.Event;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EventRepository extends JpaRepository<Event, Long> {
    List<Event> findByCreator(SecurityProperties.User creator);
    List<Event> findByAvailableSeatsGreaterThan(int seats);

    List<Event> findByOrganizer(SecurityProperties.User organizer);
}
