package com.yourmeditationguru.saurabhthesuperhero.yourmeditationguru;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.yourmeditationguru.saurabhthesuperhero.yourmeditationguru.R;

public class SecondActivity extends AppCompatActivity {
    Context context;
    ImageView imageView;
        TextView title,descr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Intent intent = getIntent();
        String tracktitle = intent.getStringExtra("title");
        String trackimage = intent.getStringExtra("image");
        imageView=(ImageView)findViewById(R.id.trackimg);
        title=(TextView)findViewById(R.id.tracktitle);
        descr=(TextView)findViewById(R.id.trackdescr);

        Picasso.with(context)
                .load((String)trackimage)
                .into(imageView);

        title.setText(tracktitle);
        descr.setMovementMethod(new ScrollingMovementMethod());
    }
}
