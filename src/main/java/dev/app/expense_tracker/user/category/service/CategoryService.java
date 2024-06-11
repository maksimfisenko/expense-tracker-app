package dev.app.expense_tracker.user.category.service;

import dev.app.expense_tracker.user.category.model.Category;
import dev.app.expense_tracker.user.profile.model.UserProfile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface CategoryService {
    Category createCategory(Category category);
    Category updateCategory(Category category);
    Optional<Category> findCategoryById(Long id);
    void deleteCategory(Long id);
    Page<Category> findAllExpenseCategories(UserProfile owner, Pageable pageable);
    Page<Category> findAllIncomeCategories(UserProfile owner, Pageable pageable);
}
