package com.example.ryan.thepowerofthepresident;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class WhatCanHeSheDo extends AppCompatActivity {
    int score;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_what_can_he_she_do);

    }

    public void submitButton(View view) {
        //Just in case of resubmitting the quiz answers without resetting, score should reset to zero
        score = 0;

        boolean yesQ1RadioButton = ((RadioButton) findViewById(R.id.noQ1)).isChecked();
        boolean yesQ2RadioButton = ((RadioButton) findViewById(R.id.yesQ2)).isChecked();
        boolean yesQ4RadioButton = ((RadioButton) findViewById(R.id.noQ4)).isChecked();
        boolean yesQ5RadioButton = ((RadioButton) findViewById(R.id.yesQ5)).isChecked();

        // Check which radio button was clicked. We only care about the correct answers. If the correct yes or no is clicked by the user, then the boolean should be true, which leads to an extra point.

        // Question 1

        if (yesQ1RadioButton)
            score += 1;

        // Question 2
        if (yesQ2RadioButton)
            score += 1;

        // Question 4
        if (yesQ4RadioButton)
            score += 1;

        // Question 5
        if (yesQ5RadioButton)
            score += 1;

        //Question 3...checkboxes as answers..we only care about checkboxes that are correct
        int correctAnswer = 0;
        //If correctAnswer is three (get all the checkboxes correct), they get question 3 right, which results to one extra point toward the user score
        boolean checkbox2 = ((CheckBox) findViewById(R.id.thirty_five)).isChecked();
        boolean checkbox3 = ((CheckBox) findViewById(R.id.forty_five)).isChecked();
        boolean checkbox4 = ((CheckBox) findViewById(R.id.fifty_five)).isChecked();

        if (checkbox2)
            correctAnswer += 1;
        if (checkbox3)
            correctAnswer += 1;
        if (checkbox4)
            correctAnswer += 1;

        // If they get all correct boxes checked, add one point to score
        if (correctAnswer == 3) {
            score += 1;
        }

        //Question 6...the write in answer
        EditText editText = (EditText) findViewById(R.id.answerQ6);
        String userInput = editText.getText().toString().toUpperCase();

        // I hope line 74 is not Plagiarism. The code is not copied, but I learned about the "toUpperCase" long ago on stack Overflow before the class started, and I can not remember the exact source.

        if (userInput.equals("EXECUTIVE ORDER")) {

            score += 1;

        }

        //DISPLAY FINAL SCHORE

        Toast toast = Toast.makeText(getApplicationContext(), "Your score is " + score + " out of 6 Questions. Thank you.", Toast.LENGTH_LONG);
        toast.show();


    }

    public void resetButton(View view) {
        // Everything needs to be cleared.

        // Score is 0 again.
        score = 0;
        RadioGroup question1RadioGroup = (RadioGroup) findViewById(R.id.question1RadioGroup);
        RadioGroup question2RadioGroup = (RadioGroup) findViewById(R.id.question2RadioGroup);
        RadioGroup question4RadioGroup = (RadioGroup) findViewById(R.id.question4RadioGroup);
        RadioGroup question5RadioGroup = (RadioGroup) findViewById(R.id.question5RadioGroup);

        // Uncheck all radio buttons
        question1RadioGroup.clearCheck();
        question2RadioGroup.clearCheck();
        question4RadioGroup.clearCheck();
        question5RadioGroup.clearCheck();

        //Uncheck all checkoxes
        CheckBox checkBox2 = (CheckBox) findViewById(R.id.thirty_five);
        CheckBox checkBox3 = (CheckBox) findViewById(R.id.forty_five);
        CheckBox checkBox4 = (CheckBox) findViewById(R.id.fifty_five);

        checkBox2.setChecked(false);
        checkBox3.setChecked(false);
        checkBox4.setChecked(false);

        EditText editText = (EditText) findViewById(R.id.answerQ6);
        editText.setText("");

    }
}
