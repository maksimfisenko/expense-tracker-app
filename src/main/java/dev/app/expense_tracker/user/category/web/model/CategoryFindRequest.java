package dev.app.expense_tracker.user.category.web.model;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

public record CategoryFindRequest(
        @Min(0) int page,
        @Min(0) @Max(10) int limit
) {
}
