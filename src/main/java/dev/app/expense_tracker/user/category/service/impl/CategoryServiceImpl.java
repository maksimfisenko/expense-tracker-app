package dev.app.expense_tracker.user.category.service.impl;

import dev.app.expense_tracker.user.category.model.Category;
import dev.app.expense_tracker.user.category.model.CategoryType;
import dev.app.expense_tracker.user.category.repository.CategoryRepository;
import dev.app.expense_tracker.user.category.service.CategoryService;
import dev.app.expense_tracker.user.profile.model.UserProfile;
import dev.app.expense_tracker.user.subcategory.model.Subcategory;
import dev.app.expense_tracker.user.subcategory.repository.SubcategoryRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    CategoryRepository categoryRepository;
    SubcategoryRepository subcategoryRepository;

    @Override
    public Category createCategory(Category category) {

        Subcategory subcategory = new Subcategory();
        subcategory.setName("Default");

        Category savedCategory = categoryRepository.save(category);
        subcategory.setCategory(savedCategory);
        subcategoryRepository.save(subcategory);

        return savedCategory;
    }

    @Override
    public Category updateCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Optional<Category> findCategoryById(Long id) {
        return categoryRepository.findById(id);
    }

    @Override
    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public Page<Category> findAllExpenseCategories(UserProfile owner, Pageable pageable) {
        return categoryRepository.findAllByUserProfileAndType(owner, CategoryType.valueOf("EXPENSE"), pageable);
    }

    @Override
    public Page<Category> findAllIncomeCategories(UserProfile owner, Pageable pageable) {
        return categoryRepository.findAllByUserProfileAndType(owner, CategoryType.valueOf("INCOME"), pageable);
    }
}
