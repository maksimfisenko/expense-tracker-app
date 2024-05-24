package dev.app.expense_tracker.user.source.web.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

public record SourceAddRequest(
        @NotBlank String name,
        @NotBlank String hex,
        @NotBlank BigDecimal balance,
        @NotBlank @Size(min = 3, max = 3) String currency
) {
}
