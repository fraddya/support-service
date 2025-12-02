package com.brs.support.utils.exceptions;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomError {

    private HttpStatus status;
    private Integer errorCode;
    private String message;

    public CustomError(String message, HttpStatus httpStatus) {
        this.status = httpStatus;
        this.message = message;

    }

    public CustomError(String message, Integer code) {
        this.message = message;
        this.errorCode = code;

    }
}
