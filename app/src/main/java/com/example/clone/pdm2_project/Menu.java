package com.example.clone.pdm2_project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import info.androidhive.androidsplashscreentimer.R;

public class Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    public void receitas(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
