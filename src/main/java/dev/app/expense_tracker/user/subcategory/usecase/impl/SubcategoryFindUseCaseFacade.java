package dev.app.expense_tracker.user.subcategory.usecase.impl;

import dev.app.expense_tracker.user.subcategory.mapper.SubcategoryToSubcategoryResponseMapper;
import dev.app.expense_tracker.user.subcategory.model.Subcategory;
import dev.app.expense_tracker.user.subcategory.service.SubcategoryService;
import dev.app.expense_tracker.user.subcategory.usecase.SubcategoryFindUseCase;
import dev.app.expense_tracker.user.subcategory.web.model.SubcategoryResponse;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class SubcategoryFindUseCaseFacade implements SubcategoryFindUseCase {

    SubcategoryToSubcategoryResponseMapper subcategoryToSubcategoryResponseMapper;
    SubcategoryService subcategoryService;

    @Override
    public List<SubcategoryResponse> findCategorySubcategories(Long categoryId) {
        List<Subcategory> foundSubcategories = subcategoryService.findSubcategoriesByCategoryId(categoryId);
        return foundSubcategories.stream().map(subcategoryToSubcategoryResponseMapper::map).toList();
    }
}
