package io.github.parkyc.budgetlog.config.security;

import io.github.parkyc.budgetlog.token.dto.JwtStatus;
import io.github.parkyc.budgetlog.token.service.JwtService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;

@Component
@RequiredArgsConstructor
public class JwtAuthFilter extends OncePerRequestFilter {

    private final JwtService jwtService;

    private static final String[] ALLOWED_PATH = {
            "/api/user/**",
            "/favicon.ico",
            "/swagger-ui/**",
            "/h2-console/**",
    };

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) {
        String url = request.getRequestURI();
        return Arrays.stream(ALLOWED_PATH)
                .anyMatch(pattern -> {
                    AntPathMatcher matcher = new AntPathMatcher();
                    return matcher.match(pattern, url);
                });
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        System.out.println("Jwt filter ON");
        JwtStatus isValid = null;
        try {
            // header 정보 가져옴
            String header = request.getHeader("Authorization");
            System.out.println("Jwt header: " + header);
            // JWT token 유무 확인
            if (header != null && header.startsWith("Bearer ")){
                String token = header.substring(7);

                isValid = jwtService.isValid(token);
                if(isValid == JwtStatus.VALID){
                    Claims clm = jwtService.verifyToken(token);
                    String userId = clm.get("userId", String.class);
                    // String role = clm.get("role", String.class);

                    Authentication authToken =
                            new UsernamePasswordAuthenticationToken(userId, null, Collections.emptyList());

                    SecurityContextHolder.getContext().setAuthentication(authToken);
                }
            }

        } catch (ExpiredJwtException e){
            isValid = JwtStatus.EXPIRED;
        } catch (JwtException e){
            isValid = JwtStatus.INVALID;
        } catch (Exception e){
            isValid = JwtStatus.INVALID;
        }

        filterChain.doFilter(request, response);
    }
}
