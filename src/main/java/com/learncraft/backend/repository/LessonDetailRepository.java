package com.learncraft.backend.repository;

import com.learncraft.backend.model.LessonDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LessonDetailRepository extends JpaRepository<LessonDetail, Long> {
    List<LessonDetail> findByLesson_IdOrderByIdAsc(Long lessonId);
}
