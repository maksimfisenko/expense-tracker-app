package dev.app.expense_tracker.user.category.web.model;

import java.util.Collection;

public record CategoryPageResponse(
        Long totalCategories,
        boolean isFirstPage,
        boolean isLastPage,
        Collection<CategoryResponse> categories
) {
}
