package com.s4r.business.service.user;

import com.s4r.domain.user.UserDTO;

import java.util.List;

public interface UserService {
    List<String> getAllUsers();

    void addUser(UserDTO userDto);

    UserDTO getUserById(Long userId);

    UserDTO getUserByEmail(String email);

    void validateUserCredential(String email, String password);
}
