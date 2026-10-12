package tn.esprit.autoloc.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.domain.Reservation;
import tn.esprit.autoloc.repository.ReservationRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReservationServiceImpl implements IReservationService {
    private final ReservationRepository reservationRepository;

    public Reservation getReservationById(Long id) { return reservationRepository.findById(id).orElse(null); }
    public List<Reservation> getAllReservations() { return reservationRepository.findAll(); }
    public Reservation addReservation(Reservation reservation) { return reservationRepository.save(reservation); }
    public Reservation updateReservation(Reservation reservation) { return reservationRepository.save(reservation); }
    public void deleteReservation(Long id) { reservationRepository.deleteById(id); }
}
