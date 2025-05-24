package com.learncraft.backend.controller;

import com.learncraft.backend.model.Module;
import com.learncraft.backend.service.ModuleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/modules")
@CrossOrigin(origins = "*")
public class ModuleController {

    private final ModuleService service;

    public ModuleController(ModuleService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Module>> getModules() {
        return ResponseEntity.ok(service.getAllModules());
    }

    @PostMapping
    public ResponseEntity<Module> createModule(@RequestBody Module module) {
        return ResponseEntity.ok(service.save(module));
    }
}
