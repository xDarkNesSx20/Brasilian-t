package co.edu.unimagdalena.brasiliant.domain.repositories;

import co.edu.unimagdalena.brasiliant.domain.entities.Trip;
import co.edu.unimagdalena.brasiliant.domain.enums.TripStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;

public interface TripRepository extends JpaRepository<Trip, Long> {
    Page<Trip> findByRoute_Id(Long routeId, Pageable pageable);
    List<Trip> findByBus_Id(Long busId);
    List<Trip> findByStatus(TripStatus status);
    List<Trip> findByDate(LocalDate date);
    List<Trip> findByDepartureAtBetween(OffsetDateTime start, OffsetDateTime end);
    List<Trip> findByRoute_IdAndDepartureAtBetween(Long routeId, OffsetDateTime start, OffsetDateTime end);

    @EntityGraph(attributePaths = {"route", "bus"})
    @Query("SELECT T FROM Trip T WHERE T.id = :tripId")
    Optional<Trip> findByIdWithAllDetails(Long tripId);
}
