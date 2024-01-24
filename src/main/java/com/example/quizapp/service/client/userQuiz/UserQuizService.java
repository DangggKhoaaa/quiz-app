package com.example.quizapp.service.client.userQuiz;

import com.example.quizapp.model.UserQuiz;
import com.example.quizapp.repository.AnswerRepository;
import com.example.quizapp.repository.QuestionRepository;
import com.example.quizapp.repository.QuizRepository;
import com.example.quizapp.repository.UserQuizRepository;
import com.example.quizapp.service.client.userQuiz.request.UserQuizSaveRequest;
import com.example.quizapp.service.client.userQuiz.response.UserQuizResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
public class UserQuizService {
    private final UserQuizRepository userQuizRepository;
    private final QuizRepository quizRepository;
    private final QuestionRepository questionRepository;
    private final AnswerRepository answerRepository;

    public UserQuizResponse result (List<UserQuizSaveRequest> request) {
        var userQuizResponse = new UserQuizResponse();
        var userQuiz = new UserQuiz();
        for(var item : request){
            var question = questionRepository.findById(Long.parseLong(item.getQuestionId()));
                var answers = answerRepository.findAnswerByQuestion_IdAndStatusIsTrue(question.get().getId());
                for(var answer : answers){
                    if(answer.getId().equals(Long.parseLong(item.getAnswerId()))){
                        userQuiz.setDate(LocalDate.now());
                        userQuiz.setScore(userQuiz.getScore() + 1);
                        userQuiz.setQuiz(question.get().getQuizQ());

                        userQuizResponse.setScore(userQuizResponse.getScore() + 1);
                        userQuizResponse.setDateComplete(LocalDate.now());
                    }
                }
        }
        userQuizRepository.save(userQuiz);
        return userQuizResponse;
    }
}
