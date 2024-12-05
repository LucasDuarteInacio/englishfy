package com.englishfy.api.exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serial;
import java.io.Serializable;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Issue implements Serializable {

  @Serial private static final long serialVersionUID = 1L;

  @JsonProperty private String code;

  @JsonProperty private String message;

  public Issue(final IssueTypeEnum issue) {
    code = String.valueOf(issue.getCode());
    message = issue.getFormattedMessage();
  }
}
