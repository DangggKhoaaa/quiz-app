package com.example.quizapp.service.client.userQuiz.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserQuizResponse {
    private LocalDate dateComplete;
    private Integer score = 0;
}
