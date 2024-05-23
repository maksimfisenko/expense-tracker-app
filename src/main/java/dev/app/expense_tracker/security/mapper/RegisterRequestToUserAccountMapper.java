package dev.app.expense_tracker.security.mapper;

import dev.app.expense_tracker.security.model.UserAccount;
import dev.app.expense_tracker.security.web.model.RegisterRequest;

public interface RegisterRequestToUserAccountMapper extends Mapper<UserAccount, RegisterRequest> {
}
