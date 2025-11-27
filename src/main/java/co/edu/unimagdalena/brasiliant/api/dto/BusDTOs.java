package co.edu.unimagdalena.brasiliant.api.dto;

import co.edu.unimagdalena.brasiliant.domain.enums.BusStatus;
import jakarta.validation.constraints.*;

import java.io.Serializable;
import java.util.Set;

public class BusDTOs {
    public record BusCreateRequest(@NotBlank @Size(min = 6, max = 8) String plate, @NotNull @Min(20) Integer capacity,
                                   BusStatus status, Set<Long> amenitiesId) implements Serializable {
    }

    //Should update amenities too
    public record BusUpdateRequest(@Positive Integer capacity, BusStatus status,
                                   Set<Long> amenitiesId) implements Serializable {
    }

    public record BusResponse(Long id, String plate, Integer capacity, BusStatus status) implements Serializable {
    }

    public record BusDetailsResponse(Long id, String plate, Integer capacity, BusStatus status,
                                     Set<AmenityDTOs.AmenityResponse> amenities) implements Serializable {
    }
}
