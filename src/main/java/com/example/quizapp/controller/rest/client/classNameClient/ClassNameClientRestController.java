package com.example.quizapp.controller.rest.client.classNameClient;

import com.example.quizapp.model.ClassName;
import com.example.quizapp.service.client.className.ClassNameService;
import com.example.quizapp.service.client.className.response.ClassNameListResponse;
import lombok.AllArgsConstructor;
import org.modelmapper.internal.bytebuddy.asm.Advice;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/client/classes")

public class ClassNameClientRestController {
    private final ClassNameService classNameService;
    @GetMapping
    public List<ClassNameListResponse> findAll() {
        return classNameService.findAll();

    }
}
