package dev.app.expense_tracker.user.profile.mapper;

import dev.app.expense_tracker.security.mapper.Mapper;
import dev.app.expense_tracker.user.profile.model.UserProfile;
import dev.app.expense_tracker.user.profile.web.model.UserProfileRegisterRequest;

public interface UserProfileRegisterRequestToUserProfileMapper
        extends Mapper<UserProfile, UserProfileRegisterRequest> {
}
