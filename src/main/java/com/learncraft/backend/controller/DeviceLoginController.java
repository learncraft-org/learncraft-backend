package com.learncraft.backend.controller;

import com.learncraft.backend.dto.DeviceLoginRequest;
import com.learncraft.backend.model.DeviceLogin;
import com.learncraft.backend.service.DeviceLoginService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/device-logins")
@CrossOrigin(origins = "*")
public class DeviceLoginController {

    private final DeviceLoginService service;

    public DeviceLoginController(DeviceLoginService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<DeviceLogin>> getDeviceLogins() {
        return ResponseEntity.ok(service.getAllDeviceLogins());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DeviceLogin> getDeviceLoginById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @PostMapping
    public ResponseEntity<DeviceLogin> createDeviceLogin(@RequestBody DeviceLogin deviceLogin) {
        return ResponseEntity.ok(service.save(deviceLogin));
    }

    @PostMapping("/register")
    public ResponseEntity<DeviceLogin> registerDeviceLogin(@RequestBody DeviceLoginRequest request) {
        return ResponseEntity.ok(service.registerDeviceLogin(request));
    }

    @GetMapping("/device/{deviceId}")
    public ResponseEntity<DeviceLogin> getDeviceLoginByDeviceId(@PathVariable String deviceId) {
        DeviceLogin deviceLogin = service.findByDeviceId(deviceId);
        if (deviceLogin == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(deviceLogin);
    }
} 