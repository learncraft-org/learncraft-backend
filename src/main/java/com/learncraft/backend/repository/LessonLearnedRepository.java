package com.learncraft.backend.repository;

import com.learncraft.backend.model.LessonLearned;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LessonLearnedRepository extends JpaRepository<LessonLearned, Long> {
    List<LessonLearned> findByDeviceIdOrderByLearnedAtDesc(String deviceId);
    Optional<LessonLearned> findByDeviceIdAndLessonId(String deviceId, Long lessonId);
} 