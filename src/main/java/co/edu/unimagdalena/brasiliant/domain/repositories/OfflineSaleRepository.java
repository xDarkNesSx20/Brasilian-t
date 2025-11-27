package co.edu.unimagdalena.brasiliant.domain.repositories;

import co.edu.unimagdalena.brasiliant.domain.entities.OfflineSale;
import co.edu.unimagdalena.brasiliant.domain.enums.SyncStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.OffsetDateTime;
import java.util.List;

public interface OfflineSaleRepository extends JpaRepository<OfflineSale, Long> {
    List<OfflineSale> findByTripId(Long tripId);
    Page<OfflineSale> findBySyncedAtBetween(OffsetDateTime start, OffsetDateTime end, Pageable pageable);
    Page<OfflineSale> findByCreatedAtBetween(OffsetDateTime start, OffsetDateTime end, Pageable pageable);
    List<OfflineSale> findByFromStopId(Long stopId);
    List<OfflineSale> findByFromStopIdAndToStopId(Long fromStopId, Long toStopId);
    List<OfflineSale> findByPassengerIdNumber(String passengerIdNumber);
    Page<OfflineSale> findByStatus(SyncStatus status, Pageable pageable);
}
