package org.example.topilma.dto.user;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UserDto(
        @NotBlank
        String username,
        @NotNull
        String password,
        String firstName,
        String role,
        String image
) {
}
