package com.example.quizapp.service.client.user.response;

import com.example.quizapp.model.enums.Role;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserClientResponse {
    private String school;
    private String username;
    private String className;
    private String name;
    private Role role;
    private String token;
}
