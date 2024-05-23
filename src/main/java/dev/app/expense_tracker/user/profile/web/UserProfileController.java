package dev.app.expense_tracker.user.profile.web;

import dev.app.expense_tracker.user.profile.usecase.UserProfileRegisterUseCase;
import dev.app.expense_tracker.user.profile.web.model.UserProfileRegisterRequest;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/user-profiles")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class UserProfileController {

    UserProfileRegisterUseCase userProfileRegisterUseCase;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void registerUserProfile(@Valid @RequestBody UserProfileRegisterRequest userProfileRegisterRequest) {
        userProfileRegisterUseCase.registerUserProfile(userProfileRegisterRequest);
    }

}
