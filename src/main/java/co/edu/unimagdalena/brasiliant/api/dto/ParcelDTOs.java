package co.edu.unimagdalena.brasiliant.api.dto;

import co.edu.unimagdalena.brasiliant.api.dto.CommonSummaryDTOs.*;
import co.edu.unimagdalena.brasiliant.domain.enums.ParcelStatus;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.io.Serializable;
import java.math.BigDecimal;

public class ParcelDTOs {
    public record ParcelCreateRequest(@NotNull Long fromStopId, @NotNull Long toStopId, @Positive BigDecimal price,
                                      @NotNull Long senderId, @NotNull Long receiverId) implements Serializable {
    }

    public record ParcelUpdateRequest(@Positive BigDecimal price, Long receiverId) implements Serializable {
    }

    public record ParcelResponse(Long id, String code, Long fromStopId, Long toStopId, BigDecimal price,
                                 UserSummary sender, UserSummary receiver,
                                 ParcelStatus status) implements Serializable {
    }

    public record ParcelDetailsResponse(Long id, String code, StopSummary fromStop, StopSummary toStop,
                                        BigDecimal price,
                                        UserSummary sender, UserSummary receiver,
                                        ParcelStatus status, String deliveryOTP) implements Serializable {
    }
}
