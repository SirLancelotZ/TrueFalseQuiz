package com.example.truefalsequiz;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.Gson;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String TAG = "QuizActivity";

    private TextView textViewQuestionNumber;
    private TextView textViewQuestion;
    private Button buttonTrue;
    private Button buttonFalse;
    private Quiz quiz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        wireWidgets();
        setListeners();
        InputStream JSONFileInputStream = getResources().openRawResource(R.raw.questions);
        String sJSON = readTextFile(JSONFileInputStream);

        Gson gson = new Gson();
        // read your json file into an array of questions
        Question[] questions = gson.fromJson(sJSON, Question[].class);
        // convert your array to a list using the Arrays utility class
        List<Question> questionList = Arrays.asList(questions);

        quiz = new Quiz(0, 1, questionList);

        textViewQuestionNumber.setText(quiz.getCurrentQuestion() + "");
        textViewQuestion.setText(quiz.getQuestions().get(0).getQuestion());

    }

    private void setListeners() {
        buttonFalse.setOnClickListener(this);
        buttonTrue.setOnClickListener(this);
    }

    private void wireWidgets() {
        textViewQuestionNumber = findViewById(R.id.textView_quiz_questionNumber);
        textViewQuestion = findViewById(R.id.textView_quiz_question);
        buttonTrue = findViewById(R.id.button_quiz_true);
        buttonFalse = findViewById(R.id.button_quiz_false);
    }



    public String readTextFile(InputStream inputStream) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        byte buf[] = new byte[1024];
        int len;
        try {
            while ((len = inputStream.read(buf)) != -1) {
                outputStream.write(buf, 0, len);
            }
            outputStream.close();
            inputStream.close();
        } catch (IOException e) {

        }
        return outputStream.toString();
    }

    public void onClick(View view) {
        switch(view.getId()){
            case R.id.button_quiz_false:

        }
    }
}