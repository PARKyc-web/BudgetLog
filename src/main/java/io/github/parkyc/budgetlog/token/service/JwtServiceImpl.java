package io.github.parkyc.budgetlog.token.service;

import io.github.parkyc.budgetlog.config.properties.JwtProperties;
import io.github.parkyc.budgetlog.token.dto.JwtDTO;
import io.github.parkyc.budgetlog.token.dto.JwtStatus;
import io.github.parkyc.budgetlog.user.dto.UserBaseDTO;
import io.github.parkyc.budgetlog.user.service.UserService;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.SecurityException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class JwtServiceImpl implements JwtService {

    /* Properties Beans */
    private final JwtProperties jwtProperties;

    /* Beans */
    // private final UserService userService;


    @Override
    public JwtDTO createToken(UserBaseDTO userBaseDTO) {

        Date now = new Date();

        String access = Jwts.builder()
                .subject("accessToken")
                .issuer(jwtProperties.getIssuer())
                .issuedAt(now)
                .claim("userId", userBaseDTO.getUserId())
                .claim("role", userBaseDTO.getRole())
                .expiration(new Date(now.getTime() + jwtProperties.getExpire().getAccess().toMillis()))
                .signWith(jwtProperties.getSecretKey())
                .compact();

        String refresh = Jwts.builder()
                .subject("refreshToken")
                .issuer(jwtProperties.getIssuer())
                .issuedAt(now)
                .claim("userId", userBaseDTO.getUserId())
                .claim("role", userBaseDTO.getRole())
                .expiration(new Date(now.getTime() + jwtProperties.getExpire().getRefresh().toMillis()))
                .signWith(jwtProperties.getSecretKey())
                .compact();

        return JwtDTO.builder()
                .accessToken(access)
                .refreshToken(refresh)
                .build();
    }

    @Override
    public JwtStatus isValid(String token) {

        JwtStatus result = null;
        try {
            Jwts.parser()
                    .verifyWith(jwtProperties.getSecretKey())
                    .build()
                    .parseSignedClaims(token);

            result = JwtStatus.VALID;
        } catch (SecurityException | MalformedJwtException e){
            System.out.println("Invalid token");
            result = JwtStatus.INVALID;
        } catch (ExpiredJwtException e){
            System.out.println("Expired token");
            result = JwtStatus.EXPIRED;
        } catch (UnsupportedJwtException e){
            System.out.println("Unsupported token");
            result = JwtStatus.INVALID;
        } catch (IllegalArgumentException e){
            System.out.println("Invalid Argument token");
            result = JwtStatus.INVALID;
        } catch (Exception e){
            System.out.println("Unknown Exception");
            result = JwtStatus.INVALID;
        }

        return result;
    }

    @Override
    public Claims verifyToken(String token) {

        Claims claims = null;
        try{
            claims = Jwts.parser()
                    .verifyWith(jwtProperties.getSecretKey())
                    .build()
                    .parseSignedClaims(token)
                    .getPayload();

        } catch (SecurityException | MalformedJwtException e){
            System.out.println("Invalid token");
        } catch (ExpiredJwtException e){
            System.out.println("Expired token");
        } catch (UnsupportedJwtException e){
            System.out.println("Unsupported token");
        } catch (IllegalArgumentException e){
            System.out.println("Invalid Argument token");
        } catch (Exception e){
            System.out.println("Unknown Exception");
        }

        return claims;
    }

}
