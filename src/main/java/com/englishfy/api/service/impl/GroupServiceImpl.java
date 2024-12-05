package com.englishfy.api.service.impl;

import static java.util.Objects.nonNull;

import com.englishfy.api.dto.GroupRequestDTO;
import com.englishfy.api.dto.GroupResponseDTO;
import com.englishfy.api.entity.Group;
import com.englishfy.api.entity.Scope;
import com.englishfy.api.entity.ScopeGroup;
import com.englishfy.api.entity.repository.GroupRepository;
import com.englishfy.api.entity.repository.ScopeGroupRepository;
import com.englishfy.api.exception.DataExistsException;
import com.englishfy.api.exception.NotFoundException;
import com.englishfy.api.service.GroupService;
import com.englishfy.api.service.ScopeService;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class GroupServiceImpl implements GroupService {

  private final GroupRepository groupRepository;
  private final ScopeService scopeService;
  private final ScopeGroupRepository scopeGroupRepository;

  @Override
  public Group findById(UUID groupId) {
    return groupRepository.findById(groupId).orElseThrow(NotFoundException::groupNotFoundException);
  }

  @Override
  public List<Group> getAll() {
    return groupRepository.findAll()
            .stream()
            .filter(group -> !group.getName().equals("main"))
            .toList();
  }

  @Override
  @Transactional
  public GroupResponseDTO newGroup(GroupRequestDTO groupRequest) {

    if (groupRepository.findByName( groupRequest.getName()).isPresent()) {
      throw DataExistsException.groupExistsException();
    }

    Group group =
        Group.builder()
            .name(groupRequest.getName())
            .build();

    Group groupSaved = groupRepository.save(group);

    saveScopeGroup(groupSaved, groupRequest.getScopesId());

    return GroupResponseDTO.builder().id(groupSaved.getId()).name(groupSaved.getName()).build();
  }

  @Override
  @Transactional
  public GroupResponseDTO updateGroup(UUID groupId, GroupRequestDTO request) {
    Group group =
        groupRepository.findById(groupId).orElseThrow(NotFoundException::groupNotFoundException);

    if (!group.getName().equals(request.getName())) {
      group.setName(request.getName());
      groupRepository.save(group);
    }

    if (nonNull(request.getScopesId()) && !request.getScopesId().isEmpty()) {
      scopeGroupRepository.deleteAllByGroup_Id(groupId);
      saveScopeGroup(group, request.getScopesId());
    }

    return GroupResponseDTO.builder().id(group.getId()).name(group.getName()).build();
  }

  void saveScopeGroup(Group group, List<UUID> scopesIdlist) {
    List<ScopeGroup> scopeGroups =
        scopesIdlist.stream()
            .map(
                scopeId -> {
                  Scope scope = scopeService.getScopeById(scopeId);
                  return ScopeGroup.builder().scope(scope).group(group).build();
                })
            .collect(Collectors.toList());

    scopeGroupRepository.saveAllAndFlush(scopeGroups);
  }
}
