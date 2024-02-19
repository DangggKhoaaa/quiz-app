package com.example.quizapp.controller.rest.authentication;

import com.example.quizapp.model.User;
import com.example.quizapp.service.client.user.UserClientService;
import com.example.quizapp.service.client.user.request.LoginGoogleRequest;
import com.example.quizapp.service.client.user.request.UserRequest;
import com.example.quizapp.service.client.user.response.LoginGoogleResponse;
import com.example.quizapp.service.client.user.response.LoginResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/api/auth")
public class AuthResController {

    private final UserClientService userService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody UserRequest request) {
        return userService.register(request);
    }

    @PostMapping("/login")
    public LoginResponse login(@RequestBody UserRequest request) {
        return userService.login(request);
    }

    @PostMapping("/loginGoogle")
    public LoginGoogleResponse loginGoogle(@RequestBody LoginGoogleRequest request) {
        return userService.loginGoogle(request);
    }
}
