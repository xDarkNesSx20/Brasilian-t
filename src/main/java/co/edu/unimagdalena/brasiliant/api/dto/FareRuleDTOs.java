package co.edu.unimagdalena.brasiliant.api.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import co.edu.unimagdalena.brasiliant.api.dto.DiscountDTOs.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Set;

public class FareRuleDTOs {
    public record FareRuleCreateRequest(@NotNull Long fromStopId, @NotNull Long toStopId,
                                        @Positive BigDecimal basePrice,
                                        Set<DiscountCreateRequest> discounts) implements Serializable {
    }

    public record FareRuleUpdateRequest(@Positive BigDecimal basePrice,
                                        Boolean dynamicPricing) implements Serializable {
    }

    public record FareRuleResponse(Long id, Long routeId, Long fromStopId, Long toStopId, BigDecimal basePrice,
                                   Boolean dynamicPricing) implements Serializable {
    }

    public record FareRulePartialResponse(Long id, Long routeId, Long fromStopId, Long toStopId, BigDecimal basePrice,
                                          Boolean dynamicPricing,
                                          Set<DiscountResponse> discounts) implements Serializable {
    }

    public record FareRuleDetailsResponse(Long id, RouteSummary route, StopSummary fromStop, StopSummary toStop,
                                          BigDecimal basePrice, Boolean dynamicPricing,
                                          Set<DiscountResponse> discounts) implements Serializable {
    }

    public record RouteSummary(Long id, String name) implements Serializable {
    }

    public record StopSummary(Long id, String name, Integer stopOrder) implements Serializable {
    }
}
