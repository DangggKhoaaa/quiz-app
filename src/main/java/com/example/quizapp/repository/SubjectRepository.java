package com.example.quizapp.repository;

import com.example.quizapp.model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubjectRepository extends JpaRepository<Subject, Long> {
    List<Subject> findSubjectByClassName_Id(Long className_id);
}
