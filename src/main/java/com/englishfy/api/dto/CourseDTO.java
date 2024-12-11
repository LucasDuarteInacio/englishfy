package com.englishfy.api.dto;

import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CourseDTO {

  private UUID id;

  private String name;

  private String description;

  private boolean active;

  private String courseLevel;

  private UserDTO userInstructor;
}
