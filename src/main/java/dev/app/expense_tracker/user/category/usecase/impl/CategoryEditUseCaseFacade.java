package dev.app.expense_tracker.user.category.usecase.impl;

import dev.app.expense_tracker.common.exception.ExpenseTrackerException;
import dev.app.expense_tracker.user.category.mapper.CategoryEditRequestToCategoryMapper;
import dev.app.expense_tracker.user.category.mapper.CategoryToCategoryResponseMapper;
import dev.app.expense_tracker.user.category.model.Category;
import dev.app.expense_tracker.user.category.service.CategoryService;
import dev.app.expense_tracker.user.category.usecase.CategoryEditUseCase;
import dev.app.expense_tracker.user.category.web.model.CategoryEditRequest;
import dev.app.expense_tracker.user.category.web.model.CategoryResponse;
import dev.app.expense_tracker.user.profile.api.service.CurrentUserProfileApiService;
import dev.app.expense_tracker.user.profile.model.UserProfile;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;

@Component
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class CategoryEditUseCaseFacade implements CategoryEditUseCase {

    CategoryEditRequestToCategoryMapper categoryEditRequestToCategoryMapper;
    CategoryToCategoryResponseMapper categoryToCategoryResponseMapper;
    CategoryService categoryService;
    CurrentUserProfileApiService currentUserProfileApiService;

    @Override
    public CategoryResponse editCategory(CategoryEditRequest categoryEditRequest) {

        UserProfile actor = currentUserProfileApiService.getCurrentUserProfile();

        UserProfile owner = categoryService
                .findCategoryById(categoryEditRequest.id())
                .map(Category::getUserProfile)
                .orElseThrow(() -> {
                    String errorMessage = String.format("Category with id = %d not found", categoryEditRequest.id());
                    return new ExpenseTrackerException(errorMessage);
                });

        if (!actor.equals(owner)) {
            String errorMessage = String.format(
                    "Editing category with id = %d not possible as %s is not its owner.",
                    categoryEditRequest.id(),
                    actor.getName());
            throw new ExpenseTrackerException(errorMessage);
        }

        Category category = categoryEditRequestToCategoryMapper.map(categoryEditRequest);
        Category updatedCategory = categoryService.updateCategory(category);
        return categoryToCategoryResponseMapper.map(updatedCategory);
    }
}
