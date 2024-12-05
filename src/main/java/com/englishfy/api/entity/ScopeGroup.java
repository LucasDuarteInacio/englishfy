package com.englishfy.api.entity;

import static com.englishfy.api.constant.ApiConstant.AUTH_SCHEMA;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(schema = AUTH_SCHEMA, name = "scope_group")
public class ScopeGroup {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(name = "scope_group_id")
  private UUID id;

  @ManyToOne
  @JoinColumn(name = "group_id", referencedColumnName = "group_id")
  private Group group;

  @ManyToOne
  @JoinColumn(name = "scope_id", referencedColumnName = "scope_id")
  private Scope scope;
}
