package dev.app.expense_tracker.security.mapper.impl;

import dev.app.expense_tracker.common.exception.ExpenseTrackerException;
import dev.app.expense_tracker.security.mapper.RegisterRequestToUserAccountMapper;
import dev.app.expense_tracker.security.model.UserAccount;
import dev.app.expense_tracker.security.model.UserRole;
import dev.app.expense_tracker.security.service.UserRoleService;
import dev.app.expense_tracker.security.web.model.RegisterRequest;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Locale;
import java.util.Set;

@Component
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class RegisterRequestToUserAccountMapperImpl implements RegisterRequestToUserAccountMapper {

    UserRoleService userRoleService;
    PasswordEncoder passwordEncoder;

    @Override
    public UserAccount map(RegisterRequest registerRequest) {
        UserRole userRole = userRoleService
                .findUserRole()
                .orElseThrow(() -> new ExpenseTrackerException("User role not found"));

        UserAccount userAccount = new UserAccount();
        userAccount.setUsername(registerRequest.username().toLowerCase(Locale.ROOT));
        userAccount.setPassword(passwordEncoder.encode(registerRequest.password()));
        userAccount.setAuthorities(Set.of(userRole));

        return userAccount;
    }
}
