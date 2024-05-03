package com.s4r.business.service.utils;

import com.s4r.domain.user.UserInfo;
import org.springframework.security.core.context.SecurityContextHolder;

public class ServiceUtils {


    public static UserInfo getAuthenticatedUser() {
        UserInfo user = (UserInfo) SecurityContextHolder
                .getContext()
                .getAuthentication().getPrincipal();
        return user;
    }
}
