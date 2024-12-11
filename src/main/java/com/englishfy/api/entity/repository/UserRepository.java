package com.englishfy.api.entity.repository;

import com.englishfy.api.entity.User;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {

  Boolean existsByEmailOrPhoneNumber(String email, String phoneNumber);

  @Query("SELECT u FROM User u  WHERE u.phoneNumber = :username OR u.email = :username")
  Optional<User> findUserByUsername(String username);
}
