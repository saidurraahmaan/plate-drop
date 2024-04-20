package com.s4r.api.model.response;

public class LoginResponse {
    private UserResponse user;
    private String token;

    public LoginResponse(UserResponse user, String token) {
        this.user = user;
        this.token = token;
    }

    public UserResponse getUser() {
        return user;
    }

    public void setUser(UserResponse user) {
        this.user = user;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
