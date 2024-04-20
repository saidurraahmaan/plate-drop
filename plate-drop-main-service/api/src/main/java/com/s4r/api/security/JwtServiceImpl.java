package com.s4r.api.security;


import com.s4r.api.model.response.LoginResponse;
import com.s4r.api.model.response.UserResponse;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;

@Component
public class JwtServiceImpl implements JwtService {

    @Value("${security.jwt.expiration-time}")
    private int tokenExpirationTimeMs;
    @Value("${security.jwt.secret-key}")
    private String jwtSecret;

    @Override
    public boolean isTokenValid(String token) {
        return false;
    }

    @Override
    public LoginResponse generateLoginResponse(UserResponse user) {
        var token = Jwts.builder()
                .subject(user.getId().toString())
                .issuedAt(new Date())
                .expiration(new Date(new Date().getTime() + tokenExpirationTimeMs))
                .signWith(getSigningKey())
                .compact();
        return new LoginResponse(user, token);
    }


    private SecretKey getSigningKey() {
        byte[] keyBytes = Decoders.BASE64.decode(jwtSecret);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    @Override
    public UserResponse parseUserFromToken(String token) {
        return null;
    }
}
