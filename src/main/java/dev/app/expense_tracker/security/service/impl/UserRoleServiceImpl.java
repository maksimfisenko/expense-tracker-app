package dev.app.expense_tracker.security.service.impl;

import dev.app.expense_tracker.security.model.UserRole;
import dev.app.expense_tracker.security.repository.UserRoleRepository;
import dev.app.expense_tracker.security.service.UserRoleService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class UserRoleServiceImpl implements UserRoleService {

    UserRoleRepository userRoleRepository;

    @Override
    public Optional<UserRole> findUserRole() {
        return userRoleRepository.findByAuthority("ROLE_USER");
    }
}
