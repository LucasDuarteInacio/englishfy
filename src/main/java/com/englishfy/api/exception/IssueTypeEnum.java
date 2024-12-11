package com.englishfy.api.exception;

import java.util.IllegalFormatException;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum IssueTypeEnum {

  //    Share 0 to 10
  UNEXPECTED_ERROR("0", "An unexpected error has occurred"),
  SERVICE_UNAVAILABLE("1", "Sorry, our service is unavailable/unstable at the moment."),
  SERVICE_NOT_FOUND("2", "Service not found"),

  //    User 11 to 30
  USER_NOT_FOUND("11", "User not found"),
  USER_EXISTS("12", "There is already a user registered with this phone number or email"),
  INVALID_CURRENT_PASSWORD("13", "The current password does not match the stored password"),

  // 31 TO 40
  GROUP_NOT_FOUND("31", "Group not found"),
  GROUP_EXISTS("32", "There is already a group registered with this name"),

  // 41 TO 50
  SCOPE_NOT_FOUND("41", "Scope not found"),
  SCOPE_EXISTS("42", "There is already a scope registered with this name"),

  // 51 TO 60
  COURSE_NOT_FOUND("51", "Course not found"),
  COURSE_EXISTS("52", "There is already a course registered with this name");

  private final String code;
  private final String message;

  public String getFormattedMessage(final Object... args) {

    if (message == null) {
      return "";
    }

    try {
      return String.format(message, args);
    } catch (final IllegalFormatException e) {
      return message.replace("%s", "");
    }
  }
}
