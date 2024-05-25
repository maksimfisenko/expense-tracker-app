package dev.app.expense_tracker.user.source.web.model;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

public record SourceFindRequest(
        @Min(0) int page,
        @Min(0) @Max(10) int limit
) {
}
