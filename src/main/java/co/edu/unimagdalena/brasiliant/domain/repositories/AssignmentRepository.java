package co.edu.unimagdalena.brasiliant.domain.repositories;

import co.edu.unimagdalena.brasiliant.domain.entities.Assignment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;

public interface AssignmentRepository extends JpaRepository<Assignment, Long> {
    Optional<Assignment> findByTrip_Id(Long tripId);
    Page<Assignment> findByAssignedAtBetween(OffsetDateTime start, OffsetDateTime end, Pageable pageable);
    List<Assignment> findByCheckListOk(Boolean checkListOk);
    List<Assignment> findByDriver_Id(Long driverId);
    List<Assignment> findByDispatcher_Id(Long dispatcherId);
    boolean existsByTrip_Id(Long tripId);

    @Query("SELECT A FROM Assignment A JOIN FETCH Trip T ON A.trip.id = T.id WHERE A.id = :id")
    Optional<Assignment> findByIdWithTripDetails(Long id);

    @EntityGraph(attributePaths = {"trip", "driver", "dispatcher"})
    @Query("SELECT A FROM Assignment A WHERE A.id = :id")
    Optional<Assignment> findByIdWithAllDetails(Long id);
}
