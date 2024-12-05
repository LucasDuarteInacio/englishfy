package com.englishfy.api.entity.repository;


import com.englishfy.api.entity.Group;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRepository extends JpaRepository<Group, UUID> {


  Optional<Group> findByName(String name);
}
