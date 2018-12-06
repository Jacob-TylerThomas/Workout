package com.hfad.workout;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
//import android.support.v4.app.ListFragment;
import android.support.v4.app.Fragment;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import io.objectbox.Box;
import io.objectbox.BoxStore;

public class WorkoutListFragment extends Fragment {
    private BoxStore boxStore;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
            RecyclerView workoutRecycler = (RecyclerView)inflater.inflate(
                    R.layout.fragment_workout_list, container, false);
            boxStore = ((App)getActivity().getApplication()).getBoxStore();

            Box<WorkoutObject> WorkoutObjectBox = boxStore.boxFor(WorkoutObject.class);
            List<WorkoutObject> workoutList= WorkoutObjectBox.getAll();

            //this successfully pulls from the database to populate the cardview
        String[] workoutNames = new String[workoutList.size()];
        for (int i = 0; i < workoutList.size(); i++) {
            workoutNames[i] = (workoutList.get(i).getName());
        }

        int[] workoutImages = new int[workoutList.size()];
        for (int i = 0; i < workoutList.size(); i++) {
            workoutImages[i] = getResources().getIdentifier(workoutList.get(i).getImage(),
                    "drawable", getActivity().getPackageName());
        }

            CaptionedImagesAdapter adapter =
                    new CaptionedImagesAdapter(workoutNames, workoutImages);
            workoutRecycler.setAdapter(adapter);
            GridLayoutManager layoutManager = new GridLayoutManager(getActivity(), 1);
            workoutRecycler.setLayoutManager(layoutManager);
            adapter.setListener(new CaptionedImagesAdapter.Listener() {
                public void onClick(int position) {
                    Intent intent = new Intent(getActivity(), DetailActivity.class);
                    intent.putExtra(DetailActivity.EXTRA_WORKOUT_ID, position);
                    getActivity().startActivity(intent);
                }
            });
            return workoutRecycler;
    }
}