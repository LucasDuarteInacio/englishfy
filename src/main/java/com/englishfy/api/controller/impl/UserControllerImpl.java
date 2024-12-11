package com.englishfy.api.controller.impl;

import static org.springframework.http.HttpStatus.CREATED;

import com.englishfy.api.controller.UserController;
import com.englishfy.api.dto.UserDTO;
import com.englishfy.api.dto.UserRequestDTO;
import com.englishfy.api.service.UserService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class UserControllerImpl implements UserController {

  private final UserService userService;

  @Override
  public ResponseEntity<UserDTO> registerUser(UserRequestDTO request) {
    return ResponseEntity.status(CREATED).body(userService.registerUser(request));
  }

  @Override
  public ResponseEntity<List<UserDTO>> getAllUsers() {
    return ResponseEntity.ok(userService.getAll());
  }
}
