package dev.app.expense_tracker.user.subcategory.service;

import dev.app.expense_tracker.user.subcategory.model.Subcategory;

import java.util.List;
import java.util.Optional;

public interface SubcategoryService {
    Subcategory createSubcategory(Subcategory subcategory);
    Subcategory updateSubcategory(Subcategory subcategory);
    void deleteSubcategory(Long id);
    Optional<Subcategory> findSubcategoryById(Long id);
    List<Subcategory> findSubcategoriesByCategoryId(Long categoryId);
}
