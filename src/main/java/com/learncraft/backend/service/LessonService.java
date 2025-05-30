package com.learncraft.backend.service;

import com.learncraft.backend.model.Lesson;
import com.learncraft.backend.repository.LessonRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LessonService {

    private final LessonRepository repository;

    public LessonService(LessonRepository repository) {
        this.repository = repository;
    }

    public List<Lesson> getAll() {
        return repository.findAll();
    }

    public List<Lesson> getByModuleId(Long moduleId) {
        return repository.findByModule_IdOrderByOrderIndexAsc(moduleId); // ✅ Updated here
    }

    public Lesson save(Lesson lesson) {
        return repository.save(lesson);
    }
}
