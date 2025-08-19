package io.github.parkyc.budgetlog.user.service;

import io.github.parkyc.budgetlog.user.dto.GuestUserDTO;
import io.github.parkyc.budgetlog.user.dto.LoginDTO;
import io.github.parkyc.budgetlog.user.dto.TokenDTO;
import io.github.parkyc.budgetlog.user.entity.UserBase;
import io.github.parkyc.budgetlog.user.mapper.UserMapper;
import io.github.parkyc.budgetlog.user.repository.UserAuthRepository;
import io.github.parkyc.budgetlog.user.repository.UserBaseRepository;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    /** Beans **/
    private final UserAuthRepository userAuthRepository;
    private final UserBaseRepository userBaseRepository;

    private final UserMapper userMapper;

    /** Variable **/
    private String key = "budget-log-secret-key-2025-05-27";
    private final SecretKey secretKey = Keys.hmacShaKeyFor(key.getBytes());
    private final Long expireRefresh = 36000000L;
    private final Long expireAccess = 18000L;
    private final String issuer = "budgetlog";


    /** Method **/
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
    public TokenDTO login(LoginDTO loginDTO) {

        UserBase base = userBaseRepository.findByUserId(loginDTO.getUserId());
        if(base == null){
            return null;
        }

        String encPassword = loginDTO.getPassword(); // 여기서 사용자가 입력한 비밀번호의 인코딩을 진행 함.
        if(!encPassword.equals(base.getPassword())){
            return null;
        }

        Date now = new Date();

        String access = Jwts.builder()
                .subject(loginDTO.getUserId())
                .issuer(issuer)
                .issuedAt(now)
                .expiration(new Date(now.getTime() + expireAccess))
                .signWith(secretKey)
                .compact();

        String refresh = Jwts.builder()
                .subject(loginDTO.getUserId())
                .issuer(issuer)
                .issuedAt(now)
                .expiration(new Date(now.getTime() + expireRefresh))
                .signWith(secretKey)
                .compact();

        return TokenDTO.builder()
                .accessToken(access)
                .refreshToken(refresh)
                .build();
    }

    @Override
    public TokenDTO renewAccess(TokenDTO tokenDTO) {
        return null;
    }
}
