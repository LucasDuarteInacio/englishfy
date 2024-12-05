package com.englishfy.api.entity.repository;

import com.englishfy.api.entity.ScopeGroup;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScopeGroupRepository extends JpaRepository<ScopeGroup, UUID> {
  void deleteAllByGroup_Id(UUID groupId);
}
