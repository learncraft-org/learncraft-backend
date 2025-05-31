package com.learncraft.backend.service;

import com.learncraft.backend.dto.DeviceLoginRequest;
import com.learncraft.backend.model.DeviceLogin;
import com.learncraft.backend.repository.DeviceLoginRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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

    public DeviceLogin registerDeviceLogin(DeviceLoginRequest request) {
        DeviceLogin deviceLogin = DeviceLogin.builder()
                .manufacturer(request.getManufacturer())
                .model(request.getModel())
                .brand(request.getBrand())
                .deviceId(request.getDeviceId())
                .loginAt(LocalDateTime.now())
                .build();

        return repository.save(deviceLogin);
    }

    public DeviceLogin findByDeviceId(String deviceId) {
        return repository.findFirstByDeviceIdOrderByLoginAtDesc(deviceId)
                .orElse(null);
    }
} 