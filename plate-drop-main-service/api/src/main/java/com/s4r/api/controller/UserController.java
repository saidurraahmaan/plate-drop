package com.s4r.api.controller;

import com.s4r.api.model.request.UserAddRequest;
import com.s4r.business.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/get-all")
    public List<String> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping("/register")
    public void registerNewUser(@RequestBody UserAddRequest request) {
        userService.addUser(UserAddRequest.toDto(request));
    }

    @GetMapping("/by-id/{userId}")
    public void getUserById(@PathVariable Long userId) {

    }
}
