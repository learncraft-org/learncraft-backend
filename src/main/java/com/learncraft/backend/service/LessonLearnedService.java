package com.learncraft.backend.service;

import com.learncraft.backend.dto.LessonLearnedRequest;
import com.learncraft.backend.model.LessonLearned;
import com.learncraft.backend.repository.LessonLearnedRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class LessonLearnedService {

    private final LessonLearnedRepository repository;

    public LessonLearnedService(LessonLearnedRepository repository) {
        this.repository = repository;
    }

    public LessonLearned markLessonAsLearned(LessonLearnedRequest request) {
        Optional<LessonLearned> existingLesson = repository.findByDeviceIdAndLessonId(
            request.getDeviceId(), 
            request.getLessonId()
        );

        if (existingLesson.isPresent()) {
            // Update existing record
            LessonLearned lessonLearned = existingLesson.get();
            lessonLearned.setLearnedAt(LocalDateTime.now());
            return repository.save(lessonLearned);
        }

        // Create new record
        LessonLearned lessonLearned = LessonLearned.builder()
                .deviceId(request.getDeviceId())
                .lessonId(request.getLessonId())
                .learnedAt(LocalDateTime.now())
                .build();

        return repository.save(lessonLearned);
    }

    public List<LessonLearned> getLessonsByDevice(String deviceId) {
        return repository.findByDeviceIdOrderByLearnedAtDesc(deviceId);
    }
} 