package com.example.kursach.service;

import com.example.kursach.ExceptionQuestion;
import com.example.kursach.model.Question;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@Service
public class JavaQuestionService implements QuestionService {
    private Set<Question> allQuestions;

    public JavaQuestionService(Set<Question> allQuestions) {
        this.allQuestions = allQuestions;
    }

    @Override
    public Question add(String question, String answer) throws ExceptionQuestion {
        if (question == null || question.isBlank() || answer.isBlank() || answer == null)
            throw new ExceptionQuestion("Чтобы добавить добавить вопрос, необходимо не оставлять поля вопроса и ответа пустыми!");
        Question questionAndAnswer = new Question(question, answer);
        return add(questionAndAnswer);
    }

    @Override
    public Question add(Question question) {
        allQuestions.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        allQuestions.remove(question);
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return allQuestions;
    }

    @Override
    public Question getRandomQuestion() {
        Random random = new Random();
        int index = random.nextInt(allQuestions.size());
        int i = 0;
        while (i != index){
            allQuestions.iterator().next();
            i++;
        }
        return allQuestions.iterator().next();
    }
}
