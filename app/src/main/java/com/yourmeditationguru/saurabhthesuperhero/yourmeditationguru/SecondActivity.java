package com.yourmeditationguru.saurabhthesuperhero.yourmeditationguru;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.yourmeditationguru.saurabhthesuperhero.yourmeditationguru.R;

public class SecondActivity extends AppCompatActivity {
    Context context;
    String tracktitle,trackdescr,trackimage,trackurl;
    ImageView imageView;
        TextView title,descr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Intent intent = getIntent();
        tracktitle = intent.getStringExtra("title");
       trackimage = intent.getStringExtra("image");
        trackdescr = intent.getStringExtra("descr");
        trackurl = intent.getStringExtra("murl");

        imageView=(ImageView)findViewById(R.id.trackimg);
        title=(TextView)findViewById(R.id.tracktitle);
        descr=(TextView)findViewById(R.id.trackdescr);

        Picasso.with(context)
                .load((String)trackimage)
                .into(imageView);

        descr.setText(trackdescr);
        title.setText(tracktitle);
        descr.setMovementMethod(new ScrollingMovementMethod());
    }

    public void back(View view) {
        finish();
    }

    public void openplayer(View view) {
        Intent intent = new Intent(this, Player.class);
        intent.putExtra("image", trackimage);
        // put image data in Intent
        intent.putExtra("title", tracktitle);
        intent.putExtra("murl", trackurl);
        startActivity(intent); // start Intent

    }

//    public void openplayer(View view) {
////
//        Intent intent = new Intent(this, Player.class);
//        intent.putExtra("image", trackimage);
//        // put image data in Intent
//        intent.putExtra("title", tracktitle);
//        intent.putExtra("murl", trackurl);
//        context.startActivity(intent); // start Intent
//    }
}
