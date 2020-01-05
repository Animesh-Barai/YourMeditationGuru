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
                        "https://wallpaperaccess.com/full/432474.png"));
        categoryList.add(
                new Category(
                        2,
                        "Anxiety",
                        "https://i.pinimg.com/564x/40/50/05/40500504bafdb491db29769cc90f5f9b.jpg"));
        categoryList.add(
                new Category(
                        3,
                        "Happy",
                        "https://i.pinimg.com/564x/27/1d/18/271d1863de5a7e0a88b5c8023c61dc01.jpg"));
        categoryList.add(
                new Category(
                        4,
                        "Lonely",
                        "https://i.pinimg.com/564x/9a/48/75/9a487581cc961620e461aa060c202db0.jpg"));


        CategoryAdapter adapter=new CategoryAdapter(this,categoryList);
        recyclerView.setAdapter(adapter);
    }
}
