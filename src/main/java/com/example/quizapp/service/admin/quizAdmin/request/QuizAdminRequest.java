package com.example.quizapp.service.admin.quizAdmin.request;

import com.example.quizapp.service.admin.questionAdmin.request.QuestionAdminRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class QuizAdminRequest {
    private String content;
    private String subjectId;
    private QuestionAdminRequest question;
}
