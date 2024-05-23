package dev.app.expense_tracker.security.mapper.impl;

import dev.app.expense_tracker.security.mapper.UserAccountToUserMapper;
import dev.app.expense_tracker.security.model.UserAccount;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

@Component
public class UserAccountToUserMapperImpl implements UserAccountToUserMapper {
    @Override
    public User map(UserAccount userAccount) {
        return new User(
                userAccount.getUsername(),
                userAccount.getPassword(),
                userAccount.getAuthorities());
    }
}
