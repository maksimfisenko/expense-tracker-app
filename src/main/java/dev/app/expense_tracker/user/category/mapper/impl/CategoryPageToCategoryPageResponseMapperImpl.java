package dev.app.expense_tracker.user.category.mapper.impl;

import dev.app.expense_tracker.user.category.mapper.CategoryPageToCategoryPageResponseMapper;
import dev.app.expense_tracker.user.category.mapper.CategoryToCategoryResponseMapper;
import dev.app.expense_tracker.user.category.model.Category;
import dev.app.expense_tracker.user.category.web.model.CategoryPageResponse;
import dev.app.expense_tracker.user.category.web.model.CategoryResponse;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class CategoryPageToCategoryPageResponseMapperImpl implements CategoryPageToCategoryPageResponseMapper {

    CategoryToCategoryResponseMapper categoryToCategoryResponseMapper;

    @Override
    public CategoryPageResponse map(Page<Category> categories) {

        Collection<CategoryResponse> categoryPageResponses = categories
                .stream()
                .map(categoryToCategoryResponseMapper::map)
                .toList();

        return new CategoryPageResponse(
                categories.getTotalElements(),
                categories.isFirst(),
                categories.isLast(),
                categoryPageResponses);
    }
}
