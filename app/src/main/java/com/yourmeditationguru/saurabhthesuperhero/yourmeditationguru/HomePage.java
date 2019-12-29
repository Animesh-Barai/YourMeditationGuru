package com.yourmeditationguru.saurabhthesuperhero.yourmeditationguru;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class HomePage extends AppCompatActivity {
    List<Category> categoryList;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        recyclerView=(RecyclerView)findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        categoryList=new ArrayList<>();

        categoryList.add(
                new Category(
                        1,
                        "Depression",
                        "http://placehold.it/120x120&text=saurabh"));
        categoryList.add(
                new Category(
                        2,
                        "Anxiety",
                        "http://placehold.it/120x120&text=saurabh"));
        categoryList.add(
                new Category(
                        3,
                        "Happy",
                        "http://placehold.it/120x120&text=saurabh"));
        categoryList.add(
                new Category(
                        4,
                        "Lonely",
                        "http://placehold.it/120x120&text=saurabh"));


        CategoryAdapter adapter=new CategoryAdapter(this,categoryList);
        recyclerView.setAdapter(adapter);
    }
}
