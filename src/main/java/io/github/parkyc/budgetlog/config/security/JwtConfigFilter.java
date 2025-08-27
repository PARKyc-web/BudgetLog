package io.github.parkyc.budgetlog.config.security;

import io.github.parkyc.budgetlog.token.dto.JwtStatus;
import io.github.parkyc.budgetlog.token.service.JwtService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@RequiredArgsConstructor
public class JwtConfigFilter extends OncePerRequestFilter {

    private final JwtService jwtService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        // token 정보 가져옴
        String header = request.getHeader("Authorization");

        if (header == null || !header.startsWith("Bearer ")){
            String token = header.substring(7);

            JwtStatus isValid = jwtService.isValid(token);
            // 이걸 값을 int로 받고 code를 몇개 정해두고 사용하는거지;
            // 200, 404, 401 등등

            // 인증에 실패할 경우 백 시킴....
            // 근데 인증 실패할때 401을 어떻게 띄우지??

            // UserDetails
        }

        filterChain.doFilter(request, response);
    }
}
