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

public class quiz4 extends AppCompatActivity {
    //Set 1 : Declaration
    Button bNext;
    RadioGroup rg4;
    RadioButton rb4;
    String RepCorrect="Le tramway est arrêté";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz4);

        //Set 2 : Recuperation des Id
        rg4 = (RadioGroup) findViewById(R.id.rg4);
        bNext=(Button) findViewById(R.id.bNext);

        //Set 3 : Association des listeners

        bNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (rg4.getCheckedRadioButtonId()==-1){
                    Toast.makeText(getApplicationContext(), "Merci de choisir une réponse svp !", Toast.LENGTH_SHORT).show();
                }

                else {
                    //Set 3 : Association des listeners
                    rb4 = (RadioButton) findViewById(rg4.getCheckedRadioButtonId());
                    if (rb4.getText().toString().equals(RepCorrect)){
                        Quiz1.score+=1;
                    }
                    Intent intent = new Intent(quiz4.this,Score.class);
                    intent.putExtra("score",Quiz1.score);
                    startActivity(intent);
                    overridePendingTransition(R.anim.exit,R.anim.entry);
                    finish();
                }
            }
        });
    }
}