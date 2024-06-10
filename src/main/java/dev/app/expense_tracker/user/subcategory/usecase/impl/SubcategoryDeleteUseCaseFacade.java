package dev.app.expense_tracker.user.subcategory.usecase.impl;

import dev.app.expense_tracker.user.subcategory.service.SubcategoryService;
import dev.app.expense_tracker.user.subcategory.usecase.SubcategoryDeleteUseCase;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;

@Component
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class SubcategoryDeleteUseCaseFacade implements SubcategoryDeleteUseCase {

    SubcategoryService subcategoryService;

    @Override
    public void deleteSubcategory(Long id) {
        subcategoryService.deleteSubcategory(id);
    }
}
