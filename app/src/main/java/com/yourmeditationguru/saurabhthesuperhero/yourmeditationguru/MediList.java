package com.yourmeditationguru.saurabhthesuperhero.yourmeditationguru;


import android.os.Bundle;

import java.util.ArrayList;
import java.util.Arrays;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MediList extends AppCompatActivity {
        //https://bit.ly/2ZvQdGq
    ArrayList personNames = new ArrayList<>(Arrays.asList("Person 1", "Person 2", "Person 3", "Person 4", "Person 5", "Person 6", "Person 7","Person 8", "Person 9", "Person 10", "Person 11", "Person 12", "Person 13", "Person 14"));
    ArrayList personImages = new ArrayList<>(Arrays.asList("https://bit.ly/2ZvQdGq","https://bit.ly/2ZvQdGq","https://bit.ly/2ZvQdGq","https://bit.ly/2ZvQdGq","https://bit.ly/2ZvQdGq","https://bit.ly/2ZvQdGq","https://bit.ly/2ZvQdGq"));


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medi_list);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(),2);
        recyclerView.setLayoutManager(gridLayoutManager); // set LayoutManager to RecyclerView
        //  call the constructor of CustomAdapter to send the reference and data to Adapter
        musicListAdapter customAdapter = new musicListAdapter(MediList.this, personNames,personImages);
        recyclerView.setAdapter(customAdapter);
    }
}
