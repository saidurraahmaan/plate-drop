package com.s4r.api.security;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.s4r.api.model.response.LoginResponse;
import com.s4r.domain.user.UserInfo;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SignatureException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.SecretKey;
import java.util.Date;

@Component
public class JwtServiceImpl implements JwtService {

    private static final Logger logger = LoggerFactory.getLogger(JwtServiceImpl.class);

    @Value("${security.jwt.expiration-time}")
    private int tokenExpirationTimeMs;
    @Value("${security.jwt.secret-key}")
    private String jwtSecret;
    private static final String userClaim = "user";
    private final ObjectMapper objectMapper;

    public JwtServiceImpl(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }


    @Override
    public boolean isTokenValid(String token) {
        try {
            Jwts.parser()
                    .verifyWith(getSigningKey())
                    .build()
                    .parseSignedClaims(token);
            return true;
        } catch (SignatureException e) {
            logger.error("Invalid JWT signature: {}", e.getMessage());
        } catch (MalformedJwtException e) {
            logger.error("Invalid JWT token: {}", e.getMessage());
        } catch (ExpiredJwtException e) {
            logger.error("JWT token is expired: {}", e.getMessage());
        } catch (UnsupportedJwtException e) {
            logger.error("JWT token is unsupported: {}", e.getMessage());
        } catch (IllegalArgumentException e) {
            logger.error("JWT claims string is empty: {}", e.getMessage());
        }
        return false;
    }

    @Override
    public LoginResponse generateLoginResponse(UserInfo user) {
        try {
            var token = Jwts.builder()
                    .claim(userClaim, objectMapper.writeValueAsString(user))
                    .issuedAt(new Date())
                    .expiration(new Date(new Date().getTime() + tokenExpirationTimeMs))
                    .signWith(getSigningKey())
                    .compact();
            return new LoginResponse(user, token);
        } catch (Exception e) {
            logger.error("Error while generating token for user: {}", user);
        }
        return null;
    }


    private SecretKey getSigningKey() {
        byte[] keyBytes = Decoders.BASE64.decode(jwtSecret);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    @Override
    public UserInfo parseUserFromToken(String token) {
        try {
            var content = Jwts.parser()
                    .verifyWith(getSigningKey())
                    .build()
                    .parseSignedClaims(token)
                    .getPayload();
            return objectMapper.readValue(content.get(userClaim, String.class), UserInfo.class);

        } catch (Exception exception) {
            logger.error("Error while parsing jwt: {}", exception.getMessage());
        }
        return null;

    }
}
