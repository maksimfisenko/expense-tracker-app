package dev.app.expense_tracker.user.category.usecase.impl;

import dev.app.expense_tracker.common.exception.ExpenseTrackerException;
import dev.app.expense_tracker.user.category.model.Category;
import dev.app.expense_tracker.user.category.service.CategoryService;
import dev.app.expense_tracker.user.category.usecase.CategoryDeleteUseCase;
import dev.app.expense_tracker.user.profile.api.service.CurrentUserProfileApiService;
import dev.app.expense_tracker.user.profile.model.UserProfile;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;

@Component
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class CategoryDeleteUseCaseFacade implements CategoryDeleteUseCase {

    CategoryService categoryService;
    CurrentUserProfileApiService currentUserProfileApiService;

    @Override
    public void deleteCategory(Long categoryId) {

        UserProfile actor = currentUserProfileApiService.getCurrentUserProfile();

        UserProfile owner = categoryService
                .findCategoryById(categoryId)
                .map(Category::getUserProfile)
                .orElseThrow(() -> {
                    String errorMessage = String.format("Category with id = %d not found", categoryId);
                    return new ExpenseTrackerException(errorMessage);
                });

        if (!actor.equals(owner)) {
            String errorMessage = String.format(
                    "Deleting category with id = %d not possible as %s is not its owner.",
                    categoryId,
                    actor.getName());
            throw new ExpenseTrackerException(errorMessage);
        }

        categoryService.deleteCategory(categoryId);
    }
}
