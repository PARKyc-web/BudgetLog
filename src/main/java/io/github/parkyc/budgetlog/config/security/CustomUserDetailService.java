package io.github.parkyc.budgetlog.config.security;

import io.github.parkyc.budgetlog.user.entity.UserBase;
import io.github.parkyc.budgetlog.user.repository.UserBaseRepository;
import io.github.parkyc.budgetlog.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailService implements UserDetailsService {

    private final UserBaseRepository userBaseRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserBase base = userBaseRepository.findByUserId(username);
        if(base == null) {
            throw new UsernameNotFoundException("User not Found :: " + username);
        }

        return User.builder()
                .username(base.getUserId())
                .password(base.getPassword())
                .roles(base.getUserRole())
                .build();
    }
}
