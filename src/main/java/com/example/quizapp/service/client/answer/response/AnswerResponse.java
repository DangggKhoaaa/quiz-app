package com.example.quizapp.service.client.answer.response;

import com.example.quizapp.service.client.file.response.FileResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AnswerResponse {
    private Long id;
    private String content;
    private List<FileResponse> files = new ArrayList<>();
}
