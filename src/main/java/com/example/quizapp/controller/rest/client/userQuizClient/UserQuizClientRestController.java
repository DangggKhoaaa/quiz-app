package com.example.quizapp.controller.rest.client.userQuizClient;

import com.example.quizapp.service.client.userQuiz.UserQuizService;
import com.example.quizapp.service.client.userQuiz.request.UserQuizSaveRequest;
import com.example.quizapp.service.client.userQuiz.response.UserQuizResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/client/userQuiz")
public class UserQuizClientRestController {
    private final UserQuizService userQuizService;

    @PostMapping
    public UserQuizResponse result (@RequestBody UserQuizSaveRequest request) {
        return userQuizService.result(request);
    }
}
