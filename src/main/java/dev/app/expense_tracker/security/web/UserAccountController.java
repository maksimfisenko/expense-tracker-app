package dev.app.expense_tracker.security.web;

import dev.app.expense_tracker.security.usecase.RegisterAccountUseCase;
import dev.app.expense_tracker.security.web.model.RegisterRequest;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/v1/accounts")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class UserAccountController {

    RegisterAccountUseCase registerAccountUseCase;

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public void registerAccount(@Valid @RequestBody RegisterRequest registerRequest) {
        log.info("Registering account {}", registerRequest);
        registerAccountUseCase.register(registerRequest);
    }
}
