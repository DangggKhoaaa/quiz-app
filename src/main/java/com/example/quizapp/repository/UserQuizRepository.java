package com.example.quizapp.repository;

import com.example.quizapp.model.UserQuiz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserQuizRepository extends JpaRepository<UserQuiz, Long> {
}
