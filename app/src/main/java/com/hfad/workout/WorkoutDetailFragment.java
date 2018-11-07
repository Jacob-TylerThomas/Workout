package com.hfad.workout;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.util.Linkify;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.regex.Pattern;

public class WorkoutDetailFragment extends Fragment {
    private long workoutId;

public void onCreate(Bundle savedInstanceState){
    super.onCreate(savedInstanceState);
    if (savedInstanceState != null) {
        workoutId = savedInstanceState.getLong("workoutId");
    }
}
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_workout_detail, container, false);
    }
    @Override
    public void onStart() {
        super.onStart();
        View view = getView();
        if (view != null) {
            TextView title = (TextView) view.findViewById(R.id.textTitle);
            Workout workout = Workout.workouts[(int) workoutId];
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