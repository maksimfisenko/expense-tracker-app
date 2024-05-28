package dev.app.expense_tracker.user.category.mapper.impl;

import dev.app.expense_tracker.user.category.mapper.CategoryToCategoryResponseMapper;
import dev.app.expense_tracker.user.category.model.Category;
import dev.app.expense_tracker.user.category.web.model.CategoryResponse;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;

@Component
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class CategoryToCategoryResponseMapperImpl implements CategoryToCategoryResponseMapper {

    @Override
    public CategoryResponse map(Category category) {
        return new CategoryResponse(
                category.getId(),
                category.getName(),
                category.getHex(),
                category.getCurrency(),
                category.getCreatedTimestamp(),
                category.getLastModifiedTimestamp()
        );
    }
}
