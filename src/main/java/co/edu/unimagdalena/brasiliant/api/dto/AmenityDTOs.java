package co.edu.unimagdalena.brasiliant.api.dto;

import jakarta.validation.constraints.NotBlank;

import java.io.Serializable;

public class AmenityDTOs {
    public record AmenityCreateRequest(@NotBlank String name) implements Serializable {
    }

    public record AmenityResponse(Long id, String name) implements Serializable {
    }
}
