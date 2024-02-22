package com.example.quizapp.controller.rest.admin;

import com.example.quizapp.model.Question;
import com.example.quizapp.service.admin.questionAdmin.QuestionAdminService;
import com.example.quizapp.service.admin.questionAdmin.request.QuestionAdminRequest;
import com.example.quizapp.service.admin.questionAdmin.request.QuestionCheckboxAdminRequest;
import com.example.quizapp.service.client.question.QuestionService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api/admin/questions")
public class QuestionAdminRestController {
    private final QuestionAdminService questionAdminService;

    @PostMapping("/radio/{id}")
    public Question createQuestion(@RequestBody QuestionAdminRequest request , @PathVariable Long id) {
        return questionAdminService.createQuestion(request, id);
    }

    @PostMapping("/checkbox/{id}")
    public Question createQuestionCheckbox(@RequestBody QuestionCheckboxAdminRequest request , @PathVariable Long id) {
        return questionAdminService.createQuestionCheckbox(request, id);
    }
}
