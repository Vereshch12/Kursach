package com.example.kursach.service;

import com.example.kursach.ExceptionQuestion;
import com.example.kursach.model.Question;

import java.util.Collection;

public interface ExaminerService {
    Collection<Question> getQuestions(int amount);
}
