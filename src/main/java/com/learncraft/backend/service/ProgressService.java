package com.learncraft.backend.service;

import com.learncraft.backend.model.SessionProgress;
import com.learncraft.backend.repository.SessionProgressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProgressService {

    @Autowired
    private SessionProgressRepository repository;

    public SessionProgress save(SessionProgress progress) {
        return repository.save(progress);
    }

    public List<SessionProgress> getBySessionId(String sessionId) {
        return repository.findBySessionId(sessionId);
    }
}
