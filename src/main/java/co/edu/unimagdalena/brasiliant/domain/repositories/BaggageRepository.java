package co.edu.unimagdalena.brasiliant.domain.repositories;

import co.edu.unimagdalena.brasiliant.domain.entities.Baggage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface BaggageRepository extends JpaRepository<Baggage, Long> {
    List<Baggage> findByTicket_Id(Long ticketId);
    Optional<Baggage> findByTagCode(String tagCode);
    List<Baggage> findByWeightKgGreaterThanEqual(BigDecimal minWeight);

    @Query("SELECT B FROM Baggage B WHERE B.fee > 0.0")
    List<Baggage> findBaggagePaysFee();
    int countByTrunkNumber(Integer trunkNumber);
}
