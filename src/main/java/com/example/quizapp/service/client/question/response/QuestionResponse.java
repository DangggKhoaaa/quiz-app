package com.example.quizapp.service.client.question.response;

import com.example.quizapp.service.client.answer.response.AnswerResponse;
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
public class QuestionResponse {

    private Long id;
    private String content;
    private List<AnswerResponse> answerResponseList = new ArrayList<>();
}
