package com.example.dailystatus.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.dailystatus.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Studdailydataentryactivity extends AppCompatActivity {

    String intentValue;
    String formattedDate;
    String strParentEmail;
    String strPhone;
    String strHW;
    String strComments;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_studdailydataentry);

        Intent studdetail = getIntent();
        intentValue = studdetail.getStringExtra("StudIDandName");

        //Log.d("intentvalue: ::::", intentValue);


        String[] parts = intentValue.split(",");
        // for(int i = 0; i < 1; i++) {
        //System.out.println("arr["+i+"] = " + arr[i].trim());

        //Log.d("test",(String) parts.length);

        // setting values from DB

        TextView StudID = (TextView) findViewById(R.id.tvstudIDEntryForm);
        StudID.setText(parts[0].substring(9));
        TextView StudName = (TextView) findViewById(R.id.tvstudNameEntryForm);
        StudName.setText(parts[1].substring(11, parts[1].length() - 1));

        Date c = Calendar.getInstance().getTime();
        System.out.println("Current time => " + c);

        SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
        formattedDate = df.format(c);
        TextView todaysDateTextView = (TextView) findViewById(R.id.tvDate);
        todaysDateTextView.setText(formattedDate);
        //}
        // String strEmail = etEmail.getText().toString();
        //final TextView tvStudName = findViewById(R.id.);

    }

    public void processSaveDetails(View view) {
        SaveDetailsToDB();
        Intent intent = new Intent(this, Summaryactivity.class);
        startActivity(intent);
    }

    //function to save data to DB
    public void SaveDetailsToDB() {
        Log.d("StudentDailyReport", "data saved");

    }
}
