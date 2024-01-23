package com.example.quizapp.service.client.quiz.response;

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
public class QuizListResponse {

    private Long id;
    private String content;
    private List<QuestionResponse> questionResponseList = new ArrayList<>();
}
