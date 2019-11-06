package com.example.android.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int score = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void submitOrder(View view) {

        score = 0;

        RadioButton yellow = (RadioButton) findViewById(R.id.radio_yellow);
        boolean choseYellow = yellow.isChecked();

        RadioButton blue = (RadioButton) findViewById(R.id.radio2_blue);
        boolean choseBlue = blue.isChecked();

        RadioButton four = (RadioButton) findViewById(R.id.radio3_four);
        boolean choseFour = four.isChecked();

        RadioButton cat = (RadioButton) findViewById(R.id.radio4_cat);
        boolean choseCat = cat.isChecked();

        RadioButton train = (RadioButton) findViewById(R.id.radio5_train);
        boolean choseTrain = train.isChecked();

        if(choseYellow){
            score = score + 1;
        } else {
            score = score + 0;
        }

        if(choseBlue){
            score = score + 1;
        } else {
            score = score + 0;
        }

        if(choseCat){
            score = score + 1;
        } else {
            score = score + 0;
        }

        if(choseFour){
            score = score + 1;
        } else {
            score = score + 0;
        }

        if(choseTrain){
            score = score + 1;
        } else {
            score = score + 0;
        }

        display(score);
    }

    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.score_text_view);
        quantityTextView.setText("" + number);
    }

}
