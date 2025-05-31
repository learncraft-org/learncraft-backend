package com.learncraft.backend.service;

import com.learncraft.backend.dto.LessonLearnedRequest;
import com.learncraft.backend.model.LessonLearned;
import com.learncraft.backend.repository.LessonLearnedRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class LessonLearnedService {
    private static final Logger logger = LoggerFactory.getLogger(LessonLearnedService.class);

    private final LessonLearnedRepository repository;

    public LessonLearnedService(LessonLearnedRepository repository) {
        this.repository = repository;
    }

    public LessonLearned markLessonAsLearned(LessonLearnedRequest request) {
        logger.info("Marking lesson as learned. DeviceId: {}, LessonId: {}", 
            request.getDeviceId(), request.getLessonId());

        Optional<LessonLearned> existingLesson = repository.findByDeviceIdAndLessonId(
            request.getDeviceId(), 
            request.getLessonId()
        );

        if (existingLesson.isPresent()) {
            // Update existing record
            logger.info("Updating existing lesson learned record");
            LessonLearned lessonLearned = existingLesson.get();
            lessonLearned.setLearnedAt(LocalDateTime.now());
            return repository.save(lessonLearned);
        }

        // Create new record
        logger.info("Creating new lesson learned record");
        LessonLearned lessonLearned = LessonLearned.builder()
                .deviceId(request.getDeviceId())
                .lessonId(request.getLessonId())
                .learnedAt(LocalDateTime.now())
                .build();

        LessonLearned saved = repository.save(lessonLearned);
        logger.info("Saved lesson learned with ID: {}", saved.getId());
        return saved;
    }

    public List<LessonLearned> getLessonsByDevice(String deviceId) {
        logger.info("Getting lessons for device: {}", deviceId);
        List<LessonLearned> lessons = repository.findByDeviceIdOrderByLearnedAtDesc(deviceId);
        logger.info("Found {} lessons for device: {}", lessons.size(), deviceId);
        return lessons;
    }

    public List<LessonLearned> getAllLessons() {
        List<LessonLearned> allLessons = repository.findAll();
        logger.info("Total lessons in database: {}", allLessons.size());
        return allLessons;
    }
} 