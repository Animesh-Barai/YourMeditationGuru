package com.yourmeditationguru.saurabhthesuperhero.yourmeditationguru;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void accesslogin(View view) {
        Intent intent =new Intent(this,MediList.class);
        startActivity(intent);
    }
}
