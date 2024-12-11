package com.englishfy.api.service;

import com.englishfy.api.dto.CourseDTO;
import com.englishfy.api.dto.CourseRequestDTO;
import java.util.List;
import java.util.UUID;

public interface CourseService {

  CourseDTO registerCourse(CourseRequestDTO request);

  List<CourseDTO> getAll();

  CourseDTO getById(UUID id);
}
