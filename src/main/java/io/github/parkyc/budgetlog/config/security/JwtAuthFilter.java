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
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Arrays;

@Component
@RequiredArgsConstructor
public class JwtAuthFilter extends OncePerRequestFilter {

    private final JwtService jwtService;
    private final UserDetailsService userDetailsService;

    private static final String[] ALLOWED_PATH = {
            "/api/user/**",
            "/api/token/**",
            "/favicon.ico",
            "/swagger-ui/**",
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

        try {
            // header 정보 가져옴
            String header = request.getHeader("Authorization");

            // JWT token 유무 확인
            if (header != null || header.startsWith("Bearer ")){
                String token = header.substring(7);

                JwtStatus isValid = jwtService.isValid(token);
                if(isValid == JwtStatus.VALID){
                    Claims clm = jwtService.verifyToken(token);
                    String userId = clm.get("userId", String.class);

                    UserDetails userDetails = userDetailsService.loadUserByUsername(userId);
                    UsernamePasswordAuthenticationToken authToken =
                            new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());

                    SecurityContextHolder.getContext().setAuthentication(authToken);
                }
            }

        } catch (ExpiredJwtException e){

        } catch (JwtException e){

        } catch (Exception e){

        }

        filterChain.doFilter(request, response);
    }
}
