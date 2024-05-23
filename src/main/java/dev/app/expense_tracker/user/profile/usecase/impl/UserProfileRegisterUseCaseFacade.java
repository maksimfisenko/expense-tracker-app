package dev.app.expense_tracker.user.profile.usecase.impl;

import dev.app.expense_tracker.user.profile.mapper.UserProfileRegisterRequestToUserProfileMapper;
import dev.app.expense_tracker.user.profile.model.UserProfile;
import dev.app.expense_tracker.user.profile.service.UserProfileService;
import dev.app.expense_tracker.user.profile.usecase.UserProfileRegisterUseCase;
import dev.app.expense_tracker.user.profile.web.model.UserProfileRegisterRequest;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;

@Component
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class UserProfileRegisterUseCaseFacade implements UserProfileRegisterUseCase {

    UserProfileService userProfileService;
    UserProfileRegisterRequestToUserProfileMapper userProfileRegisterRequestToUserProfileMapper;

    @Override
    public void registerUserProfile(UserProfileRegisterRequest userProfileRegisterRequest) {
        UserProfile userProfile = userProfileRegisterRequestToUserProfileMapper.map(userProfileRegisterRequest);
        userProfileService.createUserProfile(userProfile);
    }
}
