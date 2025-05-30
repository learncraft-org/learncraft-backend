package com.learncraft.backend.controller;

import com.learncraft.backend.model.Lesson;
import com.learncraft.backend.service.LessonService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/lessons")
@CrossOrigin(origins = "*")
public class LessonController {

    private final LessonService service;

    public LessonController(LessonService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Lesson>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/module/{moduleId}")
    public ResponseEntity<List<Lesson>> getByModule(@PathVariable Long moduleId) {
        return ResponseEntity.ok(service.getByModuleId(moduleId));
    }

    @PostMapping
    public ResponseEntity<Lesson> create(@RequestBody Lesson lesson) {
        return ResponseEntity.ok(service.save(lesson));
    }
}
