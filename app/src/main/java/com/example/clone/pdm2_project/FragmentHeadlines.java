package com.example.clone.pdm2_project;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.clone.pdm2_project.Model.DataResponse;
import com.example.clone.pdm2_project.Model.Speakers;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

import info.androidhive.androidsplashscreentimer.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentHeadlines extends ListFragment {

    private List<Speakers> speakers;
    static CustomAdapter customAdapter;

    public FragmentHeadlines() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        speakers = new ArrayList<>();
        try {
            JSONArray jsonArray = new JSONArray(DataResponse.fakeResponse);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                String name = jsonObject.optString("Name", "");
                String descricao = jsonObject.optString("descricao", "");

                Speakers speaker = new Speakers(name,descricao);
                speakers.add(speaker);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        customAdapter = new CustomAdapter(getActivity().getBaseContext(), speakers);
        setListAdapter(customAdapter);

        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {

        if (getActivity().findViewById(R.id.fragment_container) != null){

            FragmentArticle newFragment = new FragmentArticle();
            Bundle args = new Bundle();
            args.putInt("position", position);
            newFragment.setArguments(args);
            FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();

            transaction.replace(R.id.fragment_container, newFragment);
            transaction.addToBackStack(null);
            // Commit the transaction
            transaction.commit();

        }
        else{
            TextView articleTextView = (TextView) getActivity().findViewById(R.id.article_textview);
            articleTextView.setText(customAdapter.getItem(position).getDescription());
        }
    }


}
