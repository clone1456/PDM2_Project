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

import info.androidhive.androidsplashscreentimer.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentHeadlines extends ListFragment {


    public FragmentHeadlines() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(inflater.getContext(), android.R.layout.simple_list_item_1, NewsData.Headlines);

        setListAdapter(adapter);

        return super.onCreateView(inflater, container, savedInstanceState);
    }


    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {

        if (getActivity().findViewById(R.id.fragment_container) != null){
            Toast.makeText(getActivity().getBaseContext(), "Clicked Portrait." + NewsData.Headlines[position],
                    Toast.LENGTH_SHORT).show();

            FragmentArticle newFragment = new FragmentArticle();
            Bundle args = new Bundle();
            args.putInt("position", position);
            newFragment.setArguments(args);
            FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
            // Replace whatever is in the fragment_container view with this fragment,
            // and add the transaction to the back stack so the user can navigate back
            transaction.replace(R.id.fragment_container, newFragment);
            transaction.addToBackStack(null);
            // Commit the transaction
            transaction.commit();

        }
        else{
            Toast.makeText(getActivity().getBaseContext(), "Clicked Landscape." + NewsData.Headlines[position],
                    Toast.LENGTH_SHORT).show();

            TextView articleTextView = (TextView) getActivity().findViewById(R.id.article_textview);
            articleTextView.setText(NewsData.Articles[position]);
        }
    }


}
