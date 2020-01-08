package com.yourmeditationguru.saurabhthesuperhero.yourmeditationguru;

import androidx.appcompat.app.AppCompatActivity;
import de.hdodenhof.circleimageview.CircleImageView;

import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Player extends AppCompatActivity {
    private SeekBar volumeSeekbar = null;

    String tracktitle, trackdescr, trackimage, trackurl;
    int finalTime, startTime;
    MediaPlayer mediaPlayer;
    Context context;
    private AudioManager audioManager = null;
    ImageView image, play;
    TextView title, time;
    private Handler myHandler = new Handler();
    private int forwardTime = 15000;
    private int backwardTime = 15000;
    CircleImageView cimage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);

        cimage = (CircleImageView) findViewById(R.id.circleimage);
        image = (ImageView) findViewById(R.id.imageView5);
        title = (TextView) findViewById(R.id.title);
        play = (ImageView) findViewById(R.id.play);
        time = findViewById(R.id.time);


        initControls();
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

        finalTime = mediaPlayer.getDuration();
        startTime = mediaPlayer.getCurrentPosition();

        time.setText(String.format("%d : %d ",
                TimeUnit.MILLISECONDS.toMinutes((long) finalTime),
                TimeUnit.MILLISECONDS.toSeconds((long) finalTime) -
                        TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes((long)
                                finalTime)))
        );
        myHandler.postDelayed(UpdateSongTime, 100);
        if (mediaPlayer.isPlaying()) {
            play.setImageResource(R.drawable.play);
            mediaPlayer.pause();
        } else {
            play.setImageResource(R.drawable.pause);

            mediaPlayer.start();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (mediaPlayer != null) {
            mediaPlayer.pause();
            if (isFinishing()) {
                mediaPlayer.stop();
                mediaPlayer.release();
            }
        }
    }

    private Runnable UpdateSongTime = new Runnable() {
        public void run() {
            startTime = mediaPlayer.getCurrentPosition();
            time.setText(String.format("%d : %d - %d : %d",
                    TimeUnit.MILLISECONDS.toMinutes((long) startTime),
                    TimeUnit.MILLISECONDS.toSeconds((long) startTime) -
                            TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.
                                    toMinutes((long) startTime)), TimeUnit.MILLISECONDS.toMinutes((long) finalTime),
                    TimeUnit.MILLISECONDS.toSeconds((long) finalTime) -
                            TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes((long)
                                    finalTime)))
            );
            myHandler.postDelayed(this, 100);

        }
    };

    public void fwdtrack(View view) {

        int temp = (int) startTime;

        if ((temp + forwardTime) <= finalTime) {
            startTime = startTime + forwardTime;
            mediaPlayer.seekTo((int) startTime);
            Toast.makeText(getApplicationContext(), "You have Jumped forward 15 seconds", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getApplicationContext(), "Cannot jump forward 5 seconds", Toast.LENGTH_SHORT).show();
        }
    }


    public void bwdtrack(View view) {
        int temp = (int) startTime;

        if ((temp - backwardTime) > 0) {
            startTime = startTime - backwardTime;
            mediaPlayer.seekTo((int) startTime);
            Toast.makeText(getApplicationContext(), "You have Jumped backward 5 seconds", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getApplicationContext(), "Cannot jump backward 5 seconds", Toast.LENGTH_SHORT).show();
        }
    }


    private void initControls() {
        try {
            volumeSeekbar = (SeekBar) findViewById(R.id.seekBar);
            audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
            volumeSeekbar.setMax(audioManager
                    .getStreamMaxVolume(AudioManager.STREAM_MUSIC));
            volumeSeekbar.setProgress(audioManager
                    .getStreamVolume(AudioManager.STREAM_MUSIC));


            volumeSeekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                @Override
                public void onStopTrackingTouch(SeekBar arg0) {
                }

                @Override
                public void onStartTrackingTouch(SeekBar arg0) {
                }

                @Override
                public void onProgressChanged(SeekBar arg0, int progress, boolean arg2) {
                    audioManager.setStreamVolume(AudioManager.STREAM_MUSIC,
                            progress, 0);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
