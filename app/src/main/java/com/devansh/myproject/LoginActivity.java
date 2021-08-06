package com.devansh.myproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText etEmail;
    EditText etPassword;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        binding();
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onLogin();
            }
        });
    }

    private void binding() {
        etEmail = findViewById(R.id.et_email);
        etPassword = findViewById(R.id.et_password);
        btnLogin = findViewById(R.id.btn_login);
    }

    private  void onLogin() {
        String email = String.valueOf(etEmail.getText());
        String password = String.valueOf(etPassword.getText());
        if ( email.equals("devansh") && password.equals("Hrhk@1234")) {
            startActivity(new Intent(this,MainActivity.class));
        } else {
            Toast.makeText(this,"Invalid email or password",Toast.LENGTH_SHORT).show();
        }

    }

}