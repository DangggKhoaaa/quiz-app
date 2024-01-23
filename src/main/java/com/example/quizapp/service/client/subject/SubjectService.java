package com.example.quizapp.service.client.subject;

import com.example.quizapp.repository.SubjectRepository;
import com.example.quizapp.service.client.subject.request.SubjectListRequest;
import com.example.quizapp.service.client.subject.response.SubjectListResponse;
import com.example.quizapp.util.AppUtils;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class SubjectService {
    private final SubjectRepository subjectRepository;

    public List<SubjectListResponse> findAllByClassId(Long id){
        List<SubjectListResponse> result = new ArrayList<>();
        var subjects = subjectRepository.findSubjectByClassName_Id(id);
        for(var item : subjects){
            SubjectListResponse subjectList = AppUtils.mapper.map(item , SubjectListResponse.class);
            result.add(subjectList);
        }
        return result;
    }
}
