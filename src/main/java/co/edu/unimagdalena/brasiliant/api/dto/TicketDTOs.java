package co.edu.unimagdalena.brasiliant.api.dto;

import co.edu.unimagdalena.brasiliant.api.dto.CommonSummaryDTOs.*;
import co.edu.unimagdalena.brasiliant.domain.enums.PaymentMethod;
import co.edu.unimagdalena.brasiliant.domain.enums.TicketStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.io.Serializable;
import java.math.BigDecimal;

public class TicketDTOs {
    public record TicketCreateRequest(@NotNull Long passengerId, @NotBlank @Size(min = 3, max = 5) String seatNumber,
                                      @NotNull Long fromStopId, @NotNull Long toStopId,
                                      @NotNull PaymentMethod paymentMethod) implements Serializable {
    }

    public record TicketUpdateRequest(@Size(min = 3, max = 5) String seatNumber, PaymentMethod paymentMethod,
                                      TicketStatus status) implements Serializable {
    }

    public record TicketResponse(Long id, Long tripId, Long fromStopId, Long toStopId, Long passengerId,
                                 BigDecimal price, PaymentMethod paymentMethod, TicketStatus status,
                                 String qrCode) implements Serializable {
    }

    public record TicketDetailsResponse(Long id, Long tripId, StopSummary fromStop, StopSummary toStop,
                                        UserSummary passenger, BigDecimal price, PaymentMethod paymentMethod,
                                        TicketStatus status, String qrCode) implements Serializable {
    }
}
