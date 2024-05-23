package dev.app.expense_tracker.security.web;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/v1/demo")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class DemoController {

    @GetMapping("/only-auth")
    public String hitOnlyAuthEndpoint() {
        return "This is protected resource";
    }

    @GetMapping("/only-role-user")
    public String hitOnlyRoleUserEndpoint() {
        return "This is protected resource";
    }

    @GetMapping("/only-role-admin")
    public String hitOnlyRoleAdminEndpoint() {
        return "This is protected resource";
    }

}
