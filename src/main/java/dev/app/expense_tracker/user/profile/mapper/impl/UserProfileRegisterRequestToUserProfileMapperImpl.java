package dev.app.expense_tracker.user.profile.mapper.impl;

import dev.app.expense_tracker.security.api.model.CurrentUserApiModel;
import dev.app.expense_tracker.security.api.service.IdentityApiService;
import dev.app.expense_tracker.user.profile.mapper.UserProfileRegisterRequestToUserProfileMapper;
import dev.app.expense_tracker.user.profile.model.UserProfile;
import dev.app.expense_tracker.user.profile.web.model.UserProfileRegisterRequest;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;

@Component
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class UserProfileRegisterRequestToUserProfileMapperImpl
        implements UserProfileRegisterRequestToUserProfileMapper {

    IdentityApiService identityApiService;

    @Override
    public UserProfile map(UserProfileRegisterRequest userProfileRegisterRequest) {

        CurrentUserApiModel currentUserApiModel = identityApiService
                .getCurrentUserAccount()
                .orElseThrow(() -> new RuntimeException("In order to create a profile user needs to be authorized"));

        UserProfile userProfile = new UserProfile();
        userProfile.setId(currentUserApiModel.userAccountId());
        userProfile.setName(userProfileRegisterRequest.name());
        userProfile.setImageLink(userProfileRegisterRequest.imageLink());
        return userProfile;
    }
}
