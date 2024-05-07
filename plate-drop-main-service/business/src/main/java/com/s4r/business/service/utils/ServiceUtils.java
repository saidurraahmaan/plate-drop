package com.s4r.business.service.utils;

import com.s4r.business.service.exception.ErrorCode;
import com.s4r.business.service.exception.ServiceException;
import com.s4r.domain.user.UserInfo;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class ServiceUtils {


    public static UserInfo getAuthenticatedUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication != null && authentication.getPrincipal() instanceof UserInfo) {
            return (UserInfo) authentication.getPrincipal();
        } else {
            throw new ServiceException(ErrorCode.USER_NOT_FOUND);
        }
    }
}
