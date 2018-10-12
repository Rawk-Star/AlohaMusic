package com.rawks.jeremy.alohamusic;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity
{
    Button btnUkulele, btnDrums;      // Buttons on the activity
    MediaPlayer mpUkulele, mpDrums;   // Audio players for each song
    int playing;                      // Whether the music is playing
    final int MUSIC_PLAYING = 1;      // Music is playing
    final int MUSIC_NOT_PLAYING = 0;  // Music is not playing

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Create object representations of the activity buttons
        btnDrums = findViewById(R.id.btnDrums);
        btnUkulele = findViewById(R.id.btnUkulele);

        // Define listeners for button clicks
        btnUkulele.setOnClickListener(bUkulele);
        btnDrums.setOnClickListener(bDrums);

        // Create MediaPlayer objects to play song audio
        mpUkulele = new MediaPlayer();
        mpUkulele = MediaPlayer.create(this, R.raw.ukulele);
        mpDrums = new MediaPlayer();
        mpDrums = MediaPlayer.create(this, R.raw.drums);

        // Initialize variables
        playing = MUSIC_NOT_PLAYING;
    }

    // Event listener and method to monitor and handle user clicking the ukulele song button
    Button.OnClickListener bUkulele = new Button.OnClickListener()
    {
        public void onClick(View v)
        {
            switch (playing)
            {
                case MUSIC_NOT_PLAYING:
                    mpUkulele.start();
                    playing = MUSIC_PLAYING;
                    btnUkulele.setText(R.string.btnUkulelePause);
                    btnDrums.setVisibility(View.INVISIBLE);
                    break;
                case MUSIC_PLAYING:
                    mpUkulele.pause();
                    playing = MUSIC_NOT_PLAYING;
                    btnUkulele.setText(R.string.btnUkulelePlay);
                    btnDrums.setVisibility(View.VISIBLE);
                    break;
            }
        }
    };

    // Event listener and method to monitor and handle user clicking the drums song button
    Button.OnClickListener bDrums = new Button.OnClickListener()
    {
        public void onClick(View v)
        {
            switch (playing)
            {
                case MUSIC_NOT_PLAYING:
                    mpDrums.start();
                    playing = MUSIC_PLAYING;
                    btnDrums.setText(R.string.btnDrumsPause);
                    btnUkulele.setVisibility(View.INVISIBLE);
                    break;
                case MUSIC_PLAYING:
                    mpDrums.pause();
                    playing = MUSIC_NOT_PLAYING;
                    btnDrums.setText(R.string.btnDrumsPlay);
                    btnUkulele.setVisibility(View.VISIBLE);
                    break;
            }
        }
    };
}