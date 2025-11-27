package co.edu.unimagdalena.brasiliant.api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.io.Serializable;

public class OfflineUserDTOs {
    public record OfflineUserCreateRequest(@NotBlank String fullName, @NotBlank String phone,
                                           @NotBlank @Size(min = 8, max = 10) String idNumber) implements Serializable {
    }

    public record OfflineUserUpdateRequest(String fullName, String phone) implements Serializable {
    }

    public record OfflineUserResponse(Long id, String fullName, String phone, String idNumber) implements Serializable {
    }
}
