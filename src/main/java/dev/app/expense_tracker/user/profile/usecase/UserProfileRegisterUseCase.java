package dev.app.expense_tracker.user.profile.usecase;

import dev.app.expense_tracker.user.profile.web.model.UserProfileRegisterRequest;

public interface UserProfileRegisterUseCase {
    void registerUserProfile(UserProfileRegisterRequest userProfileRegisterRequest);
}
