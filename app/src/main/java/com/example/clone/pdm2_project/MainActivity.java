package com.example.clone.pdm2_project;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import info.androidhive.androidsplashscreentimer.R;

public class MainActivity extends AppCompatActivity {

    static Boolean firstTimePortrait = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (findViewById(R.id.fragment_container) != null) {

            if( ! firstTimePortrait ){
                Toast.makeText(this, "NOT first time portrait!", Toast.LENGTH_SHORT).show();
                return;
            }

            Toast.makeText(this, "First time portrait!", Toast.LENGTH_SHORT).show();

            firstTimePortrait = false;

            // Create a new Fragment to be placed in the activity layout
            FragmentHeadlines firstFragment = new FragmentHeadlines();

            firstFragment.setArguments(getIntent().getExtras());

            // Add the fragment to the 'fragment_container' FrameLayout
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment_container, firstFragment).commit();
        }
    }
}
