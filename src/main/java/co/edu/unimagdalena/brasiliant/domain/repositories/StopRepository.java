package co.edu.unimagdalena.brasiliant.domain.repositories;

import co.edu.unimagdalena.brasiliant.domain.entities.Stop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface StopRepository extends JpaRepository<Stop,Long> {
    List<Stop> findByRoute_Id(Long routeId);
    List<Stop> findByStopOrder(Integer stopOrder);
    Optional<Stop> findByRoute_IdAndStopOrder(Long routeId, Integer stopOrder);

    @Query(value = "SELECT * FROM stops WHERE route_id = :routeId ORDER BY stop_order LIMIT 1", nativeQuery = true)
    Optional<Stop> findFirstByRoute_Id(Long routeId);

    @Query(value = "SELECT * FROM stops WHERE route_id = :routeId ORDER BY stop_order DESC LIMIT 1", nativeQuery = true)
    Optional<Stop> findLastByRoute_Id(Long routeId);
}
