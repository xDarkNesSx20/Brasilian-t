package co.edu.unimagdalena.brasiliant.api.dto;

import co.edu.unimagdalena.brasiliant.domain.enums.SeatType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.io.Serializable;

public class SeatDTOs {
    public record SeatCreateRequest(@NotBlank @Size(min = 3, max = 5) String number,
                                    SeatType type) implements Serializable {
    }

    public record SeatUpdateRequest(@Size(min = 3, max = 5) String number, SeatType type) implements Serializable {
    }

    public record SeatResponse(Long id, Long busId, String number, SeatType type) implements Serializable {
    }
}
