package com.learncraft.backend.controller;

import com.learncraft.backend.dto.LessonLearnedRequest;
import com.learncraft.backend.model.LessonLearned;
import com.learncraft.backend.service.LessonLearnedService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/lessons-learned")
@CrossOrigin(origins = "*")
public class LessonLearnedController {
    private static final Logger logger = LoggerFactory.getLogger(LessonLearnedController.class);

    private final LessonLearnedService service;

    public LessonLearnedController(LessonLearnedService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<LessonLearned> markLessonAsLearned(@RequestBody LessonLearnedRequest request) {
        logger.info("Received request to mark lesson as learned: {}", request);
        try {
            LessonLearned result = service.markLessonAsLearned(request);
            logger.info("Successfully marked lesson as learned with ID: {}", result.getId());
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            logger.error("Error marking lesson as learned: {}", e.getMessage(), e);
            throw e;
        }
    }

    @GetMapping("/device/{deviceId}")
    public ResponseEntity<List<LessonLearned>> getLessonsByDevice(@PathVariable String deviceId) {
        logger.info("Getting lessons for device: {}", deviceId);
        List<LessonLearned> lessons = service.getLessonsByDevice(deviceId);
        logger.info("Retrieved {} lessons for device: {}", lessons.size(), deviceId);
        return ResponseEntity.ok(lessons);
    }

    @GetMapping
    public ResponseEntity<List<LessonLearned>> getAllLessons() {
        logger.info("Getting all lessons");
        List<LessonLearned> lessons = service.getAllLessons();
        logger.info("Retrieved total {} lessons", lessons.size());
        return ResponseEntity.ok(lessons);
    }
} 