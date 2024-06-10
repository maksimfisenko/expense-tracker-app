package dev.app.expense_tracker.user.subcategory.web.model;

import java.time.Instant;

public record SubcategoryResponse(
        Long id,
        String name,
        Instant createdTimestamp,
        Instant lastModifiedTimestamp
) {
}
