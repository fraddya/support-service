package com.brs.support.utils.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.PRECONDITION_FAILED)
public class InsufficientLeaveException extends RuntimeException {

  public InsufficientLeaveException(final String errorMessage, final Throwable errorObject) {
    super(errorMessage, errorObject);
  }

  public InsufficientLeaveException(final String errorMessage) {
    super(errorMessage);
  }
}