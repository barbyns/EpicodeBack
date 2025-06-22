package repository;

import entities.Booking;
import entities.Event;
import graphql.com.google.common.base.Optional;

import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.User;

import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long> {
    List<Booking> findByUser(SecurityProperties.User user);
    Optional<Booking> findByUserAndEvent(User user, Event event);
}