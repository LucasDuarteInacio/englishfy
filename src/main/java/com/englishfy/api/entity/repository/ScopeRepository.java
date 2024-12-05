package com.englishfy.api.entity.repository;

import com.englishfy.api.entity.Scope;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScopeRepository extends JpaRepository<Scope, UUID> {}
