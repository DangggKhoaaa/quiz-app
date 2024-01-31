package com.example.quizapp.service.admin.quizAdmin;

import com.example.quizapp.model.Answer;
import com.example.quizapp.model.Question;
import com.example.quizapp.model.Quiz;
import com.example.quizapp.model.enums.Type;
import com.example.quizapp.repository.AnswerRepository;
import com.example.quizapp.repository.QuestionRepository;
import com.example.quizapp.repository.QuizRepository;
import com.example.quizapp.repository.SubjectRepository;
import com.example.quizapp.service.admin.questionAdmin.request.QuestionAdminRequest;
import com.example.quizapp.service.admin.quizAdmin.request.QuizAdminRequest;
import com.example.quizapp.util.AppUtils;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Transactional
public class QuizAdminService {

}
