package com.devansh.myproject.login;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.devansh.myproject.R;
import com.devansh.myproject.home.HomeActivity;
import com.devansh.myproject.registration.RegistrationActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    EditText etEmail;
    EditText etPassword;
    Button btnLogin;
    Button btnRegister;
    Button btnSkip;
    ProgressBar progressBar;
    FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        binding();
        mAuth = FirebaseAuth.getInstance();
        btnLogin.setOnClickListener(v -> onLogin());
        btnRegister.setOnClickListener(v -> register());
        btnSkip.setOnClickListener(view -> skip());
//        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                skip();
//            }
//        },1000);

    }

    private void skip() {
        progressBar.setVisibility(View.VISIBLE);
        startActivity(new Intent(this, HomeActivity.class));
        finish();
        progressBar.setVisibility(View.GONE);
    }

    private void register() {
//        Toast.makeText(this, "This Feature is currently not available", Toast.LENGTH_SHORT).show();
        progressBar.setVisibility(View.VISIBLE);
        Intent intent = new Intent(this, RegistrationActivity.class);
        startActivity(intent);
        finish();
        progressBar.setVisibility(View.GONE);
    }

    private void binding() {
        etEmail = findViewById(R.id.et_email);
        etPassword = findViewById(R.id.et_password);
        btnLogin = findViewById(R.id.btn_login);
        btnRegister = findViewById(R.id.btn_register);
        btnSkip = findViewById(R.id.btn_skip);
        progressBar =findViewById(R.id.progress_bar);
        progressBar = new ProgressBar(this);
    }

    private void onLogin() {
        progressBar.setVisibility(View.VISIBLE);
        String email = String.valueOf(etEmail.getText());
        String password = String.valueOf(etPassword.getText());
        if (email.isEmpty()) {
            Toast.makeText(getApplicationContext(),"Please enter email address",Toast.LENGTH_SHORT).show();
        } else if(password.isEmpty()) {
            Toast.makeText(getApplicationContext(),"Please enter a password",Toast.LENGTH_SHORT).show();
        } else {
            mAuth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener(
                            new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task)
                                {
                                    if (task.isSuccessful()) {
//                                        Toast.makeText(getApplicationContext(),"Login successful!!",Toast.LENGTH_LONG).show();
                                        Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                                        startActivity(intent);
                                        finish();
                                    } else {
                                        Toast.makeText(getApplicationContext(),"Login failed!!",Toast.LENGTH_LONG).show();
                                    }
                                    progressBar.setVisibility(View.GONE);

                                }
                            });
        }
    }
}