package com.example.quizapp.controller.rest.client.subjectClient;

import com.example.quizapp.service.client.subject.SubjectService;
import com.example.quizapp.service.client.subject.request.SubjectListRequest;
import com.example.quizapp.service.client.subject.response.SubjectListResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/client/subjects")
public class SubjectClientRestController {
    private final SubjectService subjectService;

    @GetMapping("/{id}")
    public List<SubjectListResponse> findAllByClassId(@PathVariable Long id) {
        return subjectService.findAllByClassId(id);
    }

}
