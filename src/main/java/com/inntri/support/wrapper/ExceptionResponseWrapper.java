package com.inntri.support.wrapper;

import com.inntri.support.enums.RestApiResponseStatus;
import org.springframework.http.HttpStatus;

public class ExceptionResponseWrapper extends BaseResponseWrapper {
    public ExceptionResponseWrapper(String message, RestApiResponseStatus restApiResponseStatus) {
        super(restApiResponseStatus);
        this.message=message;
    }
}
