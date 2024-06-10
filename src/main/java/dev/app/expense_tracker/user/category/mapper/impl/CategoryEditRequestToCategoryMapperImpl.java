package dev.app.expense_tracker.user.category.mapper.impl;

import dev.app.expense_tracker.common.exception.ExpenseTrackerException;
import dev.app.expense_tracker.user.category.mapper.CategoryEditRequestToCategoryMapper;
import dev.app.expense_tracker.user.category.model.Category;
import dev.app.expense_tracker.user.category.service.CategoryService;
import dev.app.expense_tracker.user.category.web.model.CategoryEditRequest;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;

@Component
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class CategoryEditRequestToCategoryMapperImpl implements CategoryEditRequestToCategoryMapper {

    CategoryService categoryService;

    @Override
    public Category map(CategoryEditRequest categoryEditRequest) {

        Category currentCategory = categoryService
                .findCategoryById(categoryEditRequest.id())
                .orElseThrow(() -> {
                    String errorMessage = String.format("Category with id = %d not found", categoryEditRequest.id());
                    return new ExpenseTrackerException(errorMessage);
                });

        currentCategory.setName(categoryEditRequest.name());
        currentCategory.setHex(categoryEditRequest.hex());
        currentCategory.setCurrency(categoryEditRequest.currency());

        return currentCategory;
    }
}
