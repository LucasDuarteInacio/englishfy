package com.englishfy.api.mapper;

import static java.util.Objects.isNull;

import com.englishfy.api.dto.CourseDTO;
import com.englishfy.api.dto.CourseRequestDTO;
import com.englishfy.api.entity.Course;
import com.englishfy.api.entity.User;
import java.util.List;
import java.util.UUID;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(
    componentModel = "spring",
    imports = {UUID.class},
    uses = {UserMapper.class})
public interface CourseMapper {

  @Mapping(
      target = "userInstructor",
      source = "userInstructor",
      qualifiedByName = "validUserInstructor")
  Course toCourse(CourseRequestDTO requestDTO);

  CourseDTO toCourseDTO(Course course);

  List<CourseDTO> toCourseDTO(List<Course> course);

  @Named("validUserInstructor")
  default User validUserInstructor(UUID userInstructor) {

    if (isNull(userInstructor)) {
      return null;
    }

    return User.builder().id(userInstructor).build();
  }
}
