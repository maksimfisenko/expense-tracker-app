package dev.app.expense_tracker.user.source.web.model;

import java.math.BigDecimal;
import java.time.Instant;

public record SourceResponse(
        Long id,
        String name,
        String hex,
        BigDecimal balance,
        String currency,
        Instant createdTimestamp,
        Instant lastModifiedTimestamp
) {
}
