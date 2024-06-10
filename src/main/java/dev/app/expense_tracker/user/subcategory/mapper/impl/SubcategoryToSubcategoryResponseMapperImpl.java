package dev.app.expense_tracker.user.subcategory.mapper.impl;

import dev.app.expense_tracker.user.subcategory.mapper.SubcategoryToSubcategoryResponseMapper;
import dev.app.expense_tracker.user.subcategory.model.Subcategory;
import dev.app.expense_tracker.user.subcategory.web.model.SubcategoryResponse;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;

@Component
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class SubcategoryToSubcategoryResponseMapperImpl implements SubcategoryToSubcategoryResponseMapper {
    @Override
    public SubcategoryResponse map(Subcategory subcategory) {
        return new SubcategoryResponse(
                subcategory.getId(),
                subcategory.getName(),
                subcategory.getCreatedTimestamp(),
                subcategory.getLastModifiedTimestamp()
        );
    }
}
