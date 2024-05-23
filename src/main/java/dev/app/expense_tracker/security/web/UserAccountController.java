package dev.app.expense_tracker.security.web;

import dev.app.expense_tracker.security.model.UserAccount;
import dev.app.expense_tracker.security.model.UserRole;
import dev.app.expense_tracker.security.service.UserAccountService;
import dev.app.expense_tracker.security.service.UserRoleService;
import dev.app.expense_tracker.security.web.model.RegisterRequest;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;
import java.util.Set;

@Slf4j
@RestController
@RequestMapping("/api/v1/accounts")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class UserAccountController {

    UserAccountService userAccountService;
    UserRoleService userRoleService;
    PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public void registerAccount(@RequestBody RegisterRequest registerRequest) {
        log.info("Registering account {}", registerRequest);

        Assert.hasLength(registerRequest.username(), "Username cannot be empty");
        Assert.hasLength(registerRequest.password(), "Password cannot be empty");

        UserRole userRole = userRoleService
                .findUserRole()
                .orElseThrow(() -> new RuntimeException("User role not found"));

        UserAccount userAccount = new UserAccount();
        userAccount.setUsername(registerRequest.username().toLowerCase(Locale.ROOT));
        userAccount.setPassword(passwordEncoder.encode(registerRequest.password()));
        userAccount.setAuthorities(Set.of(userRole));

        userAccountService.createUserAccount(userAccount);

    }

}
