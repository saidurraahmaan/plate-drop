package com.s4r.service.user;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public List<String> getAllUsers() {
        var result = new ArrayList<String>();
        result.add("Saidur");
        return result;
    }
}
