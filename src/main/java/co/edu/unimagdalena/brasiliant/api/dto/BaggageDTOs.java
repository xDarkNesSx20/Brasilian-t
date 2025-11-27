package co.edu.unimagdalena.brasiliant.api.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

import java.io.Serializable;
import java.math.BigDecimal;

public class BaggageDTOs {
    public record BaggageCreateRequest(@NotNull @Positive BigDecimal weightKg, @PositiveOrZero BigDecimal fee,
                                       @NotNull @Positive Integer trunkNumber) implements Serializable {
    }

    public record BaggageUpdateRequest(@Positive BigDecimal weightKg, @PositiveOrZero BigDecimal fee,
                                       @Positive Integer trunkNumber) implements Serializable {
    }

    public record BaggageResponse(Long id, String tagCode, Long ticketId, BigDecimal weightKg,
                                  BigDecimal fee, Integer trunkNumber) implements Serializable {
    }
}
