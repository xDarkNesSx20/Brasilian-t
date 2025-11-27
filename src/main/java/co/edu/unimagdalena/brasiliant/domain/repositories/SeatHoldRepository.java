package co.edu.unimagdalena.brasiliant.domain.repositories;

import co.edu.unimagdalena.brasiliant.domain.entities.SeatHold;
import co.edu.unimagdalena.brasiliant.domain.enums.SeatHoldStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface SeatHoldRepository extends JpaRepository<SeatHold, Long> {
    List<SeatHold> findByTrip_Id(Long tripId);
    List<SeatHold> findByStatus(SeatHoldStatus status);

    @Query("SELECT SH FROM SeatHold SH WHERE SH.trip.id = :tripId AND SH.seatNumber = :seatNumber AND SH.status != 'EXPIRED'")
    Optional<SeatHold> findByTrip_IdAndSeatNumber(Long tripId, String seatNumber);
    List<SeatHold> findByPassenger_Id(Long passengerId);
}
