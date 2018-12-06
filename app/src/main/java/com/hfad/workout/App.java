package com.hfad.workout;

import android.app.Application;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Random;

import io.objectbox.Box;
import io.objectbox.BoxStore;

public class App extends Application {

    private BoxStore boxStore;
    private static final int NUM_TO_ADD = 20;

    private static final int maxMillis = 3600000;
    private static final int minMillis = 60000;
    private static final double latMax = 34.2397892;
    private static final double latMin = 33.9979624;
    private static final double lonMax = -77.8055695;
    private static final double lonMin = -77.9490203;
    private static final double accMax = 25.0;
    private static final double accMin = 3.0;

    @Override
    public void onCreate() {
        super.onCreate();

        // Initialize the main data access object

        boxStore = MyObjectBox.builder().androidContext(App.this).build();

        // Get the wrapper (Box) for the WorkoutObject table that lets us store WorkoutObject objects
        Box<WorkoutObject> WorkoutObjectBox = boxStore.boxFor(WorkoutObject.class);

         //Initialize with some data
            WorkoutObjectBox.removeAll();
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
                    "cis",
                    "(A front view of the CIS building)",
                    "https://library.uncw.edu/web/collections/archives/bnl/cis.html",
                    "34.2261017",
                    "-77.87184949415777"));

            initialWorkoutObjects.add(new WorkoutObject("Bear", "Bear Hall opened at its present site in 1972 as the home for the Business and Economics Departments." +
                    "Currently, the Departments of Computer Science, Mathematics and Statistics, and Philosophy and Religion occupy classrooms, teaching labs and faculty offices." +
                    "The College of Arts and Science also resides here. ",
                    "bear",
                    "(A front view of Bear Hall)",
                    "https://library.uncw.edu/web/collections/archives/bnl/19.html",
                    "34.228545",
                    "-77.87280469680556"));

            initialWorkoutObjects.add(new WorkoutObject("Dobo Hall", "Opened for use in 1996, the New Science Building contained classrooms, laboratories and faculty offices for the Chemistry and Biology Departments." +
                    "Known as Dobo Hall since its 1999 dedication to the Dobo brothers, it is currently used by the Department of Biology and Marine Biology and the Department of Chemistry.",
                    "dobo",
                    "(A front view of Dobo Hall)",
                    "https://library.uncw.edu/web/collections/archives/bnl/25.html",
                    "34.2257237",
                    "-77.86848956387306"));
            initialWorkoutObjects.add(new WorkoutObject("Cameron Hall","Funding for Cameron Hall began in 1985, with occupancy starting in 1988." +
                    "As the home of the Cameron School of Business, the building contains classrooms and faculty offices." +
                    "he official naming dedication was held on October 5, 1988.",
                    "cameron",
                    "(A front view of Cameron Hall)",
                    "https://library.uncw.edu/web/collections/archives/bnl/24.html",
                    "34.226041800000004",
                    "-77.8695462604443"));
            initialWorkoutObjects.add(new WorkoutObject("Deloach Hall", " Originally called the Physics-Chemistry Building, this structure housed classrooms for those departments." +
                    "Groundbreaking took place in July of 1967, occupation began in 1968, with the official renaming ceremony to DeLoach Hall in October of 1985." +
                    "Currently the building holds offices and classrooms for the Department of Physics, Department of Physical Oceanography and the Department of Earth Sciences." +
                    "The Department of Chemistry was housed here until Dobo Hall opened. DeLoach Hall contains a large teaching auditorium and several laboratories.",
                    "deloach",
                    "(A front view of Deloach Hall)",
                    "https://library.uncw.edu/web/collections/archives/bnl/2.html",
                    "34.228831799999995",
                    "-77.87445745000001"));

            // ObjectBox is smart enough to handle CRUD on Collections of entities
            WorkoutObjectBox.put(initialWorkoutObjects);
        }

        Box<LocationRecording> locationBox = boxStore.boxFor(LocationRecording.class);
        if (locationBox.count() == 0) {
            Random rand = new Random(System.currentTimeMillis());
            Collection<LocationRecording> itemsToAdd = new ArrayList<>();
            long millis = new Date().getTime();

            for (int i = 0; i < NUM_TO_ADD; i++) {
                double lat = (rand.nextDouble() * (latMax - latMin)) + latMin;
                double lon = (rand.nextDouble() * (lonMax - lonMin)) + lonMin;
                double acc = (rand.nextDouble() * (accMax - accMin)) + accMin;
                millis += rand.nextInt(maxMillis - minMillis) + minMillis;
                itemsToAdd.add(new LocationRecording(new Date(millis), lat, lon, acc));
            }

            locationBox.put(itemsToAdd);
        }

    }

    public BoxStore getBoxStore() {
        return boxStore;
    }
}
