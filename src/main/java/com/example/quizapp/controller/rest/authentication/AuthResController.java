package com.example.quizapp.controller.rest.authentication;

import com.example.quizapp.model.User;
import com.example.quizapp.service.client.user.UserService;
import com.example.quizapp.service.client.user.request.UserRequest;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/api/auth")
public class AuthResController {

    private final UserService userService;

    @PostMapping("/register")
    public User register(@RequestBody UserRequest request) {
        return userService.register(request);
    }
}
