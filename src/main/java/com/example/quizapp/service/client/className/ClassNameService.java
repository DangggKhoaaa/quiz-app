package com.example.quizapp.service.client.className;

import com.example.quizapp.model.ClassName;
import com.example.quizapp.repository.ClassNameRepository;
import com.example.quizapp.service.client.className.response.ClassNameListResponse;
import com.example.quizapp.util.AppUtils;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ClassNameService {
    private final ClassNameRepository classNameRepository;

    public List<ClassNameListResponse> findAll (){
        List<ClassNameListResponse> result = new ArrayList<>();
        for(var item : classNameRepository.findAll()){
            ClassNameListResponse classNameListResponse = AppUtils.mapper.map(item , ClassNameListResponse.class);
            result.add(classNameListResponse);
        }
        return  result;
    }
}
