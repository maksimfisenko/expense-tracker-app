package dev.app.expense_tracker.user.category.web.model;

import java.time.Instant;

public record CategoryResponse(
        Long id,
        String name,
        String hex,
        String currency,
        Instant createdTimestamp,
        Instant lastModifiedTimestamp
) {
}
