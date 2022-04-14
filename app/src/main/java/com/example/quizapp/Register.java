package com.example.quizapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.auth.User;

public class Register extends AppCompatActivity {
    FirebaseAuth mAuth;
    DatabaseReference mDatabase;
    EditText email;
    EditText password,confirmpassword;
    Button btnregister;
    EditText name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        email =findViewById(R.id.Email2);
        password=findViewById(R.id.Password2);
        confirmpassword=findViewById(R.id.Password3);
        btnregister=findViewById(R.id.button1);
        name=findViewById(R.id.Name2);

        mAuth = FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance().getReference();

        btnregister.setOnClickListener(view -> {createUser();
        });

    }
    public void createUser(){
        String email1=email.getText().toString();
        String password1=password.getText().toString();
        String name1=name.getText().toString();
        String password2=confirmpassword.getText().toString();
        if(TextUtils.isEmpty(email1)){
            email.setError("Email field is empty");
            email.requestFocus();
        }
        if(TextUtils.isEmpty(password1)){
            password.setError("Password field is empty");
            password.requestFocus();
        }
        if(TextUtils.isEmpty(name1)){
            name.setError("Name field is empty");
            name.requestFocus();
        }
        if(!password2.equals(password1)){
            confirmpassword.setError("Password not equals please check the fields");
            confirmpassword.requestFocus();
        }
        else{
            mAuth.createUserWithEmailAndPassword(email1, password1)
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                String currentUserID = mAuth.getCurrentUser().getUid();
                                Toast.makeText(Register.this, "Account Created", Toast.LENGTH_SHORT).show();
                                com.example.quizapp.User user =new com.example.quizapp.User(name1,email1,password1);
                                mDatabase.child("users").child(currentUserID).setValue(user);
                                startActivity(new Intent(Register.this, Login.class));
                            } else {
                                // If sign in fails, display a message to the user
                                Toast.makeText(Register.this, "Account not Created"+task.getException().getMessage(),
                                        Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
        }
    }
}