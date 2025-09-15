package io.github.parkyc.budgetlog.token.service;

import io.github.parkyc.budgetlog.token.dto.JwtDTO;
import io.github.parkyc.budgetlog.token.dto.JwtStatus;
import io.github.parkyc.budgetlog.user.dto.LoginDTO;
import io.github.parkyc.budgetlog.user.dto.UserBaseDTO;
import io.jsonwebtoken.Claims;

public interface JwtService {


    /**
     * Login 시, 토큰 생성 메서드
     * @param userBaseDTO
     * @return
     */
    JwtDTO createToken(UserBaseDTO userBaseDTO);

    /**
     * Token의 유효성 여부를 true, false 리턴
     * @param token
     * @return
     */
    JwtStatus isValid(String token);

    /**
     * Token의 payload 데이터를 return
     * @param token
     * @return
     */
    Claims verifyToken(String token);

}
