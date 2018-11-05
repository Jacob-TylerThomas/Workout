package com.hfad.workout;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
public class WorkoutListFragment extends ListFragment {
    static interface Listener {
        void itemClicked(long id);
    };
    private Listener listener;
    private String test;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Integer[] names = new Integer[Workout.workouts.length];
        for (int i = 0; i < names.length; i++) {
            names[i] = Workout.workouts[i].getName();
        }
        ArrayAdapter<Integer> adapter = new ArrayAdapter<>(
                inflater.getContext(), android.R.layout.simple_list_item_1,
                names);
        setListAdapter(adapter);
        return super.onCreateView(inflater, container, savedInstanceState);
    }
    @Override
    //attachs fragment to activity
    public void onAttach(Context context) {
        super.onAttach(context);
        this.listener = (Listener)context;
    }
    @Override
    //tells listener when an item in the list view is clicked
    public void onListItemClick(ListView listView, View itemView, int position, long id) {
        if (listener != null) {
            listener.itemClicked(id);
        }
    }
}