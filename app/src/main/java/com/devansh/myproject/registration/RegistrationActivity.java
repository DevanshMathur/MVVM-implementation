package com.devansh.myproject.registration;

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
import com.devansh.myproject.login.LoginActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegistrationActivity extends AppCompatActivity {

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
        setContentView(R.layout.activity_registration);
        mAuth = FirebaseAuth.getInstance();
        binding();
        btnLogin.setOnClickListener(v -> onLogin());
        btnRegister.setOnClickListener(v -> register());
        btnSkip.setOnClickListener(view -> skip());
    }

    private void skip() {
        progressBar.setVisibility(View.VISIBLE);
        startActivity(new Intent(this, HomeActivity.class));
        finish();
        progressBar.setVisibility(View.GONE);
    }

    private void register() {
        progressBar.setVisibility(View.VISIBLE);
        String email = String.valueOf(etEmail.getText());
        String password = String.valueOf(etPassword.getText());
        if (email.isEmpty()) {
            Toast.makeText(getApplicationContext(), "Please enter email address", Toast.LENGTH_SHORT).show();
        } else if (password.isEmpty()) {
            Toast.makeText(getApplicationContext(), "Please enter a password", Toast.LENGTH_SHORT).show();
        } else {
            mAuth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                //                                Toast.makeText(getApplicationContext(),"Registration successful!",Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(RegistrationActivity.this, HomeActivity.class);
                                startActivity(intent);
                                finish();
                            } else {
                                Toast.makeText(getApplicationContext(),
                                        "Registration failed!!" + " Please try again later",
                                        Toast.LENGTH_LONG)
                                        .show();
                            }
                            progressBar.setVisibility(View.GONE);
                        }
                    });
        }
    }

    private void binding() {
        etEmail = findViewById(R.id.et_email);
        etPassword = findViewById(R.id.et_password);
        btnLogin = findViewById(R.id.btn_login);
        btnRegister = findViewById(R.id.btn_register);
        btnSkip = findViewById(R.id.btn_skip);
        progressBar = findViewById(R.id.progress_bar);
        progressBar = new ProgressBar(this);
    }

    private void onLogin() {
        progressBar.setVisibility(View.VISIBLE);
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
        finish();
        progressBar.setVisibility(View.GONE);
    }
}