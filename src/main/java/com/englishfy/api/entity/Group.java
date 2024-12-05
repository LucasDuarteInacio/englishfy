package com.englishfy.api.entity;

import static com.englishfy.api.constant.ApiConstant.AUTH_SCHEMA;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import java.util.Set;
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
@Table(schema = AUTH_SCHEMA, name = "group")
public class Group {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(name = "group_id")
  private UUID id;

  private String name;

  @ManyToMany
  @JoinTable(
      name = "scope_group",
      schema = AUTH_SCHEMA,
      joinColumns = @JoinColumn(name = "group_id", referencedColumnName = "group_id"),
      inverseJoinColumns = @JoinColumn(name = "scope_id", referencedColumnName = "scope_id"))
  private Set<Scope> scopes;
}
