package com.s4r.business.service.exception;

public enum ErrorCode {
    //User
    USER_NOT_FOUND(101),


    //Auth
    INVALID_TOKEN(201),
    BAD_CREDENTIALS(202),


    //Common Error,
    NOT_FOUND(99998),
    INTERNAL_SERVER_ERROR(9999);

    public final int value;

    ErrorCode(int code) {
        this.value = code;
    }
}
