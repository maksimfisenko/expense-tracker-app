package dev.app.expense_tracker.user.subcategory.usecase;

import dev.app.expense_tracker.user.subcategory.web.model.SubcategoryResponse;

import java.util.List;

public interface SubcategoryFindUseCase {
    List<SubcategoryResponse> findCategorySubcategories(Long categoryId);
}
