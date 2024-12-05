package com.englishfy.api.service;

import com.englishfy.api.dto.GroupRequestDTO;
import com.englishfy.api.dto.GroupResponseDTO;
import com.englishfy.api.entity.Group;
import java.util.List;
import java.util.UUID;

public interface GroupService {

  Group findById(UUID groupId);

  List<Group> getAll();

  GroupResponseDTO newGroup(GroupRequestDTO groupRequest);

  GroupResponseDTO updateGroup(UUID groupId, GroupRequestDTO request);
}
