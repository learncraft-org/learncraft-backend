package com.learncraft.backend.repository;

import com.learncraft.backend.model.SessionProgress;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface SessionProgressRepository extends JpaRepository<SessionProgress, Long> {
    List<SessionProgress> findBySessionId(String sessionId);
}
