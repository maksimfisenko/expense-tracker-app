package dev.app.expense_tracker.security.usecase.impl;

import dev.app.expense_tracker.security.mapper.RegisterRequestToUserAccountMapper;
import dev.app.expense_tracker.security.model.UserAccount;
import dev.app.expense_tracker.security.service.UserAccountService;
import dev.app.expense_tracker.security.usecase.RegisterAccountUseCase;
import dev.app.expense_tracker.security.web.model.RegisterRequest;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;

@Component
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class RegisterAccountUseCaseFacade implements RegisterAccountUseCase {

    RegisterRequestToUserAccountMapper registerRequestToUserAccountMapper;
    UserAccountService userAccountService;

    @Override
    public void register(RegisterRequest registerRequest) {
        UserAccount userAccount = registerRequestToUserAccountMapper.map(registerRequest);
        userAccountService.createUserAccount(userAccount);
    }
}
