package com.example.quizapp.service.client.userQuiz;

import com.example.quizapp.model.UserQuiz;
import com.example.quizapp.repository.*;
import com.example.quizapp.service.client.userQuiz.request.UserQuizSaveRequest;
import com.example.quizapp.service.client.userQuiz.response.UserQuizResponse;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
public class UserQuizService {
    private final UserQuizRepository userQuizRepository;
    private final QuizRepository quizRepository;
    private final QuestionRepository questionRepository;
    private final AnswerRepository answerRepository;
    private final UserRepository userRepository;

    public UserQuizResponse result (UserQuizSaveRequest request) {
        var userQuizResponse = new UserQuizResponse();
        var userQuiz = new UserQuiz();
        DecimalFormat decimalFormat = new DecimalFormat("#.#");
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUsername = authentication.getName();
        var user = userRepository.findByUsername(currentUsername);

        float totalScore = 0;
        for(var item : request.getSelectedAnswers()) {
            var question = questionRepository.findById(Long.parseLong(item.getQuestionId()));
            var answers = answerRepository.findAnswerByQuestion_IdAndStatusIsTrue(question.get().getId());
            for (var answer : item.getAnswerId()) {
                if (answers.size() == 1 && item.getAnswerId().size() == answers.size()) {
                    for (var radioAnswer : answers) {
                        if (radioAnswer.getId().equals(Long.parseLong(answer))) {
                            totalScore += 1;
                        }
                    }
                } else {
                    if(item.getAnswerId().size() == answers.size() ){
                        for (var checkboxAnswer : answers) {
                            if (checkboxAnswer.getId() != Long.parseLong(answer)) {
                                break;
                            } else {
                                totalScore += 1;
                            }
                        }
                    }
                }
            }
            String formattedScore = decimalFormat.format(((totalScore/Float.parseFloat(request.getTotalQuestion())) * 10));
            userQuiz.setScore(Float.parseFloat(formattedScore));
            userQuizResponse.setScore(Float.parseFloat(formattedScore));
            userQuiz.setQuiz(question.get().getQuizQ());
        }
        userQuiz.setDate(LocalDate.now());
        userQuizResponse.setDateComplete(LocalDate.now());
        userQuiz.setUser(user.get());
        userQuizRepository.save(userQuiz);
        return userQuizResponse;
    }
}
