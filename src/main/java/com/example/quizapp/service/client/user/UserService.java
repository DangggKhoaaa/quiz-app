package com.example.quizapp.service.client.user;

import com.example.quizapp.model.User;
import com.example.quizapp.model.enums.Role;
import com.example.quizapp.repository.UserRepository;
import com.example.quizapp.service.client.user.request.UserRequest;
import com.example.quizapp.util.AppUtils;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User register(UserRequest request) {
        var user = AppUtils.mapper.map(request, User.class);
        user.setRole(Role.ROLE_USER);
        return userRepository.save(user) ;
    }

    public void login(UserRequest request) {
        var user = userRepository.findByUsername(request.getUsername());
        if(user.isPresent()){

        }
    }
}
