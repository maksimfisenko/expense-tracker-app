package dev.app.expense_tracker.user.category.web.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CategoryAddRequest(
        @NotBlank @Size(min = 6, max = 7) String type,
        @NotBlank @Size(min = 1, max = 100) String name,
        @NotBlank @Size(min = 7, max = 7) String hex,
        @NotBlank @Size(min = 3, max = 3) String currency
) {
}
