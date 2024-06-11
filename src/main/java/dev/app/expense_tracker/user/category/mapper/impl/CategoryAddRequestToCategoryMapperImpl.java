package dev.app.expense_tracker.user.category.mapper.impl;

import dev.app.expense_tracker.user.category.mapper.CategoryAddRequestToCategoryMapper;
import dev.app.expense_tracker.user.category.model.Category;
import dev.app.expense_tracker.user.category.model.CategoryType;
import dev.app.expense_tracker.user.category.web.model.CategoryAddRequest;
import dev.app.expense_tracker.user.profile.api.service.CurrentUserProfileApiService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;

@Component
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class CategoryAddRequestToCategoryMapperImpl implements CategoryAddRequestToCategoryMapper {

    CurrentUserProfileApiService currentUserProfileApiService;

    @Override
    public Category map(CategoryAddRequest categoryAddRequest) {

        Category category = new Category();
        category.setType(CategoryType.valueOf(categoryAddRequest.type()));
        category.setName(categoryAddRequest.name());
        category.setHex(categoryAddRequest.hex());
        category.setCurrency(categoryAddRequest.currency());
        category.setUserProfile(currentUserProfileApiService.getCurrentUserProfile());

        return category;
    }
}
