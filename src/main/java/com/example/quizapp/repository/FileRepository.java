package com.example.quizapp.repository;

import com.example.quizapp.model.File;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileRepository extends JpaRepository <File , Long> {
}
