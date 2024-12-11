package com.englishfy.api.controller;

import com.englishfy.api.dto.GroupRequestDTO;
import com.englishfy.api.dto.GroupResponseDTO;
import com.englishfy.api.entity.Group;
import com.englishfy.api.entity.Scope;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import java.util.List;
import java.util.UUID;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@CrossOrigin(origins = "*")
@RequestMapping("v1/auth")
@Tag(name = "Auth", description = "information about auth operations")
public interface AuthController {

  @GetMapping("scopes")
  @Operation(summary = "Get all scopes")
  @ApiResponses(
      value = {
        @ApiResponse(responseCode = "200", description = "Get all scopes"),
      })
  ResponseEntity<List<Scope>> getAllScopes();

  @PostMapping("groups")
  @Operation(summary = "Create new Group")
  @ApiResponses(
      value = {
        @ApiResponse(responseCode = "201", description = "Get all scopes"),
        @ApiResponse(responseCode = "400", description = "Group exists"),
      })
  ResponseEntity<GroupResponseDTO> createGroup(@Valid @RequestBody GroupRequestDTO request);

  @GetMapping("groups")
  @Operation(summary = "Get all groups")
  @ApiResponses(
      value = {
        @ApiResponse(responseCode = "201", description = "Get all scopes"),
      })
  ResponseEntity<List<Group>> getAllGroups();

  @PutMapping("groups/{groupId}")
  @Operation(summary = "Update Group")
  @ApiResponses(
      value = {
        @ApiResponse(responseCode = "200", description = "Get all scopes"),
        @ApiResponse(responseCode = "404", description = "Group not exists"),
      })
  ResponseEntity<GroupResponseDTO> updateGroup(
      @PathVariable UUID groupId, @Valid @RequestBody GroupRequestDTO request);
}
