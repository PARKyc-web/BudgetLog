package io.github.parkyc.budgetlog.user.service;

import io.github.parkyc.budgetlog.user.dto.SignUpRequestDTO;
import io.github.parkyc.budgetlog.user.dto.SignUpResponseDTO;
import io.github.parkyc.budgetlog.user.entity.UserAuth;
import io.github.parkyc.budgetlog.user.repository.UserAuthRepository;
import io.github.parkyc.budgetlog.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final UserAuthRepository authRepository;

    @Override
    public boolean isAvailableId(SignUpRequestDTO signUpRequestDTO) {
        return !userRepository.existsByUserId(signUpRequestDTO.getUserId());
    }

    @Override
    public SignUpResponseDTO createAuthCode(SignUpRequestDTO requestDTO) {

        Random rand = new Random();
        rand.setSeed(System.currentTimeMillis());
        String authCode = "";
        for (int i = 0; i < 8; i++) {
            authCode += rand.nextInt();
        }

        UserAuth userAuth = UserAuth.builder()
                .userId(requestDTO.getUserId())
                .code(authCode)
                .expireTime(LocalDateTime.now().plusMinutes(10))
                .build();

        authRepository.saveAndFlush(userAuth);

        SignUpResponseDTO result = SignUpResponseDTO.builder()
                .userId(requestDTO.getUserId())
                .message("success")
                .build();

        return result;
    }
}
