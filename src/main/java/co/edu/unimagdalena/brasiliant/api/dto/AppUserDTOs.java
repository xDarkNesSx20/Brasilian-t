package co.edu.unimagdalena.brasiliant.api.dto;

import co.edu.unimagdalena.brasiliant.domain.enums.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.io.Serializable;
import java.time.OffsetDateTime;
import java.util.Set;

public class AppUserDTOs {
    public record AppUserCreateRequest(@NotBlank String fullName, @NotBlank String phone, @NotBlank @Email String email,
                                       @NotBlank String password, Set<Role> roles) implements Serializable {
    }

    public record AppUserUpdateRequest(String fullName, String phone, String email,
                                       String password) implements Serializable {
    }

    public record AppUserResponse(Long id, String fullName, String phone, String email, Set<Role> roles,
                                  Boolean active, OffsetDateTime createdAt) implements Serializable {
    }
}
