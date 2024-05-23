package dev.app.expense_tracker.security.api.service.impl;

import dev.app.expense_tracker.security.api.model.CurrentUserApiModel;
import dev.app.expense_tracker.security.api.service.IdentityApiService;
import dev.app.expense_tracker.security.service.UserAccountService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class IdentityApiServiceImpl implements IdentityApiService {

    UserAccountService userAccountService;

    @Override
    public Optional<CurrentUserApiModel> getCurrentUserAccount() {

        SecurityContext securityContext = SecurityContextHolder.getContext();
        Authentication authentication = securityContext.getAuthentication();

        if (authentication == null) {
            return Optional.empty();
        }

        return userAccountService
                .findUserByUsername(authentication.getName())
                .map(userAccount -> new CurrentUserApiModel(userAccount.getId()));
    }
}
