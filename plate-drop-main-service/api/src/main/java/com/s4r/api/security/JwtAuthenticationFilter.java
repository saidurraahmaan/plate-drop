package com.s4r.api.security;


import com.s4r.domain.user.UserInfo;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.lang.NonNull;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Arrays;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {
    private static final String AUTHORIZATION_HEADER_NAME = "Authorization";
    private static final String AUTHORIZATION_HEADER_VALUE_PREFIX = "Bearer ";
    private static final String JWT_COOKIE_NAME = "JWT_TOKEN";
    private static final Logger logger = LoggerFactory.getLogger(JwtServiceImpl.class);

    private final JwtService jwtService;

    public JwtAuthenticationFilter(JwtService jwtService) {
        this.jwtService = jwtService;
    }


    @Override
    protected void doFilterInternal(@NonNull HttpServletRequest request, @NonNull HttpServletResponse response,
                                    @NonNull FilterChain filterChain) throws ServletException, IOException {
        final String authHeader = request.getHeader(AUTHORIZATION_HEADER_NAME);

        try {
            final String jwt = parseJwt(request);
            if (jwt != null && jwtService.isTokenValid(jwt)) {
                UserInfo user = jwtService.parseUserFromToken(jwt);
                var authentication = new AppAuthenticator(user, true);
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }

        } catch (Exception exception) {
//            handlerExceptionResolver.resolveException(request, response, null, exception);
            logger.error("Cannot set user authentication: {}", exception.getMessage());
        }
        filterChain.doFilter(request, response);
    }

    //    private String parseJwt(HttpServletRequest request) {
//        String headerAuth = request.getHeader(AUTHORIZATION_HEADER_NAME);
//
//        if (StringUtils.hasText(headerAuth) && headerAuth.startsWith(AUTHORIZATION_HEADER_VALUE_PREFIX)) {
//            return headerAuth.substring(7);
//        }
//
//        return null;
//    }
    private String parseJwt(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            return Arrays.stream(cookies)
                    .filter(cookie -> JWT_COOKIE_NAME.equals(cookie.getName()))
                    .map(Cookie::getValue)
                    .findAny()
                    .orElse(null);
        }
        return null;
    }
}