package com.englishfy.api.entity.repository;

import com.englishfy.api.entity.Course;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, UUID> {

  boolean existsByName(String name);
}
