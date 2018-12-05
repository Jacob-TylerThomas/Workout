package com.hfad.workout;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.util.Linkify;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;
import java.util.regex.Pattern;

import io.objectbox.Box;
import io.objectbox.BoxStore;

public class WorkoutDetailFragment extends Fragment  {
    private long workoutId;
    private BoxStore boxStore;



    public void onCreate(Bundle savedInstanceState){
    super.onCreate(savedInstanceState);
    if (savedInstanceState != null) {
        workoutId = savedInstanceState.getLong("workoutId");
        boxStore = ((App)getActivity().getApplication()).getBoxStore();
//        Box<WorkoutObject> WorkoutObjectBox = boxStore.boxFor(WorkoutObject.class);
//        List<WorkoutObject> workoutList= WorkoutObjectBox.getAll();
    }
}
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_workout_detail, container, false);
    }

    //If it is defined outside of onCreate WorkoutObjectBox keeps being considered null

//    Box<WorkoutObject> WorkoutObjectBox = boxStore.boxFor(WorkoutObject.class);
//    List<WorkoutObject> workoutList= WorkoutObjectBox.getAll();
//    String[] testing = new String[workoutList.size()];


    @Override
    public void onStart() {
        super.onStart();
        View view = getView();
        if (view != null) {
//            String[] workoutNames = new String[workoutList.size()];
//            for (int i = 4; i < workoutList.size(); i++) {
//                workoutNames[i] = (workoutList.get(i).getName());
//
//            }

//            TextView title = (TextView) view.findViewById(R.id.textTitle);
//            title.setText(workoutList.getName());

//            TextView paragragh_header = view.findViewById(R.id.paragraph_header);
//            paragragh_header.setText(R.string.Header_text);
//
//            TextView description = (TextView) view.findViewById(R.id.textDescription);
//            description.setText(workoutList.getClass().getDescription());
//
//            TextView caption = (TextView) view.findViewById(R.id.building_caption);
//            caption.setText(workoutList.getClass().getCaption());
//
//            ImageView image=view.findViewById(R.id.building_picture);
//            image.setImageResource(workout.getImage());
//
//            TextView buildingLink = view.findViewById(R.id.moreInformation);
//            Pattern pattern = Pattern.compile("visit +[a-zA-Z]+");
//            buildingLink.setText(R.string.More_information_text);
//            Linkify.addLinks(buildingLink, pattern, getContext().getResources().getString(workout.getLink()));

            Workout workout = Workout.workouts[(int) workoutId];

            TextView title = (TextView) view.findViewById(R.id.textTitle);
            title.setText(workout.getName());

            TextView paragragh_header = view.findViewById(R.id.paragraph_header);
            paragragh_header.setText(R.string.Header_text);

            TextView description = (TextView) view.findViewById(R.id.textDescription);
            description.setText(workout.getDescription());

            TextView caption = (TextView) view.findViewById(R.id.building_caption);
            caption.setText(workout.getCaption());

            ImageView image=view.findViewById(R.id.building_picture);
            image.setImageResource(workout.getImage());

            TextView buildingLink = view.findViewById(R.id.moreInformation);
            Pattern pattern = Pattern.compile("visit +[a-zA-Z]+");
            buildingLink.setText(R.string.More_information_text);
            Linkify.addLinks(buildingLink, pattern, getContext().getResources().getString(workout.getLink()));

        }

    }
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putLong("workoutId", workoutId);
    }
    public void setWorkout(long id) {
        this.workoutId = id;
    }
}