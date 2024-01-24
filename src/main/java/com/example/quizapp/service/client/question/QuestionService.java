package com.example.quizapp.service.client.question;

import com.example.quizapp.model.Question;
import com.example.quizapp.repository.AnswerRepository;
import com.example.quizapp.repository.QuestionRepository;
import com.example.quizapp.service.client.answer.response.AnswerResponse;
import com.example.quizapp.service.client.question.response.QuestionResponse;
import com.example.quizapp.util.AppUtils;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
@AllArgsConstructor
public class QuestionService {

    private final QuestionRepository questionRepository;
    private final AnswerRepository answerRepository;

    public List<QuestionResponse> findAllByQuizId(Long id) {
        List<QuestionResponse> result = new ArrayList<>();
        var questions = questionRepository.findQuestionByQuizQ_Id(id);
        if(questions.size() <= 3){
            for (var question : questions) {
                result.add(mapQuestionWithAnswers(question));
            }
        }
        else {
            List<Question> randomQuestions = new ArrayList<>(questions);
            Collections.shuffle(randomQuestions);
            for(int i = 0 ; i < 3 ; i++){
                result.add(mapQuestionWithAnswers(randomQuestions.get(i)));
            }
        }
        return result;
    }

    private QuestionResponse mapQuestionWithAnswers(Question question) {
        var questionResponse = AppUtils.mapper.map(question, QuestionResponse.class);
        var answers = answerRepository.findAnswerByQuestion_Id(question.getId());
        for (var answer : answers) {
            var answerResponse = AppUtils.mapper.map(answer, AnswerResponse.class);
            questionResponse.getAnswerList().add(answerResponse);
        }
        return questionResponse;
    }
}


