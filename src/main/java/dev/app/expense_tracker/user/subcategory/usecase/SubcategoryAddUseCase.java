package dev.app.expense_tracker.user.subcategory.usecase;

import dev.app.expense_tracker.user.subcategory.web.model.SubcategoryAddRequest;
import dev.app.expense_tracker.user.subcategory.web.model.SubcategoryResponse;

public interface SubcategoryAddUseCase {
    SubcategoryResponse addSubcategory(SubcategoryAddRequest subcategoryAddRequest);
}
