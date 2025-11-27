package co.edu.unimagdalena.brasiliant.domain.repositories;

import co.edu.unimagdalena.brasiliant.domain.entities.Seat;
import co.edu.unimagdalena.brasiliant.domain.enums.SeatType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SeatRepository extends JpaRepository<Seat, Long> {
    List<Seat> findByNumber(String number);
    List<Seat> findByBus_Id(Long busId);
    Optional<Seat> findByNumberAndBus_Id(String number, Long busId);
    List<Seat> findByType(SeatType type);
    List<Seat> findByTypeAndBus_Id(SeatType type, Long busId);
}
