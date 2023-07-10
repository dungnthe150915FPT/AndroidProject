package com.example.prmapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
public class Register extends AppCompatActivity {
    private TextView username;
    private TextView email;
    private TextView password;
    private TextView repassword;
    private Button btnsignup;

    private TextView btnAlreadyAccount;

    public void bindingView(){
        username = findViewById(R.id.username);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        repassword = findViewById(R.id.repassword);
        btnsignup = findViewById(R.id.btnSignUp);
        btnAlreadyAccount = findViewById(R.id.alreadyHaveAccount);
    }
    public void bindingAction(){
        btnAlreadyAccount.setOnClickListener(this::onAlreadyAccountClick);
        btnsignup.setOnClickListener(this::btnSignUpClick);
    }
    public void btnSignUpClick(View v) {
        String User = username.getText().toString();
        Toast.makeText(Register.this,"Username is"+User,Toast.LENGTH_SHORT).show();
    }
    public void onAlreadyAccountClick(View v) {
        startActivity(new Intent(Register.this, Login.class));
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        bindingView();
        bindingAction();
    }
}