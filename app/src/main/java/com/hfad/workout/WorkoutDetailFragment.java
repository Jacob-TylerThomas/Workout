package com.hfad.workout;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
public class WorkoutDetailFragment extends Fragment {
    private long workoutId;
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
            TextView paragragh_header = view.findViewById(R.id.paragraph_header);
            paragragh_header.setText(R.string.Header_text);
            Workout workout = Workout.workouts[(int) workoutId];
            title.setText(workout.getName());
            TextView description = (TextView) view.findViewById(R.id.textDescription);
            description.setText(workout.getDescription());
            TextView caption = (TextView) view.findViewById(R.id.building_caption);
            caption.setText(workout.getCaption());
            TextView link = (TextView) view.findViewById(R.id.building_link);
            link.setText(workout.getLink());
            ImageView image=view.findViewById(R.id.building_picture);
            image.setImageResource(workout.getImage());
        }
    }
    public void setWorkout(long id) {
        this.workoutId = id;
    }
}