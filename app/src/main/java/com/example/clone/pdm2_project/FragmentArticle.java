package com.example.clone.pdm2_project;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.clone.pdm2_project.Model.Speakers;

import info.androidhive.androidsplashscreentimer.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentArticle extends Fragment {
    private Speakers speakers;

    public FragmentArticle() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fragment_article, container, false);
    }

    @Override public void onStart() {
        super.onStart();

        Bundle args = getArguments();
        if (args != null) {
            // Set article based on argument passed in
            int currentPosition = args.getInt("position");
            speakers = FragmentHeadlines.customAdapter.getItem(currentPosition);
            TextView article = (TextView) getActivity().findViewById(R.id.article_textview);
            article.setText(speakers.getDescription());
        }
    }

}

