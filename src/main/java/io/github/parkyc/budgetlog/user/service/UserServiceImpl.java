package io.github.parkyc.budgetlog.user.service;

import io.github.parkyc.budgetlog.token.service.JwtService;
import io.github.parkyc.budgetlog.user.dto.GuestUserDTO;
import io.github.parkyc.budgetlog.user.dto.LoginDTO;
import io.github.parkyc.budgetlog.token.dto.JwtDTO;
import io.github.parkyc.budgetlog.user.dto.UserBaseDTO;
import io.github.parkyc.budgetlog.user.entity.UserBase;
import io.github.parkyc.budgetlog.user.mapper.UserMapper;
import io.github.parkyc.budgetlog.user.repository.UserAuthRepository;
import io.github.parkyc.budgetlog.user.repository.UserBaseRepository;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SecurityException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    /** Beans **/
    private final UserAuthRepository userAuthRepository;
    private final UserBaseRepository userBaseRepository;

    private final JwtService jwtService;

    private final UserMapper userMapper;


    /** Method **/
    @Override
    public GuestUserDTO createGuest() {

        String guestId = UUID.randomUUID().toString();
        UserBase guest = UserBase.builder()
                .userId(guestId)
                .password(guestId)
                .userName("게스트 계정")
                .userRole("GUEST")
                .build();

        userBaseRepository.saveAndFlush(guest);

        return userMapper.toGuestUserDTO(guest);
    }

    @Override
    public JwtDTO login(LoginDTO loginDTO) {

        UserBase base = userBaseRepository.findByUserId(loginDTO.getUserId());
        if(base == null){
            return null;
        }

        String encPassword = loginDTO.getPassword(); // 여기서 사용자가 입력한 비밀번호의 인코딩을 진행 함.
        if(!encPassword.equals(base.getPassword())){
            return null;
        }

        UserBaseDTO dto = userMapper.toUserBaseDTO(base);

        return jwtService.createToken(dto);
    }
}
