package dev.app.expense_tracker.user.subcategory.mapper.impl;

import dev.app.expense_tracker.common.exception.ExpenseTrackerException;
import dev.app.expense_tracker.user.category.model.Category;
import dev.app.expense_tracker.user.category.service.CategoryService;
import dev.app.expense_tracker.user.subcategory.mapper.SubcategoryAddRequestToSubcategoryMapper;
import dev.app.expense_tracker.user.subcategory.model.Subcategory;
import dev.app.expense_tracker.user.subcategory.web.model.SubcategoryAddRequest;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;

@Component
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class SubcategoryAddRequestToSubcategoryMapperImpl implements SubcategoryAddRequestToSubcategoryMapper {

    CategoryService categoryService;

    @Override
    public Subcategory map(SubcategoryAddRequest subcategoryAddRequest) {

        Subcategory subcategory = new Subcategory();
        subcategory.setName(subcategoryAddRequest.name());

        Category category = categoryService
                .findCategoryById(subcategoryAddRequest.categoryId())
                .orElseThrow(() -> {
                    String errorMessage = String.format(
                            "Category with id = %d not found",
                            subcategoryAddRequest.categoryId()
                    );
                    return new ExpenseTrackerException(errorMessage);
                });

        subcategory.setCategory(category);

        return subcategory;
    }
}
