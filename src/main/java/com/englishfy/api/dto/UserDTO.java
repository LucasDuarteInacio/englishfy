package com.englishfy.api.dto;

import com.englishfy.api.enums.UserStatusEnum;
import com.englishfy.api.enums.UserTypeEnum;
import java.util.UUID;
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
public class UserDTO {

  private UUID id;

  private String name;

  private String password;

  private String phoneNumber;

  private String email;

  private UserStatusEnum userStatus;

  private UserTypeEnum userType;

  private UUID groupId;
}
