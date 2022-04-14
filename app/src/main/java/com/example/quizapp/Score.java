package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class Score extends AppCompatActivity {
    //Set 1 : Declaration
    Button bLogout, bTry;
    ProgressBar progressBar;
    TextView tvScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        //Set 2 : Recuperation des Id
        bTry = (Button) findViewById(R.id.bTry);
        bLogout = (Button) findViewById(R.id.bLogout);
        tvScore = (TextView) findViewById(R.id.tvScore);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        Intent intent=getIntent();

        Quiz1.score=intent.getIntExtra("score",0) ;
        progressBar.setProgress(100*Quiz1.score/4);
        tvScore.setText(100*Quiz1.score/4+" %");

        //Set 3 : Association des listeners
        bLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(Score.this,Login.class));
                finish();
            }
        });

        bTry.setOnClickListener(new View.OnClickListener() {
            //Set 4 : Treatment
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Score.this,Quiz1.class));
                finish();
            }
        });

    }
}