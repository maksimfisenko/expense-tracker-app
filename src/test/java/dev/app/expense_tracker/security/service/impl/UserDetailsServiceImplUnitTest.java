package dev.app.expense_tracker.security.service.impl;

import dev.app.expense_tracker.security.mapper.UserAccountToUserMapper;
import dev.app.expense_tracker.security.model.UserAccount;
import dev.app.expense_tracker.security.model.UserRole;
import dev.app.expense_tracker.security.service.UserAccountService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Collections;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
class UserDetailsServiceImplUnitTest {

    @InjectMocks
    private UserDetailsServiceImpl userDetailsService;
    @Mock
    private UserAccountService userAccountService;
    @Mock
    private UserAccountToUserMapper userAccountToUserMapper;

    @Test
    void shouldReturnNonEmptyUserDetails() {

        UserAccount userAccount = new UserAccount();
        userAccount.setUsername("demo_user@mail.com");
        userAccount.setPassword("demo_password");
        userAccount.setAuthorities(Collections.singleton(new UserRole()));

        User expectedUser = new User(
                userAccount.getUsername(),
                userAccount.getPassword(),
                userAccount.getAuthorities()
        );

        Mockito.when(
                userAccountService.findUserByUsername(userAccount.getUsername())
        ).thenReturn(
                Optional.of(userAccount)
        );

        Mockito.when(
                userAccountToUserMapper.map(userAccount)
        ).thenReturn(
                expectedUser
        );

        UserDetails actualUser = userDetailsService.loadUserByUsername(userAccount.getUsername());

        assertEquals(expectedUser, actualUser);
        Mockito.verify(
                userAccountService,
                Mockito.times(1)
        ).findUserByUsername(Mockito.any());
        Mockito.verify(
                userAccountToUserMapper,
                Mockito.times(1)
        ).map(Mockito.any());

    }

    @Test
    void shouldReturnUserNotFoundException() {

        UserAccount userAccount = new UserAccount();
        userAccount.setUsername("demo_user@mail.com");
        userAccount.setPassword("demo_password");
        userAccount.setAuthorities(Collections.singleton(new UserRole()));

        Mockito.when(
                userAccountService.findUserByUsername(userAccount.getUsername())
        ).thenReturn(
                Optional.empty()
        );

        assertThrows(
                UsernameNotFoundException.class,
                () -> userDetailsService.loadUserByUsername(userAccount.getUsername())
        );
        Mockito.verify(
                userAccountToUserMapper,
                Mockito.never()
        ).map(Mockito.any());
    }
}