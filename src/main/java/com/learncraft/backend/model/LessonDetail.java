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
public class LessonDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private String note;

    @Column(name = "audio_link")
    private String audioLink;

    @ManyToOne
    @JoinColumn(name = "lesson_id", nullable = false)
    @JsonIgnore // Hide full lesson in response
    private Lesson lesson;

    @JsonProperty("lessonId")
    public Long getLessonId() {
        return lesson != null ? lesson.getId() : null;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getNote() {
        return note;
    }

    public String getAudioLink() {
        return audioLink;
    }
}
