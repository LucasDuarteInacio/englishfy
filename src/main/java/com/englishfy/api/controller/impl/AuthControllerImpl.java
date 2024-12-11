package com.englishfy.api.controller.impl;

import com.englishfy.api.controller.AuthController;
import com.englishfy.api.dto.GroupRequestDTO;
import com.englishfy.api.dto.GroupResponseDTO;
import com.englishfy.api.entity.Group;
import com.englishfy.api.entity.Scope;
import com.englishfy.api.service.GroupService;
import com.englishfy.api.service.ScopeService;
import java.net.URI;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class AuthControllerImpl implements AuthController {

  private final ScopeService scopeService;
  private final GroupService groupService;

  @Override
  public ResponseEntity<List<Scope>> getAllScopes() {
    return ResponseEntity.ok(scopeService.getAllScopes());
  }

  @Override
  @SneakyThrows
  public ResponseEntity<GroupResponseDTO> createGroup(GroupRequestDTO request) {
    GroupResponseDTO response = groupService.newGroup(request);
    return ResponseEntity.created(new URI("id")).body(response);
  }

  @Override
  public ResponseEntity<List<Group>> getAllGroups() {
    return ResponseEntity.ok(groupService.getAll());
  }

  @Override
  public ResponseEntity<GroupResponseDTO> updateGroup(UUID groupId, GroupRequestDTO request) {
    return ResponseEntity.ok(groupService.updateGroup(groupId, request));
  }
}
