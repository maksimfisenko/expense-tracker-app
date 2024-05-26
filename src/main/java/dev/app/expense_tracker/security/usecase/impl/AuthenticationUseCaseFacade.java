package dev.app.expense_tracker.security.usecase.impl;

import dev.app.expense_tracker.security.service.AccessTokenService;
import dev.app.expense_tracker.security.usecase.AuthenticationUseCase;
import dev.app.expense_tracker.security.web.model.AccessToken;
import dev.app.expense_tracker.security.web.model.LoginRequest;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

@Component
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class AuthenticationUseCaseFacade implements AuthenticationUseCase {

    AuthenticationManager authenticationManager;
    AccessTokenService accessTokenService;

    @Override
    public AccessToken authenticate(LoginRequest loginRequest) {

        Authentication authenticationToken = new UsernamePasswordAuthenticationToken(
                loginRequest.username(),
                loginRequest.password()
        );

        Authentication authentication = authenticationManager.authenticate(authenticationToken);

        return new AccessToken(accessTokenService.generateIdToken(authentication));
    }
}
