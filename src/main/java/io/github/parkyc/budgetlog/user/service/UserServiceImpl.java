package io.github.parkyc.budgetlog.user.service;

import io.github.parkyc.budgetlog.user.dto.LoginDTO;
import io.github.parkyc.budgetlog.user.dto.UserAuthDTO;
import io.github.parkyc.budgetlog.user.entity.UserAuth;
import io.github.parkyc.budgetlog.user.repository.UserAuthRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserAuthRepository userAuthRepository;

    private final PasswordEncoder passwordEncoder;

    @Override
    public LoginDTO signUp(LoginDTO loginDTO) {

        UserAuth userAuth = new UserAuth();
        userAuth.setEmail(loginDTO.getEmail());
        userAuth.setPassword(passwordEncoder.encode(loginDTO.getPassword()));

        userAuthRepository.save(userAuth);

        return new LoginDTO(userAuth);
    }
}
