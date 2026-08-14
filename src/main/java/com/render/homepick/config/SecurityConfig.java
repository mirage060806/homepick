package com.render.homepick.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig{

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/", "/login", "/register").permitAll() // 메인, 로그인, 회원가입 등은 누구나 접근 가능
                .anyRequest().authenticated() // 그 외의 모든 요청은 인증 필요
            )
            .formLogin(login -> login
                .loginPage("/login") // 로그인 페이지 경로 (추후 구현 시 사용)
                .permitAll()
            )
            .csrf(csrf -> csrf.disable()); // 개발 단계에서 편리하도록 CSRF 비활성화

        return http.build();
    }
}