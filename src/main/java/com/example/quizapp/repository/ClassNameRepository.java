package com.example.quizapp.repository;

import com.example.quizapp.model.ClassName;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClassNameRepository extends JpaRepository<ClassName, Long> {
}
