package com.example.quizapp.service.client.user;

import com.example.quizapp.model.User;
import com.example.quizapp.model.enums.Role;
import com.example.quizapp.repository.UserRepository;
import com.example.quizapp.security.JwtTokenProvider;
import com.example.quizapp.service.client.user.request.ChangePasswordRequest;
import com.example.quizapp.service.client.user.request.LoginGoogleRequest;
import com.example.quizapp.service.client.user.request.UserRequest;
import com.example.quizapp.service.client.user.response.LoginGoogleResponse;
import com.example.quizapp.service.client.user.response.LoginResponse;
import com.example.quizapp.service.client.user.response.UserClientResponse;
import com.example.quizapp.util.AppUtils;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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

        var user = AppUtils.mapper.map(request, User.class);
        user.setRole(Role.ROLE_USER);
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        userRepository.save(user) ;
        return ResponseEntity.noContent().build();
    }

    public LoginResponse login(UserRequest request) {
        var user = userRepository.findByUsername(request.getUsername());
        if(user.isPresent()){
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            if(passwordEncoder.matches(request.getPassword(), user.get().getPassword())){
                var userClientResponse = AppUtils.mapper.map(user, UserClientResponse.class);
                userClientResponse.setToken(jwtTokenProvider.generateToken(user.get().getUsername(), user.get().getRole().toString()));
                return LoginResponse.success(userClientResponse,"Đăng Nhập Thành Công");
            }
        }
        return LoginResponse.failed("Tên Đăng Nhập Hoặc Mật Khẩu Không Đúng");
    }

    public LoginGoogleResponse loginGoogle(LoginGoogleRequest request) {
        var user = userRepository.findByUsername(request.getEmail());
        var result = new LoginGoogleResponse();

        if(user.isPresent()){
            result = AppUtils.mapper.map(user, LoginGoogleResponse.class);
            result.setToken(jwtTokenProvider.generateToken(user.get().getUsername(), user.get().getRole().toString()));
        }
        else {
            var newUser = AppUtils.mapper.map(request, User.class);
            newUser.setUsername(request.getEmail());
            newUser.setRole(Role.ROLE_USER);
            userRepository.save(newUser);

            result.setToken(jwtTokenProvider.generateToken(newUser.getUsername(), newUser.getRole().toString()));

        }
        return result;
    }

    public ResponseEntity<?> changePassword(ChangePasswordRequest request) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUsername = authentication.getName();
        var user = userRepository.findByUsername(currentUsername);
        if(user.isPresent()){
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            if(passwordEncoder.matches(request.getCurrentPassword(),user.get().getPassword())){
                String newPassword = passwordEncoder.encode(request.getNewPassword());
                user.get().setPassword(newPassword);
                userRepository.save(user.get());
                return ResponseEntity.ok("Đổi Mật Khẩu Thành Công");
            }
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Sai Mật Khẩu");
    }

}
