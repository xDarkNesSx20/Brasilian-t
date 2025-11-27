package co.edu.unimagdalena.brasiliant.api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

import java.io.Serializable;
import java.math.BigDecimal;

public class StopDTOs {
    public record StopCreateRequest(@NotBlank String name, @Positive Integer stopOrder,
                                    BigDecimal latitude, BigDecimal longitude) implements Serializable {
    }

    public record StopUpdateRequest(String name, @Positive Integer stopOrder) implements Serializable {
    }

    public record StopResponse(Long id, Long routeId, String name, Integer stopOrder,
                               BigDecimal latitude, BigDecimal longitude) implements Serializable {
    }
}
