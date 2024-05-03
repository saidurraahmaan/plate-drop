package com.s4r.business.service.user;

import com.s4r.business.service.exception.ErrorCode;
import com.s4r.business.service.exception.ServiceException;
import com.s4r.business.service.utils.ServiceUtils;
import com.s4r.domain.user.UserDTO;
import com.s4r.persistence.user.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);
    private final UserRepository userRepo;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepo, PasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    public List<String> getAllUsers() {
        var result = new ArrayList<String>();
        result.add("Saidur");
        return result;
    }

    @Override
    public void addUser(UserDTO userDto) {
        userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));
        userRepo.save(UserDTO.toEntity(userDto));
    }

    @Override
    public UserDTO getUserById(Long userId) {
        var user = userRepo.findById(userId);
        return user.map(UserDTO::ofEntity)
                .orElse(null);
    }

    @Override
    public UserDTO getUserByEmail(String email) {
        var authUser = ServiceUtils.getAuthenticatedUser();
        log.trace("authUser:{}", authUser);
        
        var user = userRepo.findByEmail(email);
        if (user == null) {
            throw new ServiceException(ErrorCode.USER_NOT_FOUND);
        }
        return UserDTO.ofEntity(user);
    }

    @Override
    public void validateUserCredential(String email, String password) {
        var user = getUserByEmail(email);
        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new ServiceException(ErrorCode.BAD_CREDENTIALS);
        }
    }
}
