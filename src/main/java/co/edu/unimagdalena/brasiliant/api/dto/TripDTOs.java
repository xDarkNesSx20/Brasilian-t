package co.edu.unimagdalena.brasiliant.api.dto;

import co.edu.unimagdalena.brasiliant.api.dto.CommonSummaryDTOs.*;

import co.edu.unimagdalena.brasiliant.domain.enums.TripStatus;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.OffsetDateTime;

public class TripDTOs {
    public record TripCreateRequest(Long busId, @NotNull LocalDate date, @NotNull OffsetDateTime departureAt,
                                    TripStatus status) implements Serializable {
    }

    public record TripUpdateRequest(Long busId, LocalDate date, OffsetDateTime departureAt,
                                    TripStatus status) implements Serializable {
    }

    public record TripResponse(Long id, Long routeId, Long busId, LocalDate date, OffsetDateTime departureAt,
                               OffsetDateTime arrivalEta, TripStatus status) implements Serializable {
    }

    public record TripDetailsResponse(Long id, RouteSummary route, BusSummary bus, LocalDate date,
                                      OffsetDateTime departureAt,
                                      OffsetDateTime arrivalEta, TripStatus status) implements Serializable {
    }
}
