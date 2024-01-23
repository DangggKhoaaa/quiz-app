package com.example.quizapp.repository;

import com.example.quizapp.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Long> {
    List<Question> findQuestionByQuizQ_Id(Long quizQ_id);

}
