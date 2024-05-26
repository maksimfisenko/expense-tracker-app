package dev.app.expense_tracker.security.web.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record LoginRequest(
        @Email @NotBlank String username,
        @NotBlank String password) {
}
