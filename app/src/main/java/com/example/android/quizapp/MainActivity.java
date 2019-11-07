package com.example.android.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int score = 0;
    int combinationCheck = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void submitOrder(View view) {

        score = 0;

//        These are the correct answers which uses ratio buttons...
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

        boolean[] radioButtonAnswers = {choseYellow, choseBlue, choseFour, choseCat, choseTrain};
        checkIfAnswerCorrect(radioButtonAnswers);


//        These are the checkBox combination answers...
        CheckBox angola = (CheckBox) findViewById(R.id.angola_text_view);
        boolean choseAngola = angola.isChecked();

        CheckBox zimbabwe = (CheckBox) findViewById(R.id.zimbabwe_text_view);
        boolean choseZimbabwe = zimbabwe.isChecked();

        CheckBox southAfrica = (CheckBox) findViewById(R.id.soutAfrica_text_view);
        boolean choseSouthAfrica = southAfrica.isChecked();

        CheckBox china = (CheckBox) findViewById(R.id.china_text_view);
        boolean choseChina = china.isChecked();

        CheckBox canada = (CheckBox) findViewById(R.id.canada_text_view);
        boolean choseCanada = canada.isChecked();

        if (choseCanada == false && choseChina == false) {
            boolean[] question5 = {choseAngola, choseZimbabwe, choseSouthAfrica};
            checkCombination(question5);
        } else {
            score = score + 0;
        }



        display(score);
        calculatePercentage(score);
    }

    private  void calculatePercentage(int score){
        double percent;

//        This is the final percentage rounded of to 2 decimal places...
        percent = ((double) score) / 6 * 100;
        displayPercentage((double) Math.round(percent * 100) / 100);
    }

    private void checkCombination(boolean[] combination){
        combinationCheck = 0;

        for (int i = 0; i < combination.length; i++){
            if (combination[i] == true){
                combinationCheck = combinationCheck + 1;
            } else {
                combinationCheck = combinationCheck + 0;
            }
        }

        if(combinationCheck == 3){
            score = score + 1;
        } else {
            score = score + 0;
        }
    }

    private  void checkIfAnswerCorrect(boolean[] ans){
        for (int i = 0; i < ans.length; i++){
            if(ans[i]== true){
                score = score + 1;
            } else {
                score = score + 0;
            }
        }
    }

    private void displayPercentage(double percentage){
        TextView percentTextView = (TextView) findViewById(R.id.percent_text_view);
        percentTextView.setText("" + percentage + "%");
    }

    private void display(int number) {
        TextView scoreTextView = (TextView) findViewById(R.id.score_text_view);
        scoreTextView.setText("" + number);
    }

}
