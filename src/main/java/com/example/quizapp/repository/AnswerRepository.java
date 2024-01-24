package com.example.quizapp.repository;

import com.example.quizapp.model.Answer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnswerRepository extends JpaRepository<Answer, Long> {

    List<Answer> findAnswerByQuestion_Id(Long question_id);

    List<Answer> findAnswerByQuestion_IdAndStatusIsTrue(Long question_id);

}
