package co.edu.unimagdalena.brasiliant.api.dto;

import co.edu.unimagdalena.brasiliant.domain.enums.DiscountType;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.math.BigDecimal;

public class DiscountDTOs {
    public record DiscountCreateRequest(@NotNull DiscountType type,
                                        @NotNull @Min(0) @Max(1) BigDecimal value) implements Serializable {
    }

    public record DiscountUpdateRequest(@Min(0) @Max(1) BigDecimal value) implements Serializable {
    }

    public record DiscountResponse(Long id, Long fareRuleId, DiscountType type, BigDecimal value) implements Serializable {}
}
