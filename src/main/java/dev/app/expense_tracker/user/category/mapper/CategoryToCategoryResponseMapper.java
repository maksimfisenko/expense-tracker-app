package dev.app.expense_tracker.user.category.mapper;

import dev.app.expense_tracker.common.mapper.Mapper;
import dev.app.expense_tracker.user.category.model.Category;
import dev.app.expense_tracker.user.category.web.model.CategoryResponse;

public interface CategoryToCategoryResponseMapper extends Mapper<CategoryResponse, Category> {
}
