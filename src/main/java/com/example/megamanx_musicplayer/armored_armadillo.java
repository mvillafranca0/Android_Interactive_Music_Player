package com.example.megamanx_musicplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.VideoView;

public class armored_armadillo extends AppCompatActivity {

    private Button replayButton;
    private Button play_pauseButton;
    private Button loopButton;

    private MediaPlayer bgPlayer;
    private boolean musicPaused = false;
    private boolean musicLoop = true;
    private int musicPos;
    private int videoPos;
    private boolean videoPaused = false;
    private int restartPlayer = 0;

    private VideoView actVideo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_armored_armadillo);

        replayButton = findViewById(R.id.replay);
        play_pauseButton = findViewById(R.id.play_pause);
        loopButton = findViewById(R.id.loop);

        actVideo = findViewById(R.id.aa_stage);
        actVideo.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.aa_stage));
        actVideo.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.setLooping(true);
            }
        });
        actVideo.start();
        actVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                videoAction();
            }
        });

        replayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                musicPaused = false;
                play_pauseButton.setText("PAUSE");
                bgPlayer.seekTo(restartPlayer);
                bgPlayer.start();
            }
        });

        play_pauseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (musicPaused == false) {
                    musicPos = bgPlayer.getCurrentPosition();
                    bgPlayer.pause();
                    musicPaused = true;
                    play_pauseButton.setText("PLAY");
                } else {
                    bgPlayer.seekTo(musicPos);
                    bgPlayer.start();
                    musicPaused = false;
                    play_pauseButton.setText("PAUSE");
                }
            }
        });

        loopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (musicLoop == false) {
                    bgPlayer.setLooping(true);
                    loopButton.setText("LOOP (Y)");
                    musicLoop = true;
                } else {
                    bgPlayer.setLooping(false);
                    loopButton.setText("LOOP (N)");
                    musicLoop = false;
                }
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

        bgPlayer = MediaPlayer.create(this, R.raw.armored_armadillo);
        bgPlayer.setVolume(0.2f, 0.2f);
        bgPlayer.setLooping(true);
        bgPlayer.seekTo(restartPlayer);
        bgPlayer.start();
    }

    @Override
    protected void onPause() {
        super.onPause();

        bgPlayer.stop();
    }

    protected void videoAction() {
        if (videoPaused == false) {
            actVideo.pause();
            videoPos = actVideo.getCurrentPosition();
            videoPaused = true;
        } else {
            actVideo.seekTo(videoPos);
            actVideo.start();
            videoPaused = false;
        }
    }
}