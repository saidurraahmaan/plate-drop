package com.s4r.api.controller;

import com.s4r.api.model.response.ErrorResponse;
import com.s4r.api.utils.CommonUtils;
import com.s4r.business.service.exception.ErrorCode;
import com.s4r.business.service.exception.ServiceException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GlobalRestControllerAdvice {
    private final CommonUtils utils;

    public GlobalRestControllerAdvice(CommonUtils commonUtils) {
        this.utils = commonUtils;
    }

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleServiceException(ServiceException exception) {
        log.error("Service EXCEPTION {}", exception.getErrorCode());
        return new ResponseEntity<>(utils.getErrorResponse(exception), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleAllOtherException(Exception exception) {
        log.error("GENERIC EXCEPTION {}", exception.getMessage());
        var genericException = new ServiceException(ErrorCode.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<>(utils.getErrorResponse(genericException), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
