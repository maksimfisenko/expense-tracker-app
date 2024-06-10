package dev.app.expense_tracker.user.subcategory.usecase.impl;

import dev.app.expense_tracker.user.subcategory.mapper.SubcategoryAddRequestToSubcategoryMapper;
import dev.app.expense_tracker.user.subcategory.mapper.SubcategoryToSubcategoryResponseMapper;
import dev.app.expense_tracker.user.subcategory.model.Subcategory;
import dev.app.expense_tracker.user.subcategory.service.SubcategoryService;
import dev.app.expense_tracker.user.subcategory.usecase.SubcategoryAddUseCase;
import dev.app.expense_tracker.user.subcategory.web.model.SubcategoryAddRequest;
import dev.app.expense_tracker.user.subcategory.web.model.SubcategoryResponse;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;

@Component
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class SubcategoryAddUseCaseFacade implements SubcategoryAddUseCase {

    SubcategoryAddRequestToSubcategoryMapper subcategoryAddRequestToSubcategoryMapper;
    SubcategoryToSubcategoryResponseMapper subcategoryToSubcategoryResponseMapper;
    SubcategoryService subcategoryService;

    @Override
    public SubcategoryResponse addSubcategory(SubcategoryAddRequest subcategoryAddRequest) {
        Subcategory mappedSubcategory = subcategoryAddRequestToSubcategoryMapper.map(subcategoryAddRequest);
        Subcategory createdSubcategory = subcategoryService.createSubcategory(mappedSubcategory);
        return subcategoryToSubcategoryResponseMapper.map(createdSubcategory);
    }
}
