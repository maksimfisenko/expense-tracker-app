package dev.app.expense_tracker.user.profile.service;

import dev.app.expense_tracker.user.profile.model.UserProfile;

import java.util.Optional;

public interface UserProfileService {
    void createUserProfile(UserProfile userProfile);
    Optional<UserProfile> findUserProfileById(Long id);
}
