package com.example.megamanx_musicplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Boolean bool = false;
    private Button startButton;
    private MediaPlayer bgPlayer;
    private MediaPlayer btnSelect;
    private int restartPlayer = 0;
    private Button visibleBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        visibleBtn = findViewById(R.id.visibleButton);

        startButton = findViewById(R.id.start_btn);
        startButton.setBackgroundColor(Color.TRANSPARENT);

        visibleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bool = visible(bool);
            }
        });

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bgPlayer.stop();
                btnSelect.start();
                Intent startIntent = new Intent(MainActivity.this, select.class);
                startActivity(startIntent);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

        bgPlayer = MediaPlayer.create(this, R.raw.title_theme);
        bgPlayer.setVolume(0.2f, 0.2f);
        bgPlayer.seekTo(restartPlayer);
        bgPlayer.start();

        btnSelect = MediaPlayer.create(this, R.raw.selected);
        btnSelect.seekTo(restartPlayer);
    }

    @Override
    protected void onPause() {
        super.onPause();

        bgPlayer.stop();
    }

    protected boolean visible(boolean bool) {
        if (bool == false){
            startButton.setBackgroundResource(R.color.visible);
            visibleBtn.setText("VISIBLE BUTTONS (ON)");
            return true;
        }
        else {
            startButton.setBackgroundColor(Color.TRANSPARENT);
            visibleBtn.setText("VISIBLE BUTTONS (OFF)");
            return false;
        }

    }
}