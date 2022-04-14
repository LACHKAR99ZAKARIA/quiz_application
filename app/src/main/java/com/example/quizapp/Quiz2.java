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

public class Quiz2 extends AppCompatActivity {
    //Set 1 : Declaration
    Button bNext;
    RadioGroup rg2;
    RadioButton rb2;
    String RepCorrect2="À droite";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz2);

        //Set 2 : Recuperation des Id
        rg2 = (RadioGroup) findViewById(R.id.rg2);
        bNext=(Button) findViewById(R.id.bNext);

        //Set 3 : Association des listeners

        bNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (rg2.getCheckedRadioButtonId()==-1){
                    Toast.makeText(getApplicationContext(), "Merci de choisir une réponse svp !", Toast.LENGTH_SHORT).show();
                }

                else {
                    //Set 3 : Association des listeners
                    rb2 = (RadioButton) findViewById(rg2.getCheckedRadioButtonId());
                    if (rb2.getText().toString().equals(RepCorrect2)){
                        Quiz1.score+=1;
                    }
                    Intent intent = new Intent(Quiz2.this,Quiz3.class);
                    intent.putExtra("score",Quiz1.score);
                    startActivity(intent);
                    overridePendingTransition(R.anim.exit,R.anim.entry);
                    finish();
                }
            }
        });
    }
}