package dev.app.expense_tracker.security.web;

import dev.app.expense_tracker.security.usecase.AuthenticationUseCase;
import dev.app.expense_tracker.security.web.model.AccessToken;
import dev.app.expense_tracker.security.web.model.LoginRequest;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/v1/authentication")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class AuthenticationController {

    AuthenticationUseCase authenticationUseCase;

    @PostMapping("/access-token")
    @ResponseStatus(HttpStatus.OK)
    public AccessToken getToken(@Valid @RequestBody LoginRequest loginRequest) {
        return authenticationUseCase.authenticate(loginRequest);
    }

}
