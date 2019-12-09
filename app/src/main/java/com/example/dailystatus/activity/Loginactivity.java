package com.example.dailystatus.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.dailystatus.R;

public class Loginactivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final EditText etEmail = findViewById(R.id.etEmail);
        final EditText etPassword = findViewById(R.id.etPassword);
        Button btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strEmail = etEmail.getText().toString().trim();
                String strPasswrd = etPassword.getText().toString().trim();

                if (strEmail.equals("admin") && strPasswrd.equals("pass")) {
                    Log.d("Login",strEmail.toString());
                    Intent intent = new Intent(getApplicationContext(), Summaryactivity.class);
                    startActivity(intent);
                } else if (strEmail.equals("parent") && strPasswrd.equals("stud")) {
                    Intent intent = new Intent(getApplicationContext(), Parentactivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(getApplicationContext(), "Invalid Credentials", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
