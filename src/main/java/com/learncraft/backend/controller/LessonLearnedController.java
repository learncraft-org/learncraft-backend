package com.learncraft.backend.controller;

import com.learncraft.backend.dto.LessonLearnedRequest;
import com.learncraft.backend.model.LessonLearned;
import com.learncraft.backend.service.LessonLearnedService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/lessons-learned")
@CrossOrigin(origins = "*")
public class LessonLearnedController {

    private final LessonLearnedService service;

    public LessonLearnedController(LessonLearnedService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<LessonLearned> markLessonAsLearned(@RequestBody LessonLearnedRequest request) {
        return ResponseEntity.ok(service.markLessonAsLearned(request));
    }

    @GetMapping("/device/{deviceId}")
    public ResponseEntity<List<LessonLearned>> getLessonsByDevice(@PathVariable String deviceId) {
        return ResponseEntity.ok(service.getLessonsByDevice(deviceId));
    }
} 