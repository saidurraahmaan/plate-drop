package com.s4r.business.service.user;

import com.s4r.domain.user.UserDTO;
import com.s4r.persistence.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepo;

    @Autowired
    public UserServiceImpl(UserRepository userRepo) {
        this.userRepo = userRepo;
    }


    @Override
    public List<String> getAllUsers() {
        var result = new ArrayList<String>();
        result.add("Saidur");
        return result;
    }

    @Override
    public void addUser() {
        var userDto = new UserDTO();
        userDto.setEmail("saidur@gmail.com");

    }

}
