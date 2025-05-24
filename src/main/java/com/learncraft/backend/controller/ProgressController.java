package com.learncraft.backend.controller;

import com.learncraft.backend.model.SessionProgress;
import com.learncraft.backend.service.ProgressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/progress")
@CrossOrigin(origins = "*") // Allows requests from Flutter frontend
public class ProgressController {

    @Autowired
    private ProgressService service;

    @PostMapping("/save")
    public ResponseEntity<SessionProgress> saveProgress(@RequestBody SessionProgress progress) {
        return ResponseEntity.ok(service.save(progress));
    }

    @GetMapping("/{sessionId}")
    public ResponseEntity<List<SessionProgress>> getProgress(@PathVariable String sessionId) {
        return ResponseEntity.ok(service.getBySessionId(sessionId));
    }
}
