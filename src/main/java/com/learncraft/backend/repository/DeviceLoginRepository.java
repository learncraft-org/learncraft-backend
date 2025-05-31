package com.learncraft.backend.repository;

import com.learncraft.backend.model.DeviceLogin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeviceLoginRepository extends JpaRepository<DeviceLogin, Long> {
} 