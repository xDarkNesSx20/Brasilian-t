package co.edu.unimagdalena.brasiliant.domain.repositories;

import co.edu.unimagdalena.brasiliant.domain.entities.Route;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface RouteRepository extends JpaRepository<Route,Long> {
    Optional<Route> findByCode(String code);
    List<Route> findByOriginIgnoreCase(String origin);
    List<Route> findByDestinationIgnoreCase(String destination);
    List<Route> findByOriginAndDestinationIgnoreCase(String origin, String destination);
    List<Route> findByDurationMinLessThanEqual(Integer maxDuration);
    List<Route> findByDurationMinGreaterThanEqual(Integer minDuration);
    List<Route> findByDistanceKmLessThanEqual(BigDecimal maxDistanceKm);
    List<Route> findByDistanceKmGreaterThanEqual(BigDecimal minDistanceKm);
}
