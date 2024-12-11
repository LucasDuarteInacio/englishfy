package com.englishfy.api.entity;

import static com.englishfy.api.constant.ApiConstant.COURSE_SCHEMA;

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
@Table(schema = COURSE_SCHEMA, name = "course")
public class Course {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(name = "course_id")
  private UUID id;

  @Column(name = "name", nullable = false, unique = true, length = 50)
  private String name;

  private String description;

  @Column(name = "active")
  private boolean active;

  @Column(name = "course_level")
  private String courseLevel;

  @ManyToOne(optional = true)
  @JoinColumn(name = "user_instructor", nullable = true)
  private User userInstructor;
}
