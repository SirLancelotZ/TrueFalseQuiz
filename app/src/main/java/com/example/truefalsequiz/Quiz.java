package com.example.truefalsequiz;

import java.util.List;

public class Quiz {
    private int score;
    private int currentQuestion;
    private int questionIndex;
    private List<Question> questions;

    public Quiz(List<Question> questions) {
        score = 0;
        currentQuestion = 0;
        questionIndex = 1;
        this.questions = questions;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Question getCurrentQuestion() {
        return questions.get(currentQuestion);
    }

    public void setCurrentQuestion(int currentQuestion) {
        this.currentQuestion = currentQuestion;
    }

    public int getQuestionIndex(){
        return questionIndex;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public int getNextQuestion() {
        currentQuestion++;
        questionIndex = currentQuestion +1;
        return currentQuestion;
    }

    public void nextQuestion(){
        if(isThereAnotherQuestion()){
            currentQuestion++;
            questionIndex = currentQuestion +1;
        }
    }

    public boolean isThereAnotherQuestion() {
        if(currentQuestion < questions.size() -1){
            return true;
        }
        else
            {
            return false;
        }

    }

}
