package com.example.quizapp.service.admin.questionAdmin.request;

import com.example.quizapp.service.admin.answerAdmin.request.AnswerAdminRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class QuestionAdminRequest {
    private String creator;
    private String question;
    private String type;
    private List<AnswerAdminRequest> answers =new ArrayList<>() ;
}
