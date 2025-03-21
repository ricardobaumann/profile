package com.github.ricbau.profile.config;

import com.github.ricbau.profile.repos.LoginRepo;
import com.github.ricbau.profile.repos.UserInfo;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Collections;
import java.util.Optional;

/** @noinspection NullableProblems*/
@Component
@AllArgsConstructor
public class AuthFilter extends OncePerRequestFilter {
    private final LoginRepo loginRepo;

    @Override
    protected void doFilterInternal(final HttpServletRequest request, final HttpServletResponse response, final FilterChain filterChain) throws ServletException, IOException {
        Optional.ofNullable(request.getHeader("Authorization"))
                .filter(authorization -> authorization.startsWith("Bearer "))
                .map(bearer -> bearer.substring(7))
                .map(loginRepo::getByToken)
                .map(UserInfo::username)
                .map(JwtUserDetails::new)
                .map(jwtUserDetails -> new UsernamePasswordAuthenticationToken(jwtUserDetails, null, Collections.emptyList()))
                .ifPresent(
                        authentication -> SecurityContextHolder.getContext().setAuthentication(authentication));
        filterChain.doFilter(request, response);
    }
}
