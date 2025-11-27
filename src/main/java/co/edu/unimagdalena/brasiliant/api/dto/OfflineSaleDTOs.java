package co.edu.unimagdalena.brasiliant.api.dto;

import co.edu.unimagdalena.brasiliant.domain.enums.PaymentMethod;
import co.edu.unimagdalena.brasiliant.domain.enums.SyncStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.OffsetDateTime;

public class OfflineSaleDTOs {
    //TripId should be here? Price shouldn't be. Should I delete OfflineSales after getting synced?
    public record OfflineSaleCreateRequest(@NotNull Long tripId, @NotBlank @Size(min = 3, max = 5) String seatNumber,
                                           @NotNull Long fromStopId,
                                           @NotNull Long toStopId, @NotBlank String passengerIdNumber,
                                           String passengerName,
                                           String passengerPhone, @NotNull @Positive BigDecimal price,
                                           @NotNull PaymentMethod paymentMethod) implements Serializable {
    }

    public record OfflineSaleUpdateRequest(Long tripId, String seatNumber, SyncStatus status,
                                           OffsetDateTime syncedAt, Long ticketId) implements Serializable {
    }

    public record OfflineSaleResponse(Long id, Long tripId, String seatNumber, Long fromStopId, Long toStopId,
                                      String passengerIdNumber, String passengerName, String passengerPhone,
                                      BigDecimal price, PaymentMethod paymentMethod, SyncStatus status,
                                      Integer syncAttempts, OffsetDateTime createdAt, OffsetDateTime syncedAt,
                                      Long ticketId) implements Serializable {
    }
}
