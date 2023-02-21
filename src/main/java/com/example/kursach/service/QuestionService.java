package com.example.kursach.service;

import com.example.kursach.ExceptionQuestion;
import com.example.kursach.model.Question;

import java.util.Collection;

public interface QuestionService {

    Question add(String question, String answer) throws ExceptionQuestion;

    Question add(Question question);

    Question remove(Question question);

    Collection<Question> getAll();

    Question getRandomQuestion();


}
