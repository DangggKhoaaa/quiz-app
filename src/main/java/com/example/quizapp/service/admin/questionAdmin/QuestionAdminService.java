package com.example.quizapp.service.admin.questionAdmin;

import com.example.quizapp.model.Answer;
import com.example.quizapp.model.Question;
import com.example.quizapp.model.enums.Type;
import com.example.quizapp.repository.AnswerRepository;
import com.example.quizapp.repository.QuestionRepository;
import com.example.quizapp.repository.QuizRepository;
import com.example.quizapp.repository.SubjectRepository;
import com.example.quizapp.service.admin.questionAdmin.request.QuestionAdminRequest;
import com.example.quizapp.util.AppUtils;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Transactional
public class QuestionAdminService {
    private final SubjectRepository subjectRepository;
    private final QuizRepository quizRepository;
    private final QuestionRepository questionRepository;
    private final AnswerRepository answerRepository;

    public Question createQuestion(QuestionAdminRequest request , Long id) {
        var result = new Question();
        var quiz = quizRepository.findById(id);
        result.setType(Type.valueOf(request.getType()));
        result.setQuizQ(quiz.get());
        result.setContent(request.getQuestion());
        questionRepository.save(result);
        var question = questionRepository.findById(result.getId());
        for(var i = 0 ; i < request.getAnswers().size() ; i ++){
                var answer = new Answer();
                var item = request.getAnswers().get(i);
                    answer.setContent(item.getContent());
                    answer.setQuestion(question.get());
                    answer.setStatus(i == 0);
                    answerRepository.save(answer);
        }
        return result;
    }
}
