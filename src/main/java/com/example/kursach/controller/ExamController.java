package com.example.kursach.controller;

import com.example.kursach.model.Question;
import com.example.kursach.service.ExaminerService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("exam/java")
public class ExamController {
    private final ExaminerService examinerService;

    public ExamController(ExaminerService examinerService) {
        this.examinerService = examinerService;
    }

    @RequestMapping("/exam")
    public Collection<Question> getQuestions(@RequestParam("amount") int amount){
        return examinerService.getQuestions(amount);
    }
}
