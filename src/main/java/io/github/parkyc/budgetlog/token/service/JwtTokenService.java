package io.github.parkyc.budgetlog.token.service;

import io.github.parkyc.budgetlog.token.dto.JwtTokenDTO;
import io.jsonwebtoken.Claims;

public interface JwtTokenService {

    /**
     * Token의 유효성 여부를 true, false 리턴
     * @param token
     * @return
     */
    boolean isValid(JwtTokenDTO token);

    /**
     * Token의 payload 데이터를 return
     * @param token
     * @return
     */
    Claims verifyToken(String token);

    /**
     * JWT Token 재발급 받기 위한 메서드
     * @param token
     * @return
     */
    JwtTokenDTO renewJwtToken(String token);

}
