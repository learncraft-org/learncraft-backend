package com.learncraft.backend.model;
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
    private Module module;

    @Column(name = "lesson_code", nullable = false)
    private String lessonCode;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String description;

    @Column(name = "order_index")
    private Integer orderIndex;

    @Column(name = "question_type")
    private String questionType;

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

}
