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
//    private BoxStore boxStore;
    private Box<WorkoutObject> boxStore;
    private TextView title;

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
        boxStore = ((App)getActivity().getApplication()).getBoxStore().boxFor(WorkoutObject.class);
        List<WorkoutObject> workoutList= boxStore.getAll();
        View view = getView();
        if (view != null) {

            title = getView().findViewById(R.id.textTitle);
            title.setText(workoutList.get((int) workoutId).getName());

            TextView paragragh_header = getView().findViewById(R.id.paragraph_header);
            paragragh_header.setText(R.string.Header_text);

            TextView description = (TextView) getView().findViewById(R.id.textDescription);
            description.setText(workoutList.get((int) workoutId).getDescription());

            TextView caption = (TextView) getView().findViewById(R.id.building_caption);
            caption.setText(workoutList.get((int) workoutId).getCaption());

            ImageView image=getView().findViewById(R.id.building_picture);
            image.setImageResource(getResources().getIdentifier(workoutList.get((int) workoutId).getImage(),
                "drawable", getActivity().getPackageName()));

            TextView buildingLink = getView().findViewById(R.id.moreInformation);
            Pattern pattern = Pattern.compile("visit +[a-zA-Z]+");
            buildingLink.setText(R.string.More_information_text);
            Linkify.addLinks(buildingLink, pattern, workoutList.get((int) workoutId).getLink());
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