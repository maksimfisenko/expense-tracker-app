package dev.app.expense_tracker.user.category.usecase;

import dev.app.expense_tracker.user.category.web.model.CategoryFindRequest;
import dev.app.expense_tracker.user.category.web.model.CategoryPageResponse;
import dev.app.expense_tracker.user.source.web.model.SourceFindRequest;
import dev.app.expense_tracker.user.source.web.model.SourcePageResponse;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;

@Validated
public interface CategoryFindUseCase {
    CategoryPageResponse findCategories(@Valid CategoryFindRequest categoryFindRequest);
}
