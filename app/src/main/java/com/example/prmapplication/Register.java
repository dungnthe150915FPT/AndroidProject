package com.example.prmapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.prmapplication.Handler.AccountDBContext;
import com.example.prmapplication.Models.Account;

public class Register extends AppCompatActivity {
    private TextView username, email,password,phone,btnAlreadyAccount;
    private Button btnsignup;
    private AccountDBContext DB;
    public void bindingView(){
        username = findViewById(R.id.username);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        phone = findViewById(R.id.phone);
        btnsignup = findViewById(R.id.btnSignUp);
        btnAlreadyAccount = findViewById(R.id.alreadyHaveAccount);
        DB = new AccountDBContext(this);
    }
    public void bindingAction(){
        btnAlreadyAccount.setOnClickListener(this::onAlreadyAccountClick);
        btnsignup.setOnClickListener(this::btnSignUpClick);
    }
    public void btnSignUpClick(View v) {

        String User = username.getText().toString();
        String Pass = password.getText().toString();
        String Email = email.getText().toString();
        String Phone = phone.getText().toString();

        if (User.equals("") || Pass.equals("") || Email.equals("") || Phone.equals(""))
            Toast.makeText(Register.this, "Vui lòng nhập đầy đủ thông tin!", Toast.LENGTH_SHORT).show();
        else {
            // Tạo đối tượng Account từ các giá trị
            Account account = new Account(username, password, email, phone);

            // Thêm thông tin người dùng vào cơ sở dữ liệu
            boolean result = DB.addAccount(account);
            if (result) {
                Toast.makeText(Register.this, "Đăng ký thành công!", Toast.LENGTH_SHORT).show();
                // Thực hiện hành động sau khi đăng ký thành công
            } else {
                Toast.makeText(Register.this, "Đăng ký thất bại!", Toast.LENGTH_SHORT).show();
            }
        }
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