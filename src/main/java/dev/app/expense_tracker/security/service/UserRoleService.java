package dev.app.expense_tracker.security.service;

import dev.app.expense_tracker.security.model.UserRole;

import java.util.Optional;

public interface UserRoleService {
    Optional<UserRole> findUserRole();
}
