package com.example.truefalsequiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.google.gson.Gson;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "MainActivity";

    private Quiz quiz;
    private TextView textviewQuestions;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        InputStream stream = getResources().openRawResource(R.raw.questions); // getting XML

        String jsonString = readTextFile(stream);

        Log.d(TAG, "onCreate: " + jsonString);

// create a gson object
        Gson gson = new Gson();
// read your json file into an array of questions
        Question[] questions =  gson.fromJson(jsonString, Question[].class);
// convert your array to a list using the Arrays utility class
        List<Question> questionList = Arrays.asList(questions);
// verify that it read everything properly
        Log.d(TAG, "onCreate: " + questionList.toString());
    }

    private String readTextFile(InputStream stream) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        byte buf[] = new byte[1024];
        int len;
        try {
            while ((len = stream.read(buf)) != -1) {
                outputStream.write(buf, 0, len);
            }
            outputStream.close();
            stream.close();
        } catch (IOException e) {

        }
        return outputStream.toString();
    }





}
