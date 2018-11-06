package com.example.truefalsequiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class ScoreActivity extends AppCompatActivity {

    private Button playAgain;
    private TextView textViewScore;
    private TextView textViewCompletion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        wireWidgets();

        textViewCompletion.setText(R.string.score_completion);

        //String newString;

        //Intent receiveIntent = getIntent();
        //Bundle score = receiveIntent.getExtras();
        //String score = receiveIntent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        //textViewScore.setText(getString(R.string.yourscore) + score);

        //newString = score.getString(MainActivity.EXTRA_MESSAGE);
        //textViewScore.setText(getIntent().getStringExtra(MainActivity.EXTRA_MESSAGE));
        textViewScore.setText(getIntent().getStringExtra(MainActivity.EXTRA_MESSAGE));

    }

    private void wireWidgets() {
        textViewCompletion = findViewById(R.id.textView_score_completion);
        textViewScore = findViewById(R.id.textView_score_score);
        playAgain = findViewById(R.id.button_score_playagain);
    }
}
