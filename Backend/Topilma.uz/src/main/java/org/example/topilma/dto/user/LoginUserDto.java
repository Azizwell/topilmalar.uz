package org.example.topilma.dto.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record LoginUserDto(
        @NotBlank
        @Email
        String username,
        @NotBlank
        String password) {
}
