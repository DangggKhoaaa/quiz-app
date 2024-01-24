package com.example.quizapp.service.client.quiz;

import com.example.quizapp.model.Question;
import com.example.quizapp.model.Quiz;
import com.example.quizapp.repository.*;
import com.example.quizapp.service.client.answer.response.AnswerResponse;
import com.example.quizapp.service.client.question.response.QuestionResponse;
import com.example.quizapp.service.client.quiz.response.QuizListResponse;
import com.example.quizapp.util.AppUtils;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.nio.file.OpenOption;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class QuizService {
    private final ClassNameRepository classNameRepository;
    private final SubjectRepository subjectRepository;
    private final QuizRepository quizRepository;
    private final QuestionRepository questionRepository;
    private final AnswerRepository answerRepository;

    public List<QuizListResponse> findAllBySubjectId(Long id) {
        List<QuizListResponse> result = new ArrayList<>();
        var quizList = quizRepository.findQuizBySubject_Id(id);
        for(var quiz : quizList){
            var quizListResponse = AppUtils.mapper.map(quiz, QuizListResponse.class);
            result.add(quizListResponse);
        }
        return result;
    }

//    public List<QuizListResponse> findQuizByClass () {
//        List<QuizListResponse> result = new ArrayList<>();
//        var subject = subjectRepository.findById(1L);
//        var quizList = quizRepository.findQuizBySubject_Id(subject.get().getId());
//        for(var quiz : quizList){
//            var quizListResponse = AppUtils.mapper.map(quiz , QuizListResponse.class);
//            var questions = questionRepository.findQuestionByQuizQ_Id(quiz.getId());
//            for(var question : questions){
//                var questionResponse = AppUtils.mapper.map(question, QuestionResponse.class);
//                var answers = answerRepository.findAnswerByQuestion_Id(question.getId());
//                for(var answer : answers){
//                    var answerResponse = AppUtils.mapper.map(answer, AnswerResponse.class);
//                    questionResponse.getAnswerResponseList().add(answerResponse);
//                }
//            }
//            result.add(quizListResponse);
//        }
//        return result;
//    }
}
