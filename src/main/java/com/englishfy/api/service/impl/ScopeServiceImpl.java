package com.englishfy.api.service.impl;

import com.englishfy.api.entity.Scope;
import com.englishfy.api.entity.repository.ScopeRepository;
import com.englishfy.api.exception.NotFoundException;
import com.englishfy.api.service.ScopeService;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ScopeServiceImpl implements ScopeService {

  private final ScopeRepository scopeRepository;

  @Override
  public List<Scope> getAllScopes() {
    return scopeRepository.findAll();
  }

  @Override
  public Scope getScopeById(UUID id) {
    return scopeRepository.findById(id).orElseThrow(NotFoundException::scopeNotFoundException);
  }
}
