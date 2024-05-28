package dev.app.expense_tracker.user.category.usecase;

import dev.app.expense_tracker.user.category.web.model.CategoryEditRequest;
import dev.app.expense_tracker.user.category.web.model.CategoryResponse;

public interface CategoryEditUseCase {
    CategoryResponse editCategory(CategoryEditRequest categoryEditRequest);
}
