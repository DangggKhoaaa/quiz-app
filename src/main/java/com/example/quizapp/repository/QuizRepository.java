package com.example.quizapp.repository;

import com.example.quizapp.model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface QuizRepository extends JpaRepository<Quiz, Long> {

  List <Quiz>  findQuizBySubject_Id(Long subject_id);


}
