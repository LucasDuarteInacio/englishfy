package com.englishfy.api.controller;

import com.englishfy.api.dto.UserDTO;
import com.englishfy.api.dto.UserRequestDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@CrossOrigin(origins = "*")
@RequestMapping("v1/users")
@Tag(name = "Users", description = "information about users operations")
public interface UserController {

  @PostMapping
  @Operation(summary = "Create user")
  @ApiResponses(
      value = {
        @ApiResponse(responseCode = "201", description = "Create user user"),
        @ApiResponse(
            responseCode = "400",
            description = "There is already a user registered with this phone number or email")
      })
  ResponseEntity<UserDTO> registerUser(@RequestBody UserRequestDTO request);

  @GetMapping()
  @Operation(summary = "Get all users")
  @ApiResponses(
      value = {
        @ApiResponse(responseCode = "201", description = "Get all users"),
        @ApiResponse(responseCode = "404", description = "User not found"),
        @ApiResponse(responseCode = "404", description = "Group not found")
      })
  ResponseEntity<List<UserDTO>> getAllUsers();
}
