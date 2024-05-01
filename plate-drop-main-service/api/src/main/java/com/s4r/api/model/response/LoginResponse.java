package com.s4r.api.model.response;

import com.s4r.domain.user.UserInfo;

public class LoginResponse {
    private UserInfo user;
    private String token;

    public LoginResponse(UserInfo user, String token) {
        this.user = user;
        this.token = token;
    }

    public UserInfo getUser() {
        return user;
    }

    public void setUser(UserInfo user) {
        this.user = user;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
