package com.englishfy.api.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ApiException extends RuntimeException {

  private final Issue issue;

  private final HttpStatus httpStatus;

  public ApiException(final Issue issue) {
    this.issue = issue;
    this.httpStatus = null;
  }

  public ApiException(final Issue issue, final HttpStatus httpStatus) {
    this.issue = issue;
    this.httpStatus = httpStatus;
  }
}
