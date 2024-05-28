package dev.app.expense_tracker.user.category.repository;

import dev.app.expense_tracker.user.category.model.Category;
import dev.app.expense_tracker.user.profile.model.UserProfile;
import dev.app.expense_tracker.user.source.model.Source;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    Page<Category> findAllByUserProfile(UserProfile userProfile, Pageable pageable);
}
