package com.example.clone.pdm2_project;

import android.content.Intent;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Scene;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.transition.TransitionManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.ToggleButton;

import info.androidhive.androidsplashscreentimer.R;

public class Menu extends AppCompatActivity {

    boolean firstScene;
    ViewGroup mSceneRoot;
    Scene mAScene;
    Scene mAnotherScene;
    Transition mFadeTransition;
    Runnable runnable;
    private Handler handler = new Handler();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);


        handler.postDelayed(runnable, 1000);
        runnable = new Runnable() {
            @Override
            public void run() {
                if (firstScene == true) {
                    TransitionManager.go(mAnotherScene, mFadeTransition);
                    firstScene = false;
                } else {
                    TransitionManager.go(mAScene, mFadeTransition);
                    firstScene = true;
                }
                handler.postDelayed(this, 1000);
            }
        };

        handler.postDelayed(runnable, 100);
        // Create the scene root for the scenes in this app
        mSceneRoot = (ViewGroup) findViewById(R.id.scene_root);

        // Create the
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            mAScene = Scene.getSceneForLayout(mSceneRoot, R.layout.scene1, this);
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            mAnotherScene =
                    Scene.getSceneForLayout(mSceneRoot, R.layout.scene2, this);
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            mFadeTransition =
                    TransitionInflater.from(this).
                            inflateTransition(R.transition.fade_transition);
        }
        firstScene = true;


        final MediaPlayer mp = MediaPlayer.create(this, R.raw.sound);
        mp.setLooping(true);
        mp.start();

        Switch toggle = (Switch) findViewById(R.id.switch2);
        toggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    mp.pause();
                } else {
                    mp.start();
                }
            }
        });
    }

    public void receitas(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void sair(View view) {
        finish();
        System.exit(0);
    }
}
