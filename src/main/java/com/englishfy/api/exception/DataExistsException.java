package com.englishfy.api.exception;

public class DataExistsException extends ApiException {

  public DataExistsException(final Issue issue) {
    super(issue);
  }

  public static DataExistsException userExistsException() {
    return new DataExistsException(new Issue(IssueTypeEnum.USER_EXISTS));
  }

  public static DataExistsException groupExistsException() {
    return new DataExistsException(new Issue(IssueTypeEnum.GROUP_EXISTS));
  }
}
