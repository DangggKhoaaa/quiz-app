package com.example.quizapp.service.client.userQuiz.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserQuizSaveRequest {
    private List<String> answerId;
    private String questionId;

}
