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
    public void submitButton(View view){


        boolean yesQ1RadioButton = ((RadioButton) findViewById(R.id.yesQ1)).isChecked();
        boolean yesQ2RadioButton = ((RadioButton)findViewById(R.id.yesQ2)).isChecked();
        boolean yesQ4RadioButton = ((RadioButton)findViewById(R.id.yesQ4)).isChecked();
        boolean yesQ5RadioButton = ((RadioButton)findViewById(R.id.yesQ5)).isChecked();



        // Check which radio button was clicked. We only care about yoes.

        // Question 1

        if (yesQ1RadioButton)
            score +=1;

        // Question 2
        if (yesQ2RadioButton)
            score +=1;


        // Question 4
        if (yesQ4RadioButton)
            score +=1;

        // Question 5
        if (yesQ5RadioButton)
            score +=1;

        //Question 3...checkboxes as answers..we only care about checkboxes that are correct
        int correctAnswer = 0;
        //If correctAnswer is three, they get question 3 correct
        boolean checkbox2 = ((CheckBox) findViewById(R.id.thirty_five)).isChecked();
        boolean checkbox3 = ((CheckBox) findViewById(R.id.forty_five)).isChecked();
        boolean checkbox4 = ((CheckBox) findViewById(R.id.fifty_five)).isChecked();

        if (checkbox2)
            correctAnswer += 1;
        if (checkbox3)
            correctAnswer += 1;
        if (checkbox4)
            correctAnswer +=1;

        // If they get all correct boxes checked, add one point to score
        if (correctAnswer == 3){
            score +=1;
        }

        //Question 6...the write in answer
        EditText editText = (EditText)findViewById(R.id.answerQ6);
        String userInput = editText.getText().toString();

        final String userInputModified = userInput.toUpperCase();

        if (userInputModified == "EXECUTIVE ORDER")
            score += 1;

        Toast toast = Toast.makeText(getApplicationContext(),"Your score is " + score + " out of 6 Questions. Thank you.", Toast.LENGTH_LONG);
        toast.show();


    }
    public void resetButton(View view){
    // Everything needs to be cleared.
        score = 0;
        RadioGroup question1RadioButton = (RadioGroup) findViewById(R.id.question1RadioGroup);
        RadioGroup question2RadioButton = (RadioGroup) findViewById(R.id.question2RadioGroup);
        RadioGroup question4RadioButton = (RadioGroup) findViewById(R.id.question4RadioGroup);
        RadioGroup question5RadioButton = (RadioGroup) findViewById(R.id.question5RadioGroup);

        // Uncheck all radio buttons
        question1RadioButton.clearCheck();
        question2RadioButton.clearCheck();
        question4RadioButton.clearCheck();
        question5RadioButton.clearCheck();

        //Uncheck all checkoxes
        CheckBox checkBox2 = (CheckBox)findViewById(R.id.thirty_five);
        CheckBox checkBox3 = (CheckBox)findViewById(R.id.forty_five);
        CheckBox checkBox4 = (CheckBox)findViewById(R.id.fifty_five);

        checkBox2.setChecked(false);
        checkBox3.setChecked(false);
        checkBox4.setChecked(false);

        EditText editText = (EditText)findViewById(R.id.answerQ6);
        editText.setText("");






    }
}
