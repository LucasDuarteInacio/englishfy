package com.englishfy.api.controller;

import com.englishfy.api.dto.CourseDTO;
import com.englishfy.api.dto.CourseRequestDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import java.util.List;
import java.util.UUID;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@CrossOrigin(origins = "*")
@RequestMapping("v1/courses")
@Tag(name = "Course", description = "information about courses operations")
public interface CourseController {

  @PostMapping
  @Operation(summary = "Create new Course")
  ResponseEntity<CourseDTO> createGroup(@Valid @RequestBody CourseRequestDTO request);

  @GetMapping
  @Operation(summary = "Get all courses")
  ResponseEntity<List<CourseDTO>> getAllCourses();

  @GetMapping("{courseId}")
  @Operation(summary = "Get course by id")
  ResponseEntity<CourseDTO> getById(@PathVariable UUID courseId);
}
