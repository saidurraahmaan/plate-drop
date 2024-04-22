package com.s4r.api.security;


import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {
    private static final String AUTHORIZATION_HEADER_NAME = "Authorization";
    private static final String AUTHORIZATION_HEADER_VALUE_PREFIX = "Bearer ";

    private final JwtService jwtService;

    public JwtAuthenticationFilter(JwtService jwtService) {
        this.jwtService = jwtService;
    }


//    private final HandlerExceptionResolver handlerExceptionResolver;


//    public JwtAuthenticationFilter(HandlerExceptionResolver handlerExceptionResolver) {
//
//        this.handlerExceptionResolver = handlerExceptionResolver;
//    }

    @Override
    protected void doFilterInternal(@NonNull HttpServletRequest request, @NonNull HttpServletResponse response,
                                    @NonNull FilterChain filterChain) throws ServletException, IOException {
        final String authHeader = request.getHeader(AUTHORIZATION_HEADER_NAME);

        if (authHeader == null || !authHeader.startsWith(AUTHORIZATION_HEADER_VALUE_PREFIX)) {
            filterChain.doFilter(request, response);
            return;
        }

        try {
//            final String jwt = authHeader.substring(7);
//            final String userEmail = jwtService.extractUsername(jwt);
//
//            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//
//            if (userEmail != null && authentication == null) {
//                UserDetails userDetails = this.userDetailsService.loadUserByUsername(userEmail);
//
//                if (jwtService.isTokenValid(jwt, userDetails)) {
//                    UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
//
//                    authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
//                    SecurityContextHolder.getContext().setAuthentication(authToken);
//                }
//            }

            filterChain.doFilter(request, response);
        } catch (Exception exception) {
//            handlerExceptionResolver.resolveException(request, response, null, exception);
        }
    }
}