package com.englishfy.api.entity;

import static com.englishfy.api.constant.ApiConstant.COURSE_SCHEMA;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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
@Table(schema = COURSE_SCHEMA, name = "lesson")
public class Lesson {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(name = "lesson_id")
  private UUID id;

  @Column(name = "name", nullable = false, unique = true, length = 50)
  private String name;

  @Column(name = "description")
  private String description;

  @Column(name = "video_url", length = 100)
  private String videoUrl;

  @Column(name = "content_md", columnDefinition = "TEXT")
  private String contentMd;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "module_id")
  private Module module;
}
