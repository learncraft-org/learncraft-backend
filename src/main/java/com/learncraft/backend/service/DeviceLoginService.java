package com.learncraft.backend.service;

import com.learncraft.backend.model.DeviceLogin;
import com.learncraft.backend.repository.DeviceLoginRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceLoginService {

    private final DeviceLoginRepository repository;

    public DeviceLoginService(DeviceLoginRepository repository) {
        this.repository = repository;
    }

    public List<DeviceLogin> getAllDeviceLogins() {
        return repository.findAll();
    }

    public DeviceLogin getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Device login not found"));
    }

    public DeviceLogin save(DeviceLogin deviceLogin) {
        return repository.save(deviceLogin);
    }
} 