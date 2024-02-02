package com.example.quizapp.service.client.user.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class LoginResponse {
    private UserClientResponse UserDetail;
    private String message;
    private boolean success;

    public static LoginResponse failed(String message) {
        LoginResponse response = new LoginResponse();
        response.setSuccess(false);
        response.setMessage(message);
        return response;
    }

    public static LoginResponse success(UserClientResponse UserDetail, String message) {
        LoginResponse response = new LoginResponse();
        response.setSuccess(true);
        response.setMessage(message);
        response.setUserDetail(UserDetail);
        return response;
    }
}
