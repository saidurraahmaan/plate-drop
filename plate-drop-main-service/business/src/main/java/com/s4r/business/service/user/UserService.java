package com.s4r.business.service.user;

import com.s4r.domain.user.UserDTO;

import java.util.List;

public interface UserService {
    List<String> getAllUsers();

    void addUser(UserDTO userDto);
}
