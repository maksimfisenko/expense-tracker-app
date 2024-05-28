package dev.app.expense_tracker.user.category.usecase;

import dev.app.expense_tracker.user.category.web.model.CategoryAddRequest;
import dev.app.expense_tracker.user.category.web.model.CategoryResponse;
import dev.app.expense_tracker.user.source.web.model.SourceAddRequest;
import dev.app.expense_tracker.user.source.web.model.SourceResponse;

public interface CategoryAddUseCase {
    CategoryResponse addCategory(CategoryAddRequest categoryAddRequest);
}
