package com.example.megamanx_musicplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class select extends AppCompatActivity {

    private Boolean bool = false;

    private Button cpButton;
    private Button fmButton;
    private Button bkButton;
    private Button scButton;
    private Button smButton;
    private Button seButton;
    private Button aaButton;
    private Button loButton;
    private Button mxButton;
    private Button visibleBtn;

    private MediaPlayer bgPlayer;
    private MediaPlayer btnSelect;
    private int restartPlayer = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select);

        visibleBtn = findViewById(R.id.visibleButton);
        visibleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bool = visible(bool);
            }
        });

        cpButton = findViewById(R.id.cp_btn);
        cpButton.setBackgroundColor(Color.TRANSPARENT);

        fmButton = findViewById(R.id.fm_btn);
        fmButton.setBackgroundColor(Color.TRANSPARENT);

        bkButton = findViewById(R.id.bk_btn);
        bkButton.setBackgroundColor(Color.TRANSPARENT);

        scButton = findViewById(R.id.sc_btn);
        scButton.setBackgroundColor(Color.TRANSPARENT);

        smButton = findViewById(R.id.sm_btn);
        smButton.setBackgroundColor(Color.TRANSPARENT);

        seButton = findViewById(R.id.se_btn);
        seButton.setBackgroundColor(Color.TRANSPARENT);

        aaButton = findViewById(R.id.aa_btn);
        aaButton.setBackgroundColor(Color.TRANSPARENT);

        loButton = findViewById(R.id.lo_btn);
        loButton.setBackgroundColor(Color.TRANSPARENT);

        mxButton = findViewById(R.id.mx_btn);
        mxButton.setBackgroundColor(Color.TRANSPARENT);

        cpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bgPlayer.stop();
                btnSelect.start();
                Intent cpIntent = new Intent(select.this, chill_penguin.class);
                startActivity(cpIntent);
            }
        });
        fmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bgPlayer.stop();
                btnSelect.start();
                Intent fmIntent = new Intent(select.this, flame_mammoth.class);
                startActivity(fmIntent);
            }
        });
        bkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bgPlayer.stop();
                btnSelect.start();
                Intent bkIntent = new Intent(select.this, boomer_kuwanger.class);
                startActivity(bkIntent);
            }
        });
        scButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bgPlayer.stop();
                btnSelect.start();
                Intent scIntent = new Intent(select.this, sting_chameleon.class);
                startActivity(scIntent);
            }
        });
        smButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bgPlayer.stop();
                btnSelect.start();
                Intent smIntent = new Intent(select.this, spark_mandrill.class);
                startActivity(smIntent);
            }
        });
        seButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bgPlayer.stop();
                btnSelect.start();
                Intent seIntent = new Intent(select.this, storm_eagle.class);
                startActivity(seIntent);
            }
        });
        aaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bgPlayer.stop();
                btnSelect.start();
                Intent aaIntent = new Intent(select.this, armored_armadillo.class);
                startActivity(aaIntent);
            }
        });
        loButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bgPlayer.stop();
                btnSelect.start();
                Intent loIntent = new Intent(select.this, launch_octopus.class);
                startActivity(loIntent);
            }
        });
        mxButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bgPlayer.stop();
                btnSelect.start();
                Intent mxIntent = new Intent(select.this, megaman_x.class);
                startActivity(mxIntent);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

        bgPlayer = MediaPlayer.create(this, R.raw.stage_select_theme);
        bgPlayer.setVolume(0.2f, 0.2f);
        bgPlayer.setLooping(true);
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
            cpButton.setBackgroundResource(R.color.visible);
            fmButton.setBackgroundResource(R.color.visible);
            bkButton.setBackgroundResource(R.color.visible);
            scButton.setBackgroundResource(R.color.visible);
            smButton.setBackgroundResource(R.color.visible);
            seButton.setBackgroundResource(R.color.visible);
            aaButton.setBackgroundResource(R.color.visible);
            loButton.setBackgroundResource(R.color.visible);
            mxButton.setBackgroundResource(R.color.visible);
            visibleBtn.setText("VISIBLE BUTTONS (ON)");
            return true;
        }
        else {
            cpButton.setBackgroundColor(Color.TRANSPARENT);
            fmButton.setBackgroundColor(Color.TRANSPARENT);
            bkButton.setBackgroundColor(Color.TRANSPARENT);
            scButton.setBackgroundColor(Color.TRANSPARENT);
            smButton.setBackgroundColor(Color.TRANSPARENT);
            seButton.setBackgroundColor(Color.TRANSPARENT);
            aaButton.setBackgroundColor(Color.TRANSPARENT);
            loButton.setBackgroundColor(Color.TRANSPARENT);
            mxButton.setBackgroundColor(Color.TRANSPARENT);
            visibleBtn.setText("VISIBLE BUTTONS (OFF)");
            return false;
        }

    }
}