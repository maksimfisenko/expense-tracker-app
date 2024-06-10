package dev.app.expense_tracker.user.subcategory.service.impl;

import dev.app.expense_tracker.user.category.model.Category;
import dev.app.expense_tracker.user.category.repository.CategoryRepository;
import dev.app.expense_tracker.user.subcategory.model.Subcategory;
import dev.app.expense_tracker.user.subcategory.repository.SubcategoryRepository;
import dev.app.expense_tracker.user.subcategory.service.SubcategoryService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class SubcategoryServiceImpl implements SubcategoryService {

    SubcategoryRepository subcategoryRepository;
    CategoryRepository categoryRepository;

    @Override
    public Subcategory createSubcategory(Subcategory subcategory) {
        return subcategoryRepository.save(subcategory);
    }

    @Override
    public Subcategory updateSubcategory(Subcategory subcategory) {
        return subcategoryRepository.save(subcategory);
    }

    @Override
    public void deleteSubcategory(Long id) {
        subcategoryRepository.deleteById(id);
    }

    @Override
    public Optional<Subcategory> findSubcategoryById(Long id) {
        return subcategoryRepository.findById(id);
    }

    @Override
    public List<Subcategory> findSubcategoriesByCategoryId(Long categoryId) {
        Category category = categoryRepository.findById(categoryId).orElse(null);
        return subcategoryRepository.findAllByCategory(category);
    }
}
