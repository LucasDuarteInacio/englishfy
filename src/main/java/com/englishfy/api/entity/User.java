package com.englishfy.api.entity;

import static com.englishfy.api.constant.ApiConstant.USER_SCHEMA;

import com.englishfy.api.enums.UserStatusEnum;
import com.englishfy.api.enums.UserTypeEnum;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
@Table(schema = USER_SCHEMA, name = "user")
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(name = "user_id")
  private UUID id;

  private String name;

  private String password;

  @Column(name = "phone_number")
  private String phoneNumber;

  private String email;

  @Column(name = "status")
  @Enumerated(EnumType.STRING)
  private UserStatusEnum userStatus;

  @Column(name = "type")
  @Enumerated(EnumType.STRING)
  private UserTypeEnum userType;

  @Column(name = "address_id")
  private UUID addressId;

  @Column(name = "group_id")
  private UUID groupId;
}
