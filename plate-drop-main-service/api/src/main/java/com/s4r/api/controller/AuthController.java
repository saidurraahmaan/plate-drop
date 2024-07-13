package com.s4r.api.controller;

import com.s4r.api.model.request.LoginRequest;
import com.s4r.api.model.request.UserAddRequest;
import com.s4r.api.security.JwtService;
import com.s4r.business.service.user.UserService;
import com.s4r.domain.user.UserInfo;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/auth")
@RestController
public class AuthController {

    private final UserService userService;
    private final JwtService jwtService;
    @Value("${security.jwt.expiration-time}")
    private int tokenExpirationTimeMs;

    public AuthController(UserService userService, JwtService jwtService) {
        this.userService = userService;
        this.jwtService = jwtService;
    }


    @PostMapping("/signup")
    public void register(@RequestBody UserAddRequest request) {
        userService.addUser(UserAddRequest.toDto(request));
    }

    @PostMapping("/signin")
    public UserInfo authenticate(@RequestBody LoginRequest request, HttpServletResponse response) {
        userService.validateUserCredential(request.getEmail(), request.getPassword());
        var user = userService.getUserByEmail(request.getEmail());
        var res = jwtService.generateLoginResponse(UserInfo.ofDTO(user));
        setJwtCookie(response, res.getToken());
        return res.getUser();
    }

    private void setJwtCookie(HttpServletResponse response, String jwtToken) {
        Cookie cookie = new Cookie("JWT_TOKEN", jwtToken);
        cookie.setHttpOnly(true);
        cookie.setSecure(true); // Set to true in production
        cookie.setPath("/");
        cookie.setMaxAge((int) tokenExpirationTimeMs / 1000);
        response.addCookie(cookie);
    }

}



