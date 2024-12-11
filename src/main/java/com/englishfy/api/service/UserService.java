package com.englishfy.api.service;

import com.englishfy.api.dto.UserDTO;
import com.englishfy.api.dto.UserRequestDTO;
import java.util.List;

public interface UserService {

  UserDTO registerUser(UserRequestDTO request);

  List<UserDTO> getAll();
}
