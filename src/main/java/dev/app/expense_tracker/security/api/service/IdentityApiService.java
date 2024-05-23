package dev.app.expense_tracker.security.api.service;

import dev.app.expense_tracker.security.api.model.CurrentUserApiModel;

import java.util.Optional;

public interface IdentityApiService {
    Optional<CurrentUserApiModel> getCurrentUserAccount();
}
