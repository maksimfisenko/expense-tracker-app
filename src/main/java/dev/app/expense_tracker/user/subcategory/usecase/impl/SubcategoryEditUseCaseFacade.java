package dev.app.expense_tracker.user.subcategory.usecase.impl;

import dev.app.expense_tracker.user.subcategory.mapper.SubcategoryEditRequestToSubcategoryMapper;
import dev.app.expense_tracker.user.subcategory.mapper.SubcategoryToSubcategoryResponseMapper;
import dev.app.expense_tracker.user.subcategory.model.Subcategory;
import dev.app.expense_tracker.user.subcategory.service.SubcategoryService;
import dev.app.expense_tracker.user.subcategory.usecase.SubcategoryEditUseCase;
import dev.app.expense_tracker.user.subcategory.web.model.SubcategoryEditRequest;
import dev.app.expense_tracker.user.subcategory.web.model.SubcategoryResponse;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;

@Component
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class SubcategoryEditUseCaseFacade implements SubcategoryEditUseCase {

    SubcategoryEditRequestToSubcategoryMapper subcategoryEditRequestToSubcategoryMapper;
    SubcategoryToSubcategoryResponseMapper subcategoryToSubcategoryResponseMapper;
    SubcategoryService subcategoryService;

    @Override
    public SubcategoryResponse editSubcategory(SubcategoryEditRequest subcategoryEditRequest) {
        Subcategory mappedSubcategory = subcategoryEditRequestToSubcategoryMapper.map(subcategoryEditRequest);
        Subcategory editedSubcategory = subcategoryService.updateSubcategory(mappedSubcategory);
        return subcategoryToSubcategoryResponseMapper.map(editedSubcategory);
    }
}
