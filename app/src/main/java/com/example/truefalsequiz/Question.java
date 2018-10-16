package com.example.truefalsequiz;

class Question {
    private String question;
    private boolean answer;

    public Question(String question) {
        this.question = question;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public boolean isAnswer() {
        return answer;
    }

    public void setAnswer(boolean answer) {
        this.answer = answer;
    }

    public boolean checkAnswer(boolean answer){
        if(answer == this.answer) {
            return true;
        }
        else{
            return false;
        }
    }
}
