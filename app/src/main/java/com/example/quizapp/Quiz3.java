package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Quiz3 extends AppCompatActivity {
    //Set 1 : Declaration
    Button bNext;
    RadioGroup rg3;
    RadioButton rb3;
    String RepCorrect3="Non";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz3);

        //Set 2 : Recuperation des Id
        rg3 = (RadioGroup) findViewById(R.id.rg3);
        bNext=(Button) findViewById(R.id.bNext);

        //Set 3 : Association des listeners

        bNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (rg3.getCheckedRadioButtonId()==-1){
                    Toast.makeText(getApplicationContext(), "Merci de choisir une réponse svp !", Toast.LENGTH_SHORT).show();
                }

                else {
                    //Set 3 : Association des listeners
                    rb3 = (RadioButton) findViewById(rg3.getCheckedRadioButtonId());
                    if (rb3.getText().toString().equals(RepCorrect3)){
                        Quiz1.score+=1;
                    }
                    Intent intent = new Intent(Quiz3.this,quiz4.class);
                    intent.putExtra("score",Quiz1.score);
                    startActivity(intent);
                    overridePendingTransition(R.anim.exit,R.anim.entry);
                    finish();
                }
            }
        });
    }
}