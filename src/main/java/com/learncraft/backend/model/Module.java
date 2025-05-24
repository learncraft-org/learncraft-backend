package com.learncraft.backend.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Module {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String status;

    @Column(nullable = false)
    private String color;

    @Column(name = "text_color", nullable = false)
    private String textColor;

    @Column(nullable = false)
    private String border;

    @Column(nullable = false)
    private String image;
}
