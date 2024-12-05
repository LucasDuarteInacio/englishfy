package com.englishfy.api.service;

import com.englishfy.api.dto.UserDTO;
import com.englishfy.api.dto.UserRequestDTO;
import com.englishfy.api.dto.UserScopesResponseDTO;
import java.util.List;
import java.util.UUID;

public interface UserService {

  UserDTO registerUser(UserRequestDTO request);

  List<UserDTO> getAll();
}
