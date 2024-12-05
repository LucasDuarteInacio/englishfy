package com.englishfy.api.exception;

public class UnexpectedException extends ApiException {

  public UnexpectedException(final Issue issue) {
    super(issue);
  }

  public static UnexpectedException unexpectedError() {
    return new UnexpectedException(new Issue(IssueTypeEnum.UNEXPECTED_ERROR));
  }
}
