package dev.app.expense_tracker.security.usecase;

import dev.app.expense_tracker.security.web.model.AccessToken;
import dev.app.expense_tracker.security.web.model.LoginRequest;

public interface AuthenticationUseCase {
    AccessToken authenticate(LoginRequest loginRequest);
}
