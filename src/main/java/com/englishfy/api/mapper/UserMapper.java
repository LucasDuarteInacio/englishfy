package com.englishfy.api.mapper;

import com.englishfy.api.dto.UserDTO;
import com.englishfy.api.dto.UserRequestDTO;
import com.englishfy.api.dto.UserScopesResponseDTO;
import com.englishfy.api.entity.Group;
import com.englishfy.api.entity.Scope;
import com.englishfy.api.entity.User;
import com.englishfy.api.enums.UserStatusEnum;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

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
  User toNewUser(UserRequestDTO requestDTO);

  @Mapping(target = "id", source = "user.id")
  @Mapping(target = "name", source = "user.name")
  @Mapping(target = "password", source = "user.password")
  @Mapping(target = "phoneNumber", source = "user.phoneNumber")
  @Mapping(target = "email", source = "user.email")
  @Mapping(target = "userStatus", source = "user.userStatus")
  @Mapping(target = "userType", source = "user.userType")
  @Mapping(target = "scopes", source = "group.scopes", qualifiedByName = "mapScopesToStrings")
  UserScopesResponseDTO toUserScopesResponse(User user, Group group);

  @Named("mapScopesToStrings")
  default List<String> mapScopesToStrings(Set<Scope> scopes) {
    return scopes.stream().map(Scope::getScope).collect(Collectors.toList());
  }

  UserDTO toUserDTO(User user);

  List<UserDTO> toUserDTO(List<User> users);
}
