package com.example.dailystatus.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.dailystatus.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Summaryactivity extends AppCompatActivity {

    ListView simpleList;
    String studIds[] = {"KG_1", "KG_2", "KG_3"};
    String studNames[] = {"Vidya", "Saatvik", "Pranav"};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);

        List<HashMap<String, String>> studList = new ArrayList<HashMap<String, String>>();
        // List<HashMap<String, String>> fillMaps = new ArrayList<HashMap<String, String>>();

        for (int i = 0; i < studIds.length; i++) {
            HashMap<String, String> studdata = new HashMap<String, String>();
            studdata.put("Stud_ID", "" + studIds[i]);
            studdata.put("Stud_Name", "" + studNames[i]);
            studList.add(studdata);
        }

        String[] from = new String[]{"Stud_ID", "Stud_Name"};
        int[] to = new int[]{R.id.tvstudid, R.id.tvstudname};

        simpleList = (ListView) findViewById(R.id.lv_StudNames);
        final SimpleAdapter simpleAdapter = new SimpleAdapter(this, studList, R.layout.singlelistitem_design, from, to);
        //  ArrayAdapter<String> arrayAdapter =
        //  new ArrayAdapter<String>(this,R.layout.singlelistitem_design,R.id.tvlistitem,studNames) ;
        //new ArrayAdapter<String;>(this, R.layout.activity_listvie
        // w, R.id.textView, countryList);
        //simpleList.setAdapter(arrayAdapter);
        simpleList.setAdapter(simpleAdapter);
        simpleList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //String strselectedItem = parent.getSelectedItem().toString();
                //String selectedItem = (String) parent.getItemAtPosition(position);
                String selectedItem = simpleAdapter.getItem(position).toString();


                //Log.d("Summary: Selected::::", selectedItem);

                Intent intentstud = new Intent(getApplicationContext(), Studdailydataentryactivity.class);
                intentstud.putExtra("StudIDandName",selectedItem);
                startActivity(intentstud);
            }
        });

        /*simpleList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Get the selected item text from ListView
             //   String selectedItem = (String) parent.getItemAtPosition(position);
                // Display the selected item text on TextView
                //tv.setText("Your favorite : " + selectedItem);
           }*/
    }
    public void processAddNewStudent(View view) {
        Intent intent = new Intent(this, NewstudentActivity.class);
        startActivity(intent);
    }
}
