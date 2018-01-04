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

        /*Toast.makeText(this, NewsData.Headlines[0], Toast.LENGTH_SHORT).show();
        Toast.makeText(this, NewsData.Articles[0], Toast.LENGTH_SHORT).show();

        Toast.makeText(this, NewsData.Headlines[1], Toast.LENGTH_SHORT).show();
        Toast.makeText(this, NewsData.Articles[1], Toast.LENGTH_SHORT).show();*/

        //Toast.makeText(this, "OnCreate", Toast.LENGTH_SHORT).show();

        // Check that the activity is using the layout version with
        // the fragment_container FrameLayout
        if (findViewById(R.id.fragment_container) != null) {

            /*if(getSupportFragmentManager().findFragmentById(R.id.fragment_headlines) != null)
                Toast.makeText(this, "First time portrait!", Toast.LENGTH_SHORT).show();
            else
                Toast.makeText(this, "NOT first time portrait!", Toast.LENGTH_SHORT).show();*/


            // However, if we're being restored from a previous state,
            // then we don't need to do anything and should return or else
            // we could end up with overlapping fragments.
            /*if (savedInstanceState != null) {
                return;
            }*/
            if( ! firstTimePortrait ){
                Toast.makeText(this, "NOT first time portrait!", Toast.LENGTH_SHORT).show();
                return;
            }

            Toast.makeText(this, "First time portrait!", Toast.LENGTH_SHORT).show();

            firstTimePortrait = false;

            // Create a new Fragment to be placed in the activity layout
            FragmentHeadlines firstFragment = new FragmentHeadlines();

            // In case this activity was started with special instructions from an
            // Intent, pass the Intent's extras to the fragment as arguments
            firstFragment.setArguments(getIntent().getExtras());

            // Add the fragment to the 'fragment_container' FrameLayout
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment_container, firstFragment).commit();
        }

    }
}
