package dev.app.expense_tracker.user.profile.service.impl;

import dev.app.expense_tracker.common.exception.ExpenseTrackerException;
import dev.app.expense_tracker.user.profile.model.UserProfile;
import dev.app.expense_tracker.user.profile.repository.UserProfileRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class UserProfileServiceImplUnitTest {

    @InjectMocks
    private UserProfileServiceImpl userProfileService;
    @Mock
    private UserProfileRepository userProfileRepository;

    @Test
    void createUserProfile_shouldCreateUserProfile() {

        UserProfile userProfile = new UserProfile();
        userProfile.setName("Random Name");
        userProfile.setImageLink("Random Image Link");

        Mockito.when(
                userProfileRepository.existsById(Mockito.any())
        ).thenReturn(
                false
        );
        Mockito.when(
                userProfileRepository.save(Mockito.any())
        ).thenReturn(
                null
        );

        assertDoesNotThrow(() -> userProfileService.createUserProfile(userProfile));
        Mockito.verify(
                userProfileRepository,
                Mockito.times(1)
        ).existsById(Mockito.any());
        Mockito.verify(
                userProfileRepository,
                Mockito.times(1)
        ).save(Mockito.any());
    }

    @Test
    void createUserProfile_shouldThrowExpenseTrackerException() {

        UserProfile userProfile = new UserProfile();
        userProfile.setName("Random Name");
        userProfile.setImageLink("Random Image Link");

        Mockito.when(
                userProfileRepository.existsById(Mockito.any())
        ).thenReturn(
                true
        );

        assertThrows(
                ExpenseTrackerException.class,
                () -> userProfileService.createUserProfile(userProfile)
        );
        Mockito.verify(
                userProfileRepository,
                Mockito.times(1)
        ).existsById(Mockito.any());
        Mockito.verify(
                userProfileRepository,
                Mockito.never()
        ).save(Mockito.any());
    }

    @Test
    void findUserProfileById_shouldReturnNonEmptyUserProfile() {

        UserProfile expectedUserProfile = new UserProfile();
        expectedUserProfile.setName("Random Name");
        expectedUserProfile.setImageLink("Random Image Link");

        Mockito.when(
                userProfileRepository.findById(expectedUserProfile.getId())
        ).thenReturn(
                Optional.of(expectedUserProfile)
        );

        Optional<UserProfile> actualResult = userProfileService.findUserProfileById(expectedUserProfile.getId());

        assertEquals(Optional.of(expectedUserProfile), actualResult);
        Mockito.verify(
                userProfileRepository,
                Mockito.times(1)
        ).findById(Mockito.any());
    }

    @Test
    void findUserProfileById_shouldReturnEmptyUserProfile() {

        UserProfile expectedUserProfile = new UserProfile();
        expectedUserProfile.setName("Random Name");
        expectedUserProfile.setImageLink("Random Image Link");

        Mockito.when(
                userProfileRepository.findById(expectedUserProfile.getId())
        ).thenReturn(
                Optional.empty()
        );

        Optional<UserProfile> actualResult = userProfileService.findUserProfileById(expectedUserProfile.getId());

        assertEquals(Optional.empty(), actualResult);
        Mockito.verify(
                userProfileRepository,
                Mockito.times(1)
        ).findById(Mockito.any());
    }

}