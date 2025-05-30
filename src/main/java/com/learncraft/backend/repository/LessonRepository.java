package com.learncraft.backend.repository;

import com.learncraft.backend.model.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LessonRepository extends JpaRepository<Lesson, Long> {

    List<Lesson> findByModule_IdOrderByOrderIndexAsc(Long moduleId);
}
