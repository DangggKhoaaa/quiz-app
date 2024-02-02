package com.example.quizapp.model;

import com.example.quizapp.model.enums.Role;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String password;

    private String name;
    private String className;

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<UserQuiz> userQuizzes;

    @Enumerated(value = EnumType.STRING)
    private Role role;
}
