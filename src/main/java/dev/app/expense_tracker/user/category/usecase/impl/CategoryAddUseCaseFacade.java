package dev.app.expense_tracker.user.category.usecase.impl;

import dev.app.expense_tracker.user.category.mapper.CategoryAddRequestToCategoryMapper;
import dev.app.expense_tracker.user.category.mapper.CategoryToCategoryResponseMapper;
import dev.app.expense_tracker.user.category.model.Category;
import dev.app.expense_tracker.user.category.service.CategoryService;
import dev.app.expense_tracker.user.category.usecase.CategoryAddUseCase;
import dev.app.expense_tracker.user.category.web.model.CategoryAddRequest;
import dev.app.expense_tracker.user.category.web.model.CategoryResponse;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;

@Component
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class CategoryAddUseCaseFacade implements CategoryAddUseCase {

    CategoryAddRequestToCategoryMapper categoryAddRequestToCategoryMapper;
    CategoryToCategoryResponseMapper categoryToCategoryResponseMapper;
    CategoryService categoryService;

    @Override
    public CategoryResponse addCategory(CategoryAddRequest categoryAddRequest) {
        Category mappedCategory = categoryAddRequestToCategoryMapper.map(categoryAddRequest);
        Category createdCategory = categoryService.createCategory(mappedCategory);
        return categoryToCategoryResponseMapper.map(createdCategory);
    }

}
