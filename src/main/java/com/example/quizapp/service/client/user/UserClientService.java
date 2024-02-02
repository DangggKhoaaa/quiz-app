package com.example.quizapp.service.client.user;

import com.example.quizapp.model.User;
import com.example.quizapp.model.enums.Role;
import com.example.quizapp.repository.UserRepository;
import com.example.quizapp.security.JwtTokenProvider;
import com.example.quizapp.service.client.user.request.UserRequest;
import com.example.quizapp.util.AppUtils;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserClientService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;
    private final AuthenticationManager authenticationManager;

    public ResponseEntity<?> register(UserRequest request) {
        if(userRepository.existsByUsernameIgnoreCase(request.getUsername()))
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Tên Đăng Nhập Đã Tồn Tại");
        if(userRepository.existsByNameIgnoreCase(request.getName()))
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Tên Người Dùng Đã Tồn Tại");

        var user = AppUtils.mapper.map(request, User.class);
        user.setRole(Role.ROLE_USER);
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        userRepository.save(user) ;
        return ResponseEntity.noContent().build();
    }

    public String login(UserRequest request) {
        var user = userRepository.findByUsername(request.getUsername());
                if(user.isEmpty())
                    return ("Tài Khoản Không Tồn Tại");
        String token = jwtTokenProvider.generateToken(user.get().getUsername(), user.get().getRole().toString());
        return token;
    }

}
