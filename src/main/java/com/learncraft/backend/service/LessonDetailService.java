package com.learncraft.backend.service;

import com.learncraft.backend.model.LessonDetail;
import com.learncraft.backend.repository.LessonDetailRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LessonDetailService {

    private final LessonDetailRepository repository;

    public LessonDetailService(LessonDetailRepository repository) {
        this.repository = repository;
    }

    public List<LessonDetail> getByLessonId(Long lessonId) {
        return repository.findByLesson_IdOrderByIdAsc(lessonId);
    }

    public LessonDetail save(LessonDetail detail) {
        return repository.save(detail);
    }
}
