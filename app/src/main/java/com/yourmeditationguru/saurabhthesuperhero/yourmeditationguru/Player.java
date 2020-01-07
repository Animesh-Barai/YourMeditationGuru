package com.yourmeditationguru.saurabhthesuperhero.yourmeditationguru;

import androidx.appcompat.app.AppCompatActivity;
import de.hdodenhof.circleimageview.CircleImageView;

import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.io.IOException;

public class Player extends AppCompatActivity {
    String tracktitle,trackdescr,trackimage,trackurl;
    MediaPlayer mediaPlayer;
    Context context;
    ImageView image,play;
    TextView title;
    CircleImageView cimage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);

        cimage=(CircleImageView) findViewById(R.id.circleimage);
         image=(ImageView)findViewById(R.id.imageView5);
         title=(TextView)findViewById(R.id.title);
        play=(ImageView)findViewById(R.id.play);


        Intent intent = getIntent();
        tracktitle = intent.getStringExtra("title");
        trackimage = intent.getStringExtra("image");
        trackurl = intent.getStringExtra("murl");


        Picasso.with(context)
                .load(trackimage)
                .into(image);

        Picasso.with(context)
                .load(trackimage)
                .into(cimage);
        title.setText(tracktitle);


        String url = "https://firebasestorage.googleapis.com/v0/b/yourmeditationguru-885f4.appspot.com/o/Ed%20Sheeran%20-%20Bibia%20Be%20Ye%20Ye.mp3?alt=media&token=1a905b58-d587-4490-94f0-a6c0f65915cf"; // your URL here
         mediaPlayer = new MediaPlayer();
        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        try {
            mediaPlayer.setDataSource(url);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            mediaPlayer.prepare(); // might take long! (for buffering, etc)
        } catch (IOException e) {
            e.printStackTrace();
        }



    }

    public void playsong(View view) {

        if(mediaPlayer.isPlaying())
        {
            play.setImageResource(R.drawable.play);
            mediaPlayer.pause();
        }
        else{
            play.setImageResource(R.drawable.pause);

            mediaPlayer.start();
        }
    }
}
