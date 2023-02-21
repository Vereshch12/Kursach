package com.example.kursach.service;

import com.example.kursach.model.Question;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class ExaminerServiceImpl implements ExaminerService{
    private final QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    private void generate(Set<Question> examsQuestions){
        Question question = questionService.getRandomQuestion();
        if (examsQuestions.contains(question)){
            generate(examsQuestions);
        }else examsQuestions.add(question);
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        if (amount <= 0 || amount > questionService.getAll().size()){
            throw new RuntimeException();
        }
        Set<Question> examsQuestions = new HashSet<>();
        while (examsQuestions.size() != amount){
            generate(examsQuestions);
        }
        return examsQuestions;
    }
}
