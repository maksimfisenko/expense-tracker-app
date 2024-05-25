package dev.app.expense_tracker.user.source.repository;

import dev.app.expense_tracker.user.profile.model.UserProfile;
import dev.app.expense_tracker.user.source.model.Source;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SourceRepository extends JpaRepository<Source, Long> {
    Page<Source> findAllByUserProfile(UserProfile userProfile, Pageable pageable);
}
