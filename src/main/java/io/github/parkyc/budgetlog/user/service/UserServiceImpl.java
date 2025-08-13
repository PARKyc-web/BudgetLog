package io.github.parkyc.budgetlog.user.service;

import io.github.parkyc.budgetlog.user.dto.EmailVerifyDTO;
import io.github.parkyc.budgetlog.user.dto.GuestUserDTO;
import io.github.parkyc.budgetlog.user.dto.UserSignInDTO;
import io.github.parkyc.budgetlog.user.entity.UserBase;
import io.github.parkyc.budgetlog.user.mapper.UserMapper;
import io.github.parkyc.budgetlog.user.repository.UserAuthRepository;
import io.github.parkyc.budgetlog.user.repository.UserBaseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserAuthRepository userAuthRepository;
    private final UserBaseRepository userBaseRepository;

    private final UserMapper userMapper;

    @Override
    public GuestUserDTO createGuest() {

        String guestId = UUID.randomUUID().toString();
        UserBase guest = UserBase.builder()
                .userId(guestId)
                .password(guestId)
                .userName("게스트 계정")
                .build();

        userBaseRepository.saveAndFlush(guest);

        return userMapper.toGuestUserDTO(guest);
    }

    @Override
    public boolean sendVerifyEmail(UserSignInDTO userSignInDTO) {
        return false;
    }

    @Override
    public boolean verifyEmail(EmailVerifyDTO emailVerifyDTO) {
        return false;
    }
}
