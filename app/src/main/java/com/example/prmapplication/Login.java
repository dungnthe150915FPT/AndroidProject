package com.example.prmapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;

import com.example.prmapplication.Fragment.HomeFragment;
import com.example.prmapplication.Handler.AccountDBContext;
import com.google.android.material.button.MaterialButton;

import org.w3c.dom.Text;

public class Login extends AppCompatActivity {
    private TextView username,password,btnSignUp;
    private MaterialButton btnLogin;

    AccountDBContext DB;

    public void bindingView(){
        btnSignUp= findViewById(R.id.textViewSignUp);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        btnLogin = findViewById(R.id.loginbtn);
        DB = new AccountDBContext(this);
    }

    public void bindingAction() {
        btnLogin.setOnClickListener(this::onLoginClick);
        btnSignUp.setOnClickListener(this::onSignUpClick);
    }
    private void onLoginClick(View v) {
        String user = username.getText().toString();
        String pass = password.getText().toString();

        if (user.equals("")||pass.equals(""))
            Toast.makeText(Login.this,"Tên người dùng hoặc mật khẩu không được để trống",Toast.LENGTH_SHORT).show();
        else{
            boolean checkuserpass = DB.checkUser(user,pass);
             if(checkuserpass == true){
            //correct
                 Intent intent = new Intent(Login.this, HomeFragment.class);
                 startActivity(intent);
             Toast.makeText(Login.this,"Đăng nhập thành công!",Toast.LENGTH_SHORT).show();
             }else
            //incorrect
            Toast.makeText(Login.this,"Tên người dùng hoặc mật khẩu không đúng!",Toast.LENGTH_SHORT).show();
             }
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