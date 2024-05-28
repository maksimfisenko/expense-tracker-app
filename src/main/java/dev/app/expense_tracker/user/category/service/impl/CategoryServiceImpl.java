package dev.app.expense_tracker.user.category.service.impl;

import dev.app.expense_tracker.user.category.model.Category;
import dev.app.expense_tracker.user.category.repository.CategoryRepository;
import dev.app.expense_tracker.user.category.service.CategoryService;
import dev.app.expense_tracker.user.profile.model.UserProfile;
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

    @Override
    public Category createCategory(Category category) {
        return categoryRepository.save(category);
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
    public Page<Category> findAllCategories(UserProfile owner, Pageable pageable) {
        return categoryRepository.findAllByUserProfile(owner, pageable);
    }
}
