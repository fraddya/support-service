package com.brs.support.wrapper;

import com.brs.support.enums.RestApiResponseStatus;

/**
 * @author Nuwan
 */

public class BaseResponseWrapper {

    /*private MessageSource messageSource;

    public void setMessageSource(org.springframework.context.MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    public String readLocaleSpecificMessage(String code)
    {
        return messageSource.getMessage(code, null, Locale.ENGLISH.US);

    }*/

    public static BaseResponseWrapper OK = new BaseResponseWrapper(RestApiResponseStatus.OK);

    public BaseResponseWrapper(){}

    public BaseResponseWrapper(RestApiResponseStatus restApiResponseStatus) {
        this.status = restApiResponseStatus.getStatus();
        this.statusCode = restApiResponseStatus.getCode();
        this.message = restApiResponseStatus.getMessage();
    }

    public String status;

    public Integer statusCode;

    public String message;

    public static BaseResponseWrapper getOK() {
        return OK;
    }

    public static void setOK(BaseResponseWrapper OK) {
        BaseResponseWrapper.OK = OK;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
