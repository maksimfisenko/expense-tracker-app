package dev.app.expense_tracker.security.service.impl;

import dev.app.expense_tracker.security.model.UserAccount;
import dev.app.expense_tracker.security.repository.UserAccountRepository;
import dev.app.expense_tracker.security.service.UserAccountService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class UserAccountServiceImpl implements UserAccountService {

    UserAccountRepository userAccountRepository;

    @Override
    public void createUserAccount(UserAccount userAccount) {

        if (userAccountRepository.existsByUsername(userAccount.getUsername())) {
            throw new RuntimeException("Account with this username already exists");
        }

        userAccountRepository.save(userAccount);
    }
}
