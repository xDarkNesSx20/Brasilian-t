package co.edu.unimagdalena.brasiliant.api.dto;

import co.edu.unimagdalena.brasiliant.api.dto.CommonSummaryDTOs.*;
import co.edu.unimagdalena.brasiliant.domain.enums.SeatHoldStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.io.Serializable;
import java.time.OffsetDateTime;

public class SeatHoldDTOs {
    public record SeatHoldCreateRequest(@NotBlank @Size(min = 3, max = 5) String seatNumber,
                                        @NotNull Long passengerId) implements Serializable {
    }

    public record SeatHoldUpdateRequest(@Size(min = 3, max = 5) String seatNumber) implements Serializable {
    }

    public record SeatHoldResponse(Long id, Long tripId, String seatNumber, UserSummary passenger,
                                   OffsetDateTime expiresAt,
                                   SeatHoldStatus status) implements Serializable {
    }
}
