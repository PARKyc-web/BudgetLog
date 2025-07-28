package io.github.parkyc.budgetlog.user.service;

import io.github.parkyc.budgetlog.user.dto.SignUpDTO;
import io.github.parkyc.budgetlog.user.dto.UserDTO;
import io.github.parkyc.budgetlog.user.entity.UserAuth;
import io.github.parkyc.budgetlog.user.entity.UserInfo;
import io.github.parkyc.budgetlog.user.repository.UserAuthRepository;
import io.github.parkyc.budgetlog.user.repository.UserRepositry;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepositry userRepositry;

    private final UserAuthRepository authRepository;

    @Override
    public SignUpDTO createAuthCode(SignUpDTO signupDTO) {

        Random rand = new Random();
        rand.setSeed(System.currentTimeMillis());
        String authCode = "";
        for(int i=0; i<8; i++){
            authCode += rand.nextInt();
        }

        UserAuth userAuth = UserAuth.builder()
                .userId(signupDTO.getUserId())
                .code(authCode)
                .expireTime(LocalDateTime.now().plusMinutes(10))
                .build();

        authRepository.saveAndFlush(userAuth);

        return signupDTO;
    }
}
