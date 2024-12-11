package com.englishfy.api.controller.impl;

import static org.springframework.http.HttpStatus.CREATED;

import com.englishfy.api.controller.CourseController;
import com.englishfy.api.dto.CourseDTO;
import com.englishfy.api.dto.CourseRequestDTO;
import com.englishfy.api.service.CourseService;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class CourseControllerImpl implements CourseController {

  private final CourseService courseService;

  @Override
  public ResponseEntity<CourseDTO> createGroup(CourseRequestDTO request) {

    CourseDTO courseDTO = courseService.registerCourse(request);

    return ResponseEntity.status(CREATED).body(courseDTO);
  }

  @Override
  public ResponseEntity<List<CourseDTO>> getAllCourses() {
    List<CourseDTO> courses = courseService.getAll();

    return ResponseEntity.ok(courses);
  }

  @Override
  public ResponseEntity<CourseDTO> getById(UUID courseId) {
    CourseDTO course = courseService.getById(courseId);
    return ResponseEntity.ok(course);
  }
}
