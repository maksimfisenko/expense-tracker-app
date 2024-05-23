package dev.app.expense_tracker.security.service;

import dev.app.expense_tracker.security.model.UserAccount;

import java.util.Optional;

public interface UserAccountService {
    void createUserAccount(UserAccount userAccount);
    Optional<UserAccount> findUserByUsername(String username);
}
