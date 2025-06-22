package repository;

import entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.User;

import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    List<Reservation> findByUser(User user);
    boolean existsByUserIdAndEventId(Long userId, Long eventId);
}
