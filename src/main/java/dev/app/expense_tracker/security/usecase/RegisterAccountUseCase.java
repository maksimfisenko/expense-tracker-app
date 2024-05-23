package dev.app.expense_tracker.security.usecase;

import dev.app.expense_tracker.security.web.model.RegisterRequest;

public interface RegisterAccountUseCase {
    void register(RegisterRequest registerRequest);
}
