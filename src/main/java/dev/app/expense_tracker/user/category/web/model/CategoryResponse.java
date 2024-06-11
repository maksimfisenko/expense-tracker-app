package dev.app.expense_tracker.user.category.web.model;

import dev.app.expense_tracker.user.category.model.CategoryType;

import java.time.Instant;

public record CategoryResponse(
        Long id,
        CategoryType type,
        String name,
        String hex,
        String currency,
        Instant createdTimestamp,
        Instant lastModifiedTimestamp
) {
}
