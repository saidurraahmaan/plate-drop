package com.s4r.business.service.exception;

public class ServiceException extends RuntimeException {
    private final ErrorCode errorCode;

    public ServiceException(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }
}
