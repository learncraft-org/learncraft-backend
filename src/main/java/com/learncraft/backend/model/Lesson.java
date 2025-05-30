package com.learncraft.backend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Lesson {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "module_id", nullable = false)
    @JsonIgnore // Hide full module object from JSON
    private Module module;

    @Column(name = "lesson_code", nullable = false)
    private String lessonCode;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String title;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String description;

    @Column(name = "order_index")
    private Integer orderIndex;

    @Column(name = "question_type")
    private String questionType;

    // ✅ Manually added getters so Jackson can serialize the fields

    public String getLessonCode() {
        return lessonCode;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Integer getOrderIndex() {
        return orderIndex;
    }

    public String getQuestionType() {
        return questionType;
    }

    public Module getModule() {
        return module;
    }

    // ✅ Custom moduleId getter exposed as JSON field
    @JsonProperty("moduleId")
    public Long getModuleId() {
        return module != null ? module.getId() : null;
    }

    public Long getId() {
        return id;
    }
}
