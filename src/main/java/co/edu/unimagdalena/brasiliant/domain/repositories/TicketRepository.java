package co.edu.unimagdalena.brasiliant.domain.repositories;

import co.edu.unimagdalena.brasiliant.domain.entities.Ticket;
import co.edu.unimagdalena.brasiliant.domain.enums.PaymentMethod;
import co.edu.unimagdalena.brasiliant.domain.enums.TicketStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface TicketRepository extends JpaRepository<Ticket,Long> {
    @EntityGraph(attributePaths = {"trip", "passenger", "fromStop", "toStop"})
    @Query("SELECT T FROM Ticket T WHERE T.id = :id")
    Optional<Ticket> findByIdWithAllDetails(@Param("id") Long id);

    List<Ticket> findByTrip_Id(Long tripId);
    Page<Ticket> findByStatus(TicketStatus status, Pageable pageable);
    List<Ticket> findByPaymentMethod(PaymentMethod paymentMethod);
    List<Ticket> findByPassenger_IdAndStatus(Long passengerId, TicketStatus status);
    List<Ticket> findByFromStop_IdAndStatus(Long fromStopId, TicketStatus status);
    List<Ticket> findByToStop_IdAndStatus(Long toStopId, TicketStatus status);
    List<Ticket> findByFromStop_IdAndToStop_IdAndStatus(Long fromStopId, Long toStopId, TicketStatus status);
}
