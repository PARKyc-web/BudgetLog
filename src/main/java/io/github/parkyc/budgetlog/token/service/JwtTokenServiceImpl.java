package io.github.parkyc.budgetlog.token.service;

import io.github.parkyc.budgetlog.token.dto.JwtTokenDTO;
import io.jsonwebtoken.Claims;
import org.springframework.stereotype.Service;

@Service
public class JwtTokenServiceImpl implements JwtTokenService {

    @Override
    public boolean isValid(JwtTokenDTO token) {
        return false;
    }

    @Override
    public Claims verifyToken(String token) {
        return null;
    }

    @Override
    public JwtTokenDTO renewJwtToken(String token) {
        return null;
    }
}
