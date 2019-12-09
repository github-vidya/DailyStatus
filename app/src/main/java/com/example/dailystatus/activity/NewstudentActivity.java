package com.example.dailystatus.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.dailystatus.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class NewstudentActivity extends AppCompatActivity {

    ListView simpleList;
    String classValues[] = {"Junior KG", "Senior KG","Std1"};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newstudent);

        //to fetch class details
        Spinner spin = (Spinner) findViewById(R.id.spinner_class);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, classValues);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(adapter);

    }


    public void processSaveNewStudentValues(View view) {
        SavedetailsToDB();
        Intent intent = new Intent(this, Summaryactivity.class);
        startActivity(intent);
    }
    //to save new student details to DB
    public  void  SavedetailsToDB(){

    }
    }
