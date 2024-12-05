package com.englishfy.api.entity;

import static com.englishfy.api.constant.ApiConstant.USER_SCHEMA;

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
@Table(schema = USER_SCHEMA, name = "address")
public class Address {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(name = "address_id")
  private UUID id;

  @Column(name = "zip_code")
  private String zipCode;

  private String street;

  private String neighborhood;

  private String city;

  private String state;

  private String complement;

  private String reference;
}
