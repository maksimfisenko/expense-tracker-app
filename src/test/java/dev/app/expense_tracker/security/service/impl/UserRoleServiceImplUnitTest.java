package dev.app.expense_tracker.security.service.impl;

import dev.app.expense_tracker.security.model.UserRole;
import dev.app.expense_tracker.security.repository.UserRoleRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class UserRoleServiceImplUnitTest {

    @InjectMocks
    private UserRoleServiceImpl userRoleService;
    @Mock
    private UserRoleRepository userRoleRepository;

    @Test
    void shouldReturnNonEmptyUserRole() {

        UserRole expectedUserRole = new UserRole();
        expectedUserRole.setAuthority("ROLE_USER");

        Mockito.when(
                userRoleRepository.findByAuthority("ROLE_USER")
        ).thenReturn(
                Optional.of(expectedUserRole)
        );

        Optional<UserRole> actualUserRole = userRoleService.findUserRole();

        assertEquals(Optional.of(expectedUserRole), actualUserRole);
        Mockito.verify(
                userRoleRepository,
                Mockito.times(1)
        ).findByAuthority(Mockito.any());

    }

    @Test
    void shouldReturnEmptyUserRole() {

        Mockito.when(
                userRoleRepository.findByAuthority("ROLE_USER")
        ).thenReturn(
                Optional.empty()
        );

        Optional<UserRole> actualUserRole = userRoleService.findUserRole();

        assertEquals(Optional.empty(), actualUserRole);
        Mockito.verify(
                userRoleRepository,
                Mockito.times(1)
        ).findByAuthority(Mockito.any());

    }

}