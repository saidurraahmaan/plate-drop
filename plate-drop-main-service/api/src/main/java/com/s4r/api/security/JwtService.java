package com.s4r.api.security;

import com.s4r.api.model.response.LoginResponse;
import com.s4r.api.model.response.UserResponse;

public interface JwtService {
    boolean isTokenValid(String token);

    LoginResponse generateLoginResponse(UserResponse user);

    UserResponse parseUserFromToken(String token);
}
