package com.s4r.api.controller;

import com.s4r.api.model.response.ErrorResponse;
import com.s4r.api.utils.CommonUtils;
import com.s4r.business.service.exception.ErrorCode;
import com.s4r.business.service.exception.ServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalRestControllerAdvice {
    private static final Logger logger = LoggerFactory.getLogger(GlobalRestControllerAdvice.class);
    private final CommonUtils utils;

    public GlobalRestControllerAdvice(CommonUtils commonUtils) {
        this.utils = commonUtils;
    }

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleServiceException(ServiceException exception) {
        logger.error("Service EXCEPTION {}", exception.getErrorCode());
        return new ResponseEntity<>(utils.getErrorResponse(exception), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleAllOtherException(Exception exception) {
        logger.error("GENERIC EXCEPTION {}", exception.getMessage());
        var genericException = new ServiceException(ErrorCode.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<>(utils.getErrorResponse(genericException), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
