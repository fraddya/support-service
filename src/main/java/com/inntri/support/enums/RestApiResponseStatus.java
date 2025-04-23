package com.inntri.support.enums;

public enum RestApiResponseStatus {

    OK("OK", 200), VALIDATION_FAILURE("CLIENT_ERROR", 400),  SUBSCRIPTION_ERROR("SUBSCRIPTION_ERROR", 402),
    ERROR("SYSTEM_ERROR", 500),NOT_FOUND("CLIENT_ERROR", 404),AUTHENTICATION_ERROR("CLIENT_ERROR", 403);

    private String status;

    private Integer code;

    private String message;

    RestApiResponseStatus(String status, Integer code) {
        this.status = status;
        this.code = code;
    }

    RestApiResponseStatus(String status, Integer code, String message) {
        this.status = status;
        this.code = code;
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return status + ":" + code;
    }
}
