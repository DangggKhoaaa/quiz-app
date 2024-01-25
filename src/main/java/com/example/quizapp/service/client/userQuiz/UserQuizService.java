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
        for(var item : request) {
            var question = questionRepository.findById(Long.parseLong(item.getQuestionId()));
            var answers = answerRepository.findAnswerByQuestion_IdAndStatusIsTrue(question.get().getId());
            for (var answer : item.getAnswerId()) {
                if (answers.size() <= 1) {
                    for (var radioAnswer : answers) {
                        if (radioAnswer.getId().equals(Long.parseLong(answer))) {
                            userQuiz.setScore(userQuiz.getScore() + 1);
                            userQuizResponse.setScore(userQuizResponse.getScore() + 1);
                        }
                    }
                } else {
                    if(item.getAnswerId().size() == answers.size() ){
                        for (var checkboxAnswer : answers) {
                            if (checkboxAnswer.getId() != Long.parseLong(answer)) {
                                break;
                            } else {
                                userQuiz.setScore(userQuiz.getScore() + 1);
                                userQuizResponse.setScore(userQuizResponse.getScore() + 1);
                            }
                        }
                    }

                }
            }
            userQuiz.setQuiz(question.get().getQuizQ());
            userQuiz.setDate(LocalDate.now());
            userQuizResponse.setDateComplete(LocalDate.now());
        }
        userQuizRepository.save(userQuiz);
        return userQuizResponse;
    }
}
