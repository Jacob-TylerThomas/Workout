package com.hfad.workout;

import android.app.Application;

import java.util.ArrayList;
import java.util.List;

import io.objectbox.Box;
import io.objectbox.BoxStore;

public class App extends Application {

    private BoxStore boxStore;

    @Override
    public void onCreate() {
        super.onCreate();

        // Initialize the main data access object
        boxStore = MyObjectBox.builder().androidContext(App.this).build();

        // Get the wrapper (Box) for the WorkoutObject table that lets us store WorkoutObject objects
        Box<WorkoutObject> WorkoutObjectBox = boxStore.boxFor(WorkoutObject.class);

         //Initialize with some data
//        if (WorkoutObjectBox.count() == 0) {
//            List<WorkoutObject> initialWorkoutObjects = new ArrayList<>();
//            initialWorkoutObjects.add(new WorkoutObject("CIS Building", "\\t The Computer Information Systems (CIS) building was constructed to house the Information Systems and Operations" +
//                    "Management Department from the Cameron School of Business and the Department of Computer Science from the College of Arts and Sciences." +
//                    "The CIS Building, a new 51,731 square-foot state-of-the-art facility on the UNCW campus, opened January 10, 2007 for the new school semester." +
//                    "Work on the facility began on July 29, 2004 with the groundbreaking, and competed in December of 2006." +
//                    "The building cost approximately $12.8 million and was funded by the North Carolina State Bond campaign of 2000." +
//                    "Housed within the new building is the Financial Markets Room and, thanks to a donation from Edward Jones and over 50 if its financial advisers, the Edward Jones Financial Lab." +
//                    "Both rooms contain a stock board and ticker, however the Edward Jones Financial Lab also includes the Bloomberg Trading Terminal." +
//                    "With this terminal, students and faculty have the ability to trade stocks directly with the New York Stock Exchange, NASDAQ and more.",
//                    "cis.jpg",
//                    "(A front view of the CIS building)",
//                    "https://library.uncw.edu/web/collections/archives/bnl/cis.html",
//
//
//            initialWorkoutObjects.add(new WorkoutObject());
//            initialWorkoutObjects.add(new WorkoutObject());
//            initialWorkoutObjects.add(new WorkoutObject());
//            initialWorkoutObjects.add(new WorkoutObject());
//            initialWorkoutObjects.add(new WorkoutObject());
//            initialWorkoutObjects.add(new WorkoutObject());
//            initialWorkoutObjects.add(new WorkoutObject());
//
//            // ObjectBox is smart enough to handle CRUD on Collections of entities
//            WorkoutObjectBox.put(initialWorkoutObjects);
//        }
    }

    public BoxStore getBoxStore() {
        return boxStore;
    }
}
