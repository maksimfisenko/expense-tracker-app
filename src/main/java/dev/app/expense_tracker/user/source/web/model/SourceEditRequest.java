package dev.app.expense_tracker.user.source.web.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

public record SourceEditRequest(
        @NotNull Long id,
        @NotBlank @Size(min = 1, max = 100) String name,
        @NotBlank @Size(min = 7, max = 7) String hex,
        @NotNull BigDecimal balance,
        @NotBlank @Size(min = 3, max = 3) String currency
) {
}
