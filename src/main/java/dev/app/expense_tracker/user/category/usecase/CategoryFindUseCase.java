package dev.app.expense_tracker.user.category.usecase;

import dev.app.expense_tracker.user.category.web.model.CategoryFindRequest;
import dev.app.expense_tracker.user.category.web.model.CategoryPageResponse;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;

@Validated
public interface CategoryFindUseCase {
    CategoryPageResponse findExpenseCategories(@Valid CategoryFindRequest categoryFindRequest);
    CategoryPageResponse findIncomeCategories(@Valid CategoryFindRequest categoryFindRequest);
}
