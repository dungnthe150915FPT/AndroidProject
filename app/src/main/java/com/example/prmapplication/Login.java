package com.example.prmapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;
import com.google.android.material.button.MaterialButton;

import org.w3c.dom.Text;

public class Login extends AppCompatActivity {
    private TextView username;
    private TextView password;
    private TextView btnSignUp;
    private MaterialButton btnLogin;

    public void bindingView(){
        btnSignUp= findViewById(R.id.textViewSignUp);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        btnLogin = findViewById(R.id.loginbtn);
    }

    public void bindingAction() {
        btnLogin.setOnClickListener(this::onLoginClick);
        btnSignUp.setOnClickListener(this::onSignUpClick);
    }
    private void onLoginClick(View v) {
        if(username.getText().toString().equals("admin") && password.getText().toString().equals("admin")){
            //correct
            Toast.makeText(Login.this,"LOGIN SUCCESSFUL",Toast.LENGTH_SHORT).show();
        }else
            //incorrect
            Toast.makeText(Login.this,"LOGIN FAILED !!!",Toast.LENGTH_SHORT).show();
    }
    public void onSignUpClick(View v) {
        startActivity(new Intent(Login.this,Register.class));
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        bindingView();
        bindingAction();
    }
}