package com.englishfy.api.service.impl;

import com.englishfy.api.dto.CourseDTO;
import com.englishfy.api.dto.CourseRequestDTO;
import com.englishfy.api.entity.Course;
import com.englishfy.api.entity.repository.CourseRepository;
import com.englishfy.api.exception.DataExistsException;
import com.englishfy.api.exception.NotFoundException;
import com.englishfy.api.mapper.CourseMapper;
import com.englishfy.api.service.CourseService;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {

  private final CourseRepository courseRepository;
  private final CourseMapper courseMapper;

  @Override
  public CourseDTO registerCourse(CourseRequestDTO request) {

    boolean isCourseExists = courseRepository.existsByName(request.getName());

    if (isCourseExists) {
      throw DataExistsException.courseExistsException();
    }

    Course course = courseMapper.toCourse(request);
    course.setActive(true);

    Course courseSaved = courseRepository.save(course);

    return courseMapper.toCourseDTO(courseSaved);
  }

  @Override
  public List<CourseDTO> getAll() {
    return courseMapper.toCourseDTO(courseRepository.findAll());
  }

  @Override
  public CourseDTO getById(UUID id) {
    Course course =
        courseRepository.findById(id).orElseThrow(NotFoundException::courseNotFoundException);

    return courseMapper.toCourseDTO(course);
  }
}
