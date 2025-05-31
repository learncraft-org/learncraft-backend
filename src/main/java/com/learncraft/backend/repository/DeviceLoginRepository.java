package com.learncraft.backend.repository;

import com.learncraft.backend.model.DeviceLogin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DeviceLoginRepository extends JpaRepository<DeviceLogin, Long> {
    Optional<DeviceLogin> findFirstByDeviceIdOrderByLoginAtDesc(String deviceId);
} 