package com.learncraft.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DeviceLoginRequest {
    private String manufacturer;
    private String model;
    private String brand;
    private String deviceId;
} 