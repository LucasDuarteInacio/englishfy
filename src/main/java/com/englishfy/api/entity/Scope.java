package com.englishfy.api.entity;

import static com.englishfy.api.constant.ApiConstant.AUTH_SCHEMA;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Table(schema = AUTH_SCHEMA, name = "scope")
public class Scope {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(name = "scope_id")
  private UUID id;

  @Column(name = "scope")
  private String scope;

  @Column(name = "scope_description")
  private String scopeDescription;
}
