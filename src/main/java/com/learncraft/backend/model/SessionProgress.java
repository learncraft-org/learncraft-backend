package com.learncraft.backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data  // Generates getters, setters, toString, equals, hashCode
@NoArgsConstructor  // Default constructor
@AllArgsConstructor  // Constructor with all fields
public class SessionProgress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String sessionId;
    private String module;
    private String lesson;
    private boolean completed;
}
