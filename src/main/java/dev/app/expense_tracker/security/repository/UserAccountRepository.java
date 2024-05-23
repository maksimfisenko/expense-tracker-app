package dev.app.expense_tracker.security.repository;

import dev.app.expense_tracker.security.model.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserAccountRepository extends JpaRepository<UserAccount, Long> {
    boolean existsByUsername(String username);
}
