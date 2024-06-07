package dev.app.expense_tracker.user.category.usecase;

import dev.app.expense_tracker.user.category.web.model.CategoryAddRequest;
import dev.app.expense_tracker.user.category.web.model.CategoryResponse;

public interface CategoryAddUseCase {
    CategoryResponse addCategory(CategoryAddRequest categoryAddRequest);
}
