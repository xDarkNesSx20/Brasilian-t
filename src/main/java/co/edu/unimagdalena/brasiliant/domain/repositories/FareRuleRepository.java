package co.edu.unimagdalena.brasiliant.domain.repositories;

import co.edu.unimagdalena.brasiliant.domain.entities.FareRule;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface FareRuleRepository extends JpaRepository<FareRule,Long> {
    List<FareRule> findAllByRoute_Id(Long routeId);

    @Query("SELECT FR FROM FareRule FR JOIN FETCH FR.discounts WHERE FR.route.id = :routeId AND FR.fromStop.id = :fromStopId AND FR.toStop.id = :toStopId")
    Optional<FareRule> findByRouteAndStops(Long routeId, Long fromStopId, Long toStopId);

    @Query("SELECT FR FROM FareRule FR LEFT JOIN FETCH FR.discounts WHERE FR.id = :id")
    Optional<FareRule> findByIdWithDiscounts(Long id);

    @EntityGraph(attributePaths = {"route", "fromStop", "toStop, discounts"})
    @Query("SELECT FR FROM FareRule FR WHERE FR.id = :id")
    Optional<FareRule> findByIdWithAllDetails(Long id);
}
