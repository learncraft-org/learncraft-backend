package com.learncraft.backend.controller;

import com.learncraft.backend.model.LessonDetail;
import com.learncraft.backend.service.LessonDetailService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/lesson-details")
@CrossOrigin(origins = "*")
public class LessonDetailController {

    private final LessonDetailService service;

    public LessonDetailController(LessonDetailService service) {
        this.service = service;
    }

    @GetMapping("/lesson/{lessonId}")
    public ResponseEntity<List<LessonDetail>> getByLesson(@PathVariable Long lessonId) {
        return ResponseEntity.ok(service.getByLessonId(lessonId));
    }

    @PostMapping
    public ResponseEntity<LessonDetail> create(@RequestBody LessonDetail detail) {
        return ResponseEntity.ok(service.save(detail));
    }
}
