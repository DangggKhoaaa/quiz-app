package com.example.quizapp.repository;

import com.example.quizapp.model.User;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);

    boolean existsByUsernameIgnoreCase(@NotNull String username);
    boolean existsByNameIgnoreCase(@NotNull String name);
}
