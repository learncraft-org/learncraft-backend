package com.learncraft.backend.service;

import com.learncraft.backend.model.Module;
import com.learncraft.backend.repository.ModuleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModuleService {

    private final ModuleRepository repository;

    public ModuleService(ModuleRepository repository) {
        this.repository = repository;
    }

    public List<Module> getAllModules() {
        return repository.findAll();
    }

    public Module getById(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Module not found"));
    }

    public Module save(Module module) {
        return repository.save(module);
    }
}
