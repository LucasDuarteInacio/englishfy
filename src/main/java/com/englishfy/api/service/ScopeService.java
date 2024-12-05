package com.englishfy.api.service;

import com.englishfy.api.entity.Scope;
import java.util.List;
import java.util.UUID;

public interface ScopeService {

  List<Scope> getAllScopes();

  Scope getScopeById(UUID id);
}
