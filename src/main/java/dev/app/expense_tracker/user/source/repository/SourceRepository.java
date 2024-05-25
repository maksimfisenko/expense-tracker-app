package dev.app.expense_tracker.user.source.repository;

import dev.app.expense_tracker.user.profile.model.UserProfile;
import dev.app.expense_tracker.user.source.model.Source;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface SourceRepository extends JpaRepository<Source, Long> {
    Collection<Source> findAllByUserProfile(UserProfile userProfile);
}
