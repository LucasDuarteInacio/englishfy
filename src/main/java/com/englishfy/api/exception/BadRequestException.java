package com.englishfy.api.exception;

public class BadRequestException extends ApiException {

  public BadRequestException(final Issue issue) {
    super(issue);
  }
}
