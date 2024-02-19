package com.example.quizapp.service.client.user.response;

import com.example.quizapp.model.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class LoginGoogleResponse {
    private String username;
    private String name;
    private Role role;
    private String token;
}
