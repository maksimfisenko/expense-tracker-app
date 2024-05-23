package dev.app.expense_tracker.user.profile.web.model;

import jakarta.validation.constraints.NotBlank;

public record UserProfileRegisterRequest(
        @NotBlank String name,
        @NotBlank String imageLink) {
}
