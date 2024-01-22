package com.example.quizapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;

    @OneToMany(mappedBy = "quizQ")
    private List<Question> questions;

    @OneToMany(mappedBy = "quiz")
    @JsonIgnore
    private List<UserQuiz> quizzes;

    @ManyToOne
    @JoinColumn(name = "subject_id")
    private Subject subject;

}
