package dev.app.expense_tracker.user.source.web.model;

import java.util.Collection;

public record SourcePageResponse(
        Long totalSources,
        boolean isFirstPage,
        boolean isLastPage,
        Collection<SourceResponse> sources
) {
}
