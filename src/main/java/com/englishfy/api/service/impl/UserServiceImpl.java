package com.englishfy.api.service.impl;

import static com.englishfy.api.exception.IssueTypeEnum.USER_EXISTS;

import com.englishfy.api.dto.UserDTO;
import com.englishfy.api.dto.UserRequestDTO;
import com.englishfy.api.dto.UserScopesResponseDTO;
import com.englishfy.api.entity.Group;
import com.englishfy.api.entity.User;
import com.englishfy.api.entity.repository.UserRepository;
import com.englishfy.api.exception.DataExistsException;
import com.englishfy.api.exception.NotFoundException;
import com.englishfy.api.mapper.UserMapper;
import com.englishfy.api.service.GroupService;
import com.englishfy.api.service.UserService;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

  private final UserRepository userRepository;
  private final UserMapper userMapper;
  private final GroupService groupService;

  @Override
  public UserDTO registerUser(UserRequestDTO request) {

    boolean userExists = userRepository
            .existsByEmailOrPhoneNumber(request.getEmail(), request.getPhoneNumber());

    if (userExists){
      log.error(
              "{}: email({}) phoneNumber({})",
              USER_EXISTS.getMessage(),
              request.getEmail(),
              request.getPhoneNumber());
      throw DataExistsException.userExistsException();
    }

    return userMapper.toUserDTO(userRepository.save(userMapper.toNewUser(request)));
  }

  @Override
  public List<UserDTO> getAll() {
    List<User> user = userRepository.findAll();
    return userMapper.toUserDTO(user);
  }
}
