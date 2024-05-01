package com.s4r.api.security;

import com.s4r.api.model.response.LoginResponse;
import com.s4r.domain.user.UserInfo;

public interface JwtService {
    boolean isTokenValid(String token);

    LoginResponse generateLoginResponse(UserInfo user);

    UserInfo parseUserFromToken(String token);

}
