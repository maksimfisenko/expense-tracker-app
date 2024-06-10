package dev.app.expense_tracker.user.subcategory.usecase;

import dev.app.expense_tracker.user.subcategory.web.model.SubcategoryEditRequest;
import dev.app.expense_tracker.user.subcategory.web.model.SubcategoryResponse;

public interface SubcategoryEditUseCase {
    SubcategoryResponse editSubcategory(SubcategoryEditRequest subcategoryEditRequest);
}
