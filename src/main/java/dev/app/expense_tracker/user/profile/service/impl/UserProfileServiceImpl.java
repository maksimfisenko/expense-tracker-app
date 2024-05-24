package dev.app.expense_tracker.user.profile.service.impl;

import dev.app.expense_tracker.user.profile.model.UserProfile;
import dev.app.expense_tracker.user.profile.repository.UserProfileRepository;
import dev.app.expense_tracker.user.profile.service.UserProfileService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class UserProfileServiceImpl implements UserProfileService {

    UserProfileRepository userProfileRepository;

    @Override
    public void createUserProfile(UserProfile userProfile) {

        if (userProfileRepository.existsById(userProfile.getId())) {
            String errorMessage = String.format("User profile with id = %d already exists", userProfile.getId());
            throw new RuntimeException(errorMessage);
        }

        userProfileRepository.save(userProfile);
    }

    @Override
    public Optional<UserProfile> findUserProfileById(Long id) {
        return userProfileRepository.findById(id);
    }
}
