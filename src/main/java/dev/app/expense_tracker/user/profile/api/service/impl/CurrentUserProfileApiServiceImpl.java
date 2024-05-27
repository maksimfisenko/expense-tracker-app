package dev.app.expense_tracker.user.profile.api.service.impl;

import dev.app.expense_tracker.common.exception.ExpenseTrackerException;
import dev.app.expense_tracker.security.api.model.CurrentUserApiModel;
import dev.app.expense_tracker.security.api.service.IdentityApiService;
import dev.app.expense_tracker.user.profile.api.service.CurrentUserProfileApiService;
import dev.app.expense_tracker.user.profile.model.UserProfile;
import dev.app.expense_tracker.user.profile.service.UserProfileService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class CurrentUserProfileApiServiceImpl implements CurrentUserProfileApiService {

    IdentityApiService identityApiService;
    UserProfileService userProfileService;

    @Override
    public UserProfile getCurrentUserProfile() {

        CurrentUserApiModel currentUserApiModel = identityApiService
                .getCurrentUserAccount()
                .orElseThrow(() -> new ExpenseTrackerException("User should be authenticated"));
        return userProfileService
                .findUserProfileById(currentUserApiModel.userAccountId())
                .orElseThrow(() -> {
                    String errorMessage = String.format(
                            "User with id = %d does not exist",
                            currentUserApiModel.userAccountId()
                    );
                    return new ExpenseTrackerException(errorMessage);
                });
    }
}
