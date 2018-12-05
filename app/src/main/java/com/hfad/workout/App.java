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
        if (WorkoutObjectBox.count() == 0) {
            List<WorkoutObject> initialWorkoutObjects = new ArrayList<>();
            initialWorkoutObjects.add(new WorkoutObject("CIS Building", "The Computer Information Systems (CIS) building was constructed to house the Information Systems and Operations" +
                    "Management Department from the Cameron School of Business and the Department of Computer Science from the College of Arts and Sciences." +
                    "The CIS Building, a new 51,731 square-foot state-of-the-art facility on the UNCW campus, opened January 10, 2007 for the new school semester." +
                    "Work on the facility began on July 29, 2004 with the groundbreaking, and competed in December of 2006." +
                    "The building cost approximately $12.8 million and was funded by the North Carolina State Bond campaign of 2000." +
                    "Housed within the new building is the Financial Markets Room and, thanks to a donation from Edward Jones and over 50 if its financial advisers, the Edward Jones Financial Lab." +
                    "Both rooms contain a stock board and ticker, however the Edward Jones Financial Lab also includes the Bloomberg Trading Terminal." +
                    "With this terminal, students and faculty have the ability to trade stocks directly with the New York Stock Exchange, NASDAQ and more.",
                    "cis.jpg",
                    "(A front view of the CIS building)",
                    "https://library.uncw.edu/web/collections/archives/bnl/cis.html",
                    "34.2261017",
                    "-77.87184949415777"));

            initialWorkoutObjects.add(new WorkoutObject("Bear", "Bear Hall opened at its present site in 1972 as the home for the Business and Economics Departments." +
                    "Currently, the Departments of Computer Science, Mathematics and Statistics, and Philosophy and Religion occupy classrooms, teaching labs and faculty offices." +
                    "The College of Arts and Science also resides here. ",
                    "bear.jpg",
                    "(A front view of Bear Hall)",
                    "https://library.uncw.edu/web/collections/archives/bnl/19.html",
                    "34.228545",
                    "-77.87280469680556"));

            initialWorkoutObjects.add(new WorkoutObject("Dobo Hall", "Opened for use in 1996, the New Science Building contained classrooms, laboratories and faculty offices for the Chemistry and Biology Departments." +
                    "Known as Dobo Hall since its 1999 dedication to the Dobo brothers, it is currently used by the Department of Biology and Marine Biology and the Department of Chemistry.",
                    "dobo.jpg",
                    "(A front view of Dobo Hall)",
                    "https://library.uncw.edu/web/collections/archives/bnl/25.html",
                    "34.2257237",
                    "-77.86848956387306"));
            initialWorkoutObjects.add(new WorkoutObject("Cameron Hall","Funding for Cameron Hall began in 1985, with occupancy starting in 1988." +
                    "As the home of the Cameron School of Business, the building contains classrooms and faculty offices." +
                    "he official naming dedication was held on October 5, 1988.",
                    "cameron.jpg",
                    "(A front view of Cameron Hall)",
                    "https://library.uncw.edu/web/collections/archives/bnl/24.html",
                    "34.226041800000004",
                    "-77.8695462604443"));
            initialWorkoutObjects.add(new WorkoutObject("Deloach Hall", " Originally called the Physics-Chemistry Building, this structure housed classrooms for those departments." +
                    "Groundbreaking took place in July of 1967, occupation began in 1968, with the official renaming ceremony to DeLoach Hall in October of 1985." +
                    "Currently the building holds offices and classrooms for the Department of Physics, Department of Physical Oceanography and the Department of Earth Sciences." +
                    "The Department of Chemistry was housed here until Dobo Hall opened. DeLoach Hall contains a large teaching auditorium and several laboratories.",
                    "deloach.jpg",
                    "(A front view of Deloach Hall)",
                    "https://library.uncw.edu/web/collections/archives/bnl/2.html",
                    "34.228831799999995",
                    "-77.87445745000001"));

            // ObjectBox is smart enough to handle CRUD on Collections of entities
            WorkoutObjectBox.put(initialWorkoutObjects);
        }
    }

    public BoxStore getBoxStore() {
        return boxStore;
    }
}
