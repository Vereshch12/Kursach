package com.example.kursach.service;

import com.example.kursach.ExceptionQuestion;
import com.example.kursach.model.Question;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ExaminerServiceImpl implements ExaminerService{
    private final List<QuestionService> questionService;

    public ExaminerServiceImpl(@Qualifier("javaQuestionService") QuestionService questionService) {
        this.questionService = List.of(questionService);
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        if (amount > questionService.size() || amount <=0) {
            throw new ExceptionQuestion("Количество вопросов превышает количество вопросов в списке");
        }
        Set<Question> questions = new HashSet<>();
        while (questions.size() < amount){
            questions.add(questionService.get(amount).getRandomQuestion());
        }
        return questions;
    }
}
