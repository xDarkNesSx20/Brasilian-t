package co.edu.unimagdalena.brasiliant.api.dto;

import co.edu.unimagdalena.brasiliant.domain.enums.EntityType;
import co.edu.unimagdalena.brasiliant.domain.enums.IncidentType;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.time.OffsetDateTime;

public class IncidentDTOs {
    public record IncidentCreateRequest(@NotNull EntityType entityType, @NotNull Long entityId,
                                        @NotNull IncidentType type, String note) implements Serializable {
    }

    public record IncidentUpdateRequest(IncidentType type, String note) implements Serializable {
    }

    public record IncidentResponse(Long id, EntityType entityType, Long entityId, IncidentType type,
                                   OffsetDateTime createdAt, String note) implements Serializable {
    }
}
