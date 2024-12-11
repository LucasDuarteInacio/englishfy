package com.englishfy.api.mapper;

import com.englishfy.api.dto.UserDTO;
import com.englishfy.api.dto.UserRequestDTO;
import com.englishfy.api.entity.User;
import com.englishfy.api.enums.UserStatusEnum;
import java.util.List;
import java.util.UUID;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(
    componentModel = "spring",
    imports = {UUID.class, UserStatusEnum.class})
public interface UserMapper {

  @Mapping(target = "userStatus", expression = "java(UserStatusEnum.ACTIVE)")
  @Mapping(target = "name", source = "name")
  @Mapping(target = "password", source = "password")
  @Mapping(target = "phoneNumber", source = "phoneNumber")
  @Mapping(target = "email", source = "email")
  @Mapping(target = "userType", source = "userType")
  User toUser(UserRequestDTO requestDTO);

  User toUser(UserDTO userDTO);

  UserDTO toUserDTO(User user);

  List<UserDTO> toUserDTO(List<User> users);
}
