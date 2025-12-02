package com.brs.support.utils.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.SERVICE_UNAVAILABLE)
public class EmployeeServiceNotAvailableException extends ServiceException {

  public EmployeeServiceNotAvailableException(final String errorMessage, final Throwable errorObject) {
    super(errorMessage, errorObject);
  }

  public EmployeeServiceNotAvailableException(final String errorMessage) {
    super(errorMessage);
  }
}