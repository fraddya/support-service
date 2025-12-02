package com.brs.support.utils.exceptions;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

/**
 * @author Nuwan
 */
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class ValidationFailure {

    private String code;
    private String message;

    public ValidationFailure( String code,String message) {
        this.code = code;
        this.message = message;
    }


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
