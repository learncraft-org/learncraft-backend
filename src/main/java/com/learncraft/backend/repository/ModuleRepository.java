package com.learncraft.backend.repository;

import com.learncraft.backend.model.Module;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModuleRepository extends JpaRepository<Module, Long> {
}
