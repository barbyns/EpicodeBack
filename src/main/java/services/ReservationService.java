package services;
import entities.Event;
import entities.Reservation;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;
import repository.EventRepository;
import repository.ReservationRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {
    private final ReservationRepository reservationRepository;
    private final EventRepository eventRepository;

    public ReservationService(ReservationRepository reservationRepository, EventRepository eventRepository) {
        this.reservationRepository = reservationRepository;
        this.eventRepository = eventRepository;
    }

    public Optional<Reservation> reserveSeat(Long eventId, User user) {
        Optional<Event> eventOpt = eventRepository.findById(eventId);
        if (eventOpt.isEmpty()) return Optional.empty();

        Event event = eventOpt.get();

        long reservationsCount = reservationRepository.findByUser(user).stream()
                .filter(r -> r.getEvent().getId().equals(eventId)).count();

        if (reservationsCount > 0) return Optional.empty();

        long existingReservations = reservationRepository.findAll().stream()
                .filter(r -> r.getEvent().getId().equals(eventId)).count();

        if (existingReservations >= event.getMaxSeats()) return Optional.empty();

        Reservation reservation = new Reservation();
        reservation.setUser(user);
        reservation.setEvent(event);

        return Optional.of(reservationRepository.save(reservation));
    }

    public List<Reservation> getUserReservations(User user) {
        return reservationRepository.findByUser(user);
    }

    public void cancelReservation(Long reservationId, User user) {
        reservationRepository.findById(reservationId).ifPresent(r -> {
            if (r.getUser().getId().equals(user.getId())) {
                reservationRepository.deleteById(reservationId);
            }
        });
    }
}
