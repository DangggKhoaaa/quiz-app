package com.example.quizapp.controller.rest.client.questionClient;

import com.example.quizapp.service.client.question.QuestionService;
import com.example.quizapp.service.client.question.response.QuestionResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/client/questions")
public class QuestionClientRestController {
    private final QuestionService questionService;

    @GetMapping("/{id}")
    public List<QuestionResponse> findAllByQuizId(@PathVariable Long id) {
        return questionService.findAllByQuizId(id);
    }

}
