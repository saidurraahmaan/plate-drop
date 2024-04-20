package com.s4r.api.utils;

import com.s4r.api.model.response.ErrorResponse;
import com.s4r.business.service.exception.ServiceException;
import org.springframework.stereotype.Component;

@Component
public class CommonUtils {
//    private final MessageSource messageSource;
//
//    public CommonUtils(MessageSource messageSource) {
//        this.messageSource = messageSource;
//    }

    public ErrorResponse getErrorResponse(ServiceException exception) {
        var code = exception.getErrorCode();
        String key = "error." + code;
//        var message = messageSource.getMessage(key, null, LocaleContextHolder.getLocale());
        return new ErrorResponse(code.value, code.toString());
    }
}
