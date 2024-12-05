package com.englishfy.api.exception;

import org.springframework.http.HttpStatus;

public class GenericException extends ApiException {

  public GenericException(final Issue issue, HttpStatus httpStatus) {
    super(issue, httpStatus);
  }
}
