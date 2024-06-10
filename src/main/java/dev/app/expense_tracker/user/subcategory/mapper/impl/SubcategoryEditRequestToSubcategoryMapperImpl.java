package dev.app.expense_tracker.user.subcategory.mapper.impl;

import dev.app.expense_tracker.common.exception.ExpenseTrackerException;
import dev.app.expense_tracker.user.subcategory.mapper.SubcategoryEditRequestToSubcategoryMapper;
import dev.app.expense_tracker.user.subcategory.model.Subcategory;
import dev.app.expense_tracker.user.subcategory.service.SubcategoryService;
import dev.app.expense_tracker.user.subcategory.web.model.SubcategoryEditRequest;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;

@Component
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class SubcategoryEditRequestToSubcategoryMapperImpl implements SubcategoryEditRequestToSubcategoryMapper {

    SubcategoryService subcategoryService;

    @Override
    public Subcategory map(SubcategoryEditRequest subcategoryEditRequest) {

        Subcategory currentSubcategory = subcategoryService
                .findSubcategoryById(subcategoryEditRequest.id())
                .orElseThrow(() -> {
                    String errorMessage = String.format(
                            "Subcategory with id = %d not found",
                            subcategoryEditRequest.id()
                    );
                    return new ExpenseTrackerException(errorMessage);
                });

        currentSubcategory.setName(subcategoryEditRequest.name());

        return currentSubcategory;
    }
}
