package dev.app.expense_tracker.security.service.impl;

import dev.app.expense_tracker.common.exception.ExpenseTrackerException;
import dev.app.expense_tracker.security.model.UserAccount;
import dev.app.expense_tracker.security.model.UserRole;
import dev.app.expense_tracker.security.repository.UserAccountRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class UserAccountServiceImplUnitTest {

    @InjectMocks
    private UserAccountServiceImpl userAccountService;
    @Mock
    private UserAccountRepository userAccountRepository;

    @Test
    void createUserAccount_shouldCreateUserAccount() {

        UserAccount userAccount = new UserAccount();
        userAccount.setUsername("demo_user@mail.com");
        userAccount.setPassword("demo_password");
        userAccount.setAuthorities(Collections.singleton(new UserRole()));

        Mockito.when(
                userAccountRepository.existsByUsername(userAccount.getUsername())
        ).thenReturn(
                false
        );

        Mockito.when(
                userAccountRepository.save(userAccount)
        ).thenReturn(
                null
        );

        assertDoesNotThrow(() -> userAccountService.createUserAccount(userAccount));
        Mockito.verify(
                userAccountRepository,
                Mockito.times(1)
        ).existsByUsername(Mockito.any());
        Mockito.verify(
                userAccountRepository,
                Mockito.times(1)
        ).save(Mockito.any());

    }

    @Test
    void createUserAccount_shouldThrowExpenseTrackerException() {

        UserAccount userAccount = new UserAccount();
        userAccount.setUsername("demo_user@mail.com");
        userAccount.setPassword("demo_password");
        userAccount.setAuthorities(Collections.singleton(new UserRole()));

        Mockito.when(
                userAccountRepository.existsByUsername(userAccount.getUsername())
        ).thenReturn(
                true
        );

        assertThrows(
                ExpenseTrackerException.class,
                () -> userAccountService.createUserAccount(userAccount)
        );
        Mockito.verify(
                userAccountRepository,
                Mockito.times(1)
        ).existsByUsername(Mockito.any());
        Mockito.verify(
                userAccountRepository,
                Mockito.never()
        ).save(Mockito.any());

    }

    @Test
    void findUserByUsername_shouldReturnNonEmptyUserAccount() {

        UserAccount expectedUserAccount = new UserAccount();
        expectedUserAccount.setUsername("demo_user@mail.com");
        expectedUserAccount.setPassword("demo_password");
        expectedUserAccount.setAuthorities(Collections.singleton(new UserRole()));

        Mockito.when(
                userAccountRepository.findByUsername(expectedUserAccount.getUsername())
        ).thenReturn(
                Optional.of(expectedUserAccount)
        );

        Optional<UserAccount> actualResult = userAccountService.findUserByUsername(expectedUserAccount.getUsername());
        assertEquals(Optional.of(expectedUserAccount), actualResult);

        // TODO: finish this test

    }

    // TODO: add last test

}