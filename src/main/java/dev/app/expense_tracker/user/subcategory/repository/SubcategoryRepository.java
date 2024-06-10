package dev.app.expense_tracker.user.subcategory.repository;

import dev.app.expense_tracker.user.category.model.Category;
import dev.app.expense_tracker.user.subcategory.model.Subcategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubcategoryRepository extends JpaRepository<Subcategory, Long> {
    List<Subcategory> findAllByCategory(Category category);
}
