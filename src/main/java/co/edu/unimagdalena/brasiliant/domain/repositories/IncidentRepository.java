package co.edu.unimagdalena.brasiliant.domain.repositories;

import co.edu.unimagdalena.brasiliant.domain.entities.Incident;
import co.edu.unimagdalena.brasiliant.domain.enums.EntityType;
import co.edu.unimagdalena.brasiliant.domain.enums.IncidentType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.OffsetDateTime;
import java.util.List;

public interface IncidentRepository extends JpaRepository<Incident, Long> {
    Page<Incident> findByCreatedAtBetween(OffsetDateTime start, OffsetDateTime end, Pageable pageable);
    List<Incident> findByType(IncidentType type);
    List<Incident> findByEntityType(EntityType entityType);
    List<Incident> findByTypeAndEntityType(IncidentType type, EntityType entityType);
    List<Incident> findByEntityId(Long entityId);
    List<Incident> findByEntityTypeAndEntityId(EntityType entityType, Long entityId);

    int countByEntityType(EntityType entityType);
    int countByType(IncidentType type);
    int countByTypeAndEntityType(IncidentType type, EntityType entityType);
}
