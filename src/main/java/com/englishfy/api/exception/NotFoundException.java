package com.englishfy.api.exception;

public class NotFoundException extends ApiException {

  public NotFoundException(final Issue issue) {
    super(issue);
  }

  public static NotFoundException userNotFoundException() {
    return new NotFoundException(new Issue(IssueTypeEnum.USER_NOT_FOUND));
  }

  public static NotFoundException groupNotFoundException() {
    return new NotFoundException(new Issue(IssueTypeEnum.GROUP_NOT_FOUND));
  }

  public static NotFoundException scopeNotFoundException() {
    return new NotFoundException(new Issue(IssueTypeEnum.SCOPE_NOT_FOUND));
  }
}
