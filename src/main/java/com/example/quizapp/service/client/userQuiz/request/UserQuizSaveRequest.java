package com.example.quizapp.service.client.userQuiz.request;

import com.example.quizapp.service.client.question.response.QuestionResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserQuizSaveRequest {
    private List<UserQuizRequest> selectedAnswers = new ArrayList<>();
    private String totalQuestion;
}
