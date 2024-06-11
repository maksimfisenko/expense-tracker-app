package dev.app.expense_tracker.user.category.usecase.impl;

import dev.app.expense_tracker.user.category.mapper.CategoryPageToCategoryPageResponseMapper;
import dev.app.expense_tracker.user.category.model.Category;
import dev.app.expense_tracker.user.category.service.CategoryService;
import dev.app.expense_tracker.user.category.usecase.CategoryFindUseCase;
import dev.app.expense_tracker.user.category.web.model.CategoryFindRequest;
import dev.app.expense_tracker.user.category.web.model.CategoryPageResponse;
import dev.app.expense_tracker.user.profile.api.service.CurrentUserProfileApiService;
import dev.app.expense_tracker.user.profile.model.UserProfile;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import static dev.app.expense_tracker.user.source.model.Source_.CREATED_TIMESTAMP;

@Component
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class CategoryFindUseCaseFacade implements CategoryFindUseCase {

    CategoryPageToCategoryPageResponseMapper categoryPageToCategoryPageResponseMapper;
    CategoryService categoryService;
    CurrentUserProfileApiService currentUserProfileApiService;

    @Override
    public CategoryPageResponse findExpenseCategories(CategoryFindRequest categoryFindRequest) {

        UserProfile owner = currentUserProfileApiService.getCurrentUserProfile();

        Sort sort = Sort.by(Sort.Direction.ASC, CREATED_TIMESTAMP);
        Pageable pageable = PageRequest.of(categoryFindRequest.page(), categoryFindRequest.limit(), sort);

        Page<Category> pageableCategoryResult = categoryService.findAllExpenseCategories(owner, pageable);

        return categoryPageToCategoryPageResponseMapper.map(pageableCategoryResult);
    }

    @Override
    public CategoryPageResponse findIncomeCategories(CategoryFindRequest categoryFindRequest) {

        UserProfile owner = currentUserProfileApiService.getCurrentUserProfile();

        Sort sort = Sort.by(Sort.Direction.ASC, CREATED_TIMESTAMP);
        Pageable pageable = PageRequest.of(categoryFindRequest.page(), categoryFindRequest.limit(), sort);

        Page<Category> pageableCategoryResult = categoryService.findAllIncomeCategories(owner, pageable);

        return categoryPageToCategoryPageResponseMapper.map(pageableCategoryResult);
    }
}
