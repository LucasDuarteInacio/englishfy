package com.englishfy.api.dto;

import com.englishfy.api.enums.UserTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserRequestDTO {

  private String name;

  private String phoneNumber;

  private String email;

  private String password;

  private UserTypeEnum userType;
}
