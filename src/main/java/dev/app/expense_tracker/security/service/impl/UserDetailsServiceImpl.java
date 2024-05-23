package dev.app.expense_tracker.security.service.impl;

import dev.app.expense_tracker.security.mapper.UserAccountToUserMapper;
import dev.app.expense_tracker.security.service.UserAccountService;
import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {

    UserAccountService userAccountService;
    UserAccountToUserMapper userAccountToUserMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userAccountService
                .findUserByUsername(username)
                .map(userAccountToUserMapper::map)
                .orElseThrow(() -> new UsernameNotFoundException("Bad credentials"));
    }
}
