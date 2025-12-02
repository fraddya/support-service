package com.brs.support.wrapper;

import com.brs.support.enums.RestApiResponseStatus;

public class ExceptionResponseWrapper extends BaseResponseWrapper {
    public ExceptionResponseWrapper(String message, RestApiResponseStatus restApiResponseStatus) {
        super(restApiResponseStatus);
        this.message=message;
    }
}
