package com.example.quizapp.controller.rest.client.quizClient;

import com.example.quizapp.service.client.quiz.QuizService;
import com.example.quizapp.service.client.quiz.response.QuizListResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/client/quizzes")

public class QuizClientRestController {
    private final QuizService quizService;

    @GetMapping("/{id}")
    public List<QuizListResponse> findAllBySubjectId(@PathVariable Long id){
        return quizService.findAllBySubjectId(id);
    }
}
