package dev.app.expense_tracker.security.mapper;

import dev.app.expense_tracker.security.model.UserAccount;
import dev.app.expense_tracker.security.web.model.RegisterRequest;
import org.springframework.security.core.userdetails.User;

public interface UserAccountToUserMapper extends Mapper<User, UserAccount> {
}
