package io.github.parkyc.budgetlog.config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                // CSRF 보호 비활성화
                .csrf(csrf -> csrf.disable())

                // 세션 관리 정책을 STATELESS로 설정 (토큰 기반 인증)
                // .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))

                // HTTP 기본 인증 및 폼 로그인 비활성화
                .httpBasic(httpBasic -> httpBasic.disable())
                .formLogin(formLogin -> formLogin.disable())

                // 요청별 권한 설정
                .authorizeHttpRequests(auth -> auth
                        // 특정 경로 (예: 로그인, 회원가입)는 모두에게 허용
                        .requestMatchers("/api/user/temp", "/api/user/login").permitAll()
                        // 나머지 모든 요청은 인증된 사용자만 접근 가능
                        .anyRequest().authenticated()
                );

        return http.build();
    }
}
