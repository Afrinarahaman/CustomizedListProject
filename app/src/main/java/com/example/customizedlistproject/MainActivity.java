package com.example.customizedlistproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lstBiler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        lstBiler= findViewById(R.id.lstBiler);
        ArrayList<Bil> biler =new ArrayList<Bil>();
        biler.add(new Bil(1000, "BMW Isetta GTI",
                "0-100 på 5 min", R.drawable.bmw_isetta1));
        biler.add(new Bil(1000, "BMW Isetta 3 wheels",
                "0-100 på 5 min", R.drawable.bmw_isetta10));
        biler.add(new Bil(1000, "BMW Isetta HDMI",
                "0-100 på 5 min", R.drawable.bmw_isetta11));
        biler.add(new Bil(1000, "BMW Isetta 4 wheels",
                "0-100 på 5 min", R.drawable.bmw_isetta12));
    }
}