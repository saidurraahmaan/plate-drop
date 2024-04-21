package com.s4r.api.controller;

import com.s4r.api.model.request.LoginRequest;
import com.s4r.api.model.request.UserAddRequest;
import com.s4r.api.model.response.LoginResponse;
import com.s4r.api.model.response.UserResponse;
import com.s4r.api.security.JwtService;
import com.s4r.business.service.user.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/auth")
@RestController
public class AuthController {

    private final UserService userService;
    private final JwtService jwtService;

    public AuthController(UserService userService, JwtService jwtService) {
        this.userService = userService;
        this.jwtService = jwtService;
    }


    @PostMapping("/signup")
    public void register(@RequestBody UserAddRequest request) {
        userService.addUser(UserAddRequest.toDto(request));
    }

    @PostMapping("/signin")
    public LoginResponse authenticate(@RequestBody LoginRequest request) {

        var user = userService.getUserByEmail(request.getEmail());
        return jwtService.generateLoginResponse(UserResponse.ofDTO(user));
    }
}