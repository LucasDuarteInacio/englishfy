package com.englishfy.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

@RestController
@ControllerAdvice
public class ApiExceptionHandler {

  @ExceptionHandler(UnexpectedException.class)
  @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
  protected StandardError unexpectedException(final ApiException ex, final WebRequest request) {
    return buildStandardError(ex, request);
  }

  @ExceptionHandler(NotFoundException.class)
  @ResponseStatus(value = HttpStatus.BAD_REQUEST)
  protected StandardError entityNotFoundException(final ApiException ex, final WebRequest request) {
    return buildStandardError(ex, request);
  }

  @ExceptionHandler(BadRequestException.class)
  @ResponseStatus(value = HttpStatus.BAD_REQUEST)
  protected StandardError badRequestException(final ApiException ex, final WebRequest request) {
    return buildStandardError(ex, request);
  }

  @ExceptionHandler(GenericException.class)
  protected ResponseEntity<StandardError> genericException(
      final ApiException ex, final WebRequest request) {
    return ResponseEntity.status(ex.getHttpStatus().value()).body(buildStandardError(ex, request));
  }

  @ExceptionHandler(DataExistsException.class)
  @ResponseStatus(value = HttpStatus.BAD_REQUEST)
  protected StandardError entityExistsException(final ApiException ex, final WebRequest request) {
    return buildStandardError(ex, request);
  }

  private StandardError buildStandardError(final ApiException ex, final WebRequest request) {
    return StandardError.builder()
        .code(ex.getIssue().getCode())
        .message(ex.getIssue().getMessage())
        .timesTamp(System.currentTimeMillis())
        .path(request.getDescription(true))
        .build();
  }
}
