package com.example.kursach.controller;


import com.example.kursach.ExceptionQuestion;
import com.example.kursach.model.Question;
import com.example.kursach.service.QuestionService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("exam/java")
public class JavaQuestionController {
    private final QuestionService questionService;

    public JavaQuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @RequestMapping("/add")
    public Question add(@RequestParam("question") String question, @RequestParam("answer") String answer) throws ExceptionQuestion {
        return questionService.add(question, answer);
    }

    @RequestMapping("/remove")
    public Question remove(@RequestParam("question") String question, @RequestParam("answer") String answer){
        return questionService.remove(new Question(question, answer));
    }

    @RequestMapping
    public Collection<Question> getAll() {
        return questionService.getAll();
    }
}
