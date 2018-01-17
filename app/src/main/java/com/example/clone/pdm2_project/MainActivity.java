package com.example.clone.pdm2_project;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import info.androidhive.androidsplashscreentimer.R;

public class MainActivity extends AppCompatActivity {

    static Boolean firstTimePortrait = true;

    static final int REQUEST_IMAGE_CAPTURE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (findViewById(R.id.fragment_container) != null) {

            if (!firstTimePortrait) {
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

    // ------------------------ fotos --------------------------
    public void takeFoto(View view) {
        dispatchTakePictureIntent();
        //dispatchTakePictureIntentFile();
    }

    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            ImageView imageView = (ImageView) findViewById(R.id.imageView);
            imageView.setImageBitmap(imageBitmap);

        }
    }
    // ------------------------ mapa ------------------------------

    public void mapa(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:<lat>,<long>?q=<lat>,<long>(Label+Name)"));
        startActivity(intent);
    }
}