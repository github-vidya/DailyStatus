package com.example.dailystatus.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.dailystatus.R;

public class Parentactivity  extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parent);
    }


    public void processLogoutLinkclick(View view) {
        Intent intent = new Intent(this, Loginactivity.class);
        startActivity(intent);
    }

    }
