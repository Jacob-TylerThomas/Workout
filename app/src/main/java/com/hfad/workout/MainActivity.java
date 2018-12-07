package com.hfad.workout;

import android.Manifest;
import android.content.Intent;
import android.content.IntentSender;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.common.api.ResolvableApiException;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.LocationSettingsResponse;
import com.google.android.gms.location.SettingsClient;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import io.objectbox.Box;
import io.objectbox.BoxStore;

public class MainActivity extends AppCompatActivity {
    RecyclerView mRecyclerView;

    static final int MY_PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION = 001;
    private FusedLocationProviderClient mFusedLocationClient;
    private Box<LocationRecording> locationBox;
    private LocationRecordAdapter adapter;
    private BoxStore boxStore;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);


        //throws a nullpointerexception error
//        mRecyclerView = findViewById(R.id.card_view);
//        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
//        adapter = new LocationRecordAdapter(locationBox);
//        mRecyclerView.setAdapter(adapter);
//        mRecyclerView.addItemDecoration(new DividerItemDecoration(this,
//                DividerItemDecoration.VERTICAL));
        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(this);

//        mLocationCallback = new LocationCallback() {
//            @Override
//            public void onLocationResult(LocationResult locationResult) {
//                if (locationResult != null) {
//                    for (Location location : locationResult.getLocations()) {
//                        latText.setText(String.format("%.7f", location.getLatitude()));
//                        lonText.setText(String.format("%.7f", location.getLongitude()));
//                        accuracyText.setText(String.format("%.2f", location.getAccuracy()));
//
//                        locationBox.put(new LocationRecording(new Date(location.getTime()), location.getLatitude(), location.getLongitude(), location.getAccuracy()));
//                        adapter.notifyDataSetChanged();
//                    }
//                }
//            }
//        };
//
//        if (savedInstanceState != null) {
//            latText.setText(savedInstanceState.getCharSequence(LATITUDE_KEY));
//            lonText.setText(savedInstanceState.getCharSequence(LONGITUDE_KEY));
//            accuracyText.setText(savedInstanceState.getCharSequence(ACCURACY_KEY));
//        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the app bar.
        getMenuInflater().inflate(R.menu.about, menu);
//        getMenuInflater().inflate(R.menu.menu_nav, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.info:
                //Code to run when the Create Order item is clicked
                Intent intent = new Intent(this, AboutActivity.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    //@Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();
        Fragment fragment = null;
        Intent intent = null;
        switch (id) {
            case R.id.aboutMe:
                intent = new Intent(this, AboutActivity.class);
                break;
            default:
                fragment = new WorkoutListFragment();
        }
        startActivity(intent);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    //    @Override
    public void itemClicked(long id) {
        View fragmentContainer = findViewById(R.id.fragment_container);
        if (fragmentContainer != null) {
            WorkoutDetailFragment details = new WorkoutDetailFragment();
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            details.setWorkout(id);
            ft.replace(R.id.fragment_container, details);
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            ft.addToBackStack(null);
            ft.commitAllowingStateLoss();
        } else {
            Intent intent = new Intent(this, DetailActivity.class);
            intent.putExtra(DetailActivity.EXTRA_WORKOUT_ID, (int) id);
            startActivity(intent);
        }
    }
    private  HashMap sortByValues(HashMap map) {
        List list = new LinkedList(map.entrySet());
        // Defined Custom Comparator here
        Collections.sort(list, new Comparator() {
            public int compare(Object o1, Object o2) {
                return ((Comparable) ((Map.Entry) (o1)).getValue())
                        .compareTo(((Map.Entry) (o2)).getValue());
            }
        });

        // Here I am copying the sorted list in HashMap
        // using LinkedHashMap to preserve the insertion order
        HashMap sortedHashMap = new LinkedHashMap();
        for (Iterator it = list.iterator(); it.hasNext();) {
            Map.Entry entry = (Map.Entry) it.next();
            sortedHashMap.put(entry.getKey(), entry.getValue());
        }
        System.out.print(sortedHashMap);
        map=sortedHashMap;
        return sortedHashMap;
    }
    public void recordClick(View view) {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.ACCESS_FINE_LOCATION)) {
                // Show an explanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.
            } else {
                // No explanation needed; request the permission
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                        MY_PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION);
            }
        } else {
            //Toast.makeText(this, "Permission granted.", Toast.LENGTH_SHORT).show();
            mFusedLocationClient.getLastLocation()
                    .addOnSuccessListener(this, new OnSuccessListener<Location>() {
                        @Override
                        public void onSuccess(Location location) {
                            // Got last known location. In some rare situations this can be null.
                            Button nearBuiling = findViewById(R.id.nearestBuilding);
                            if (location != null) {
//                                itemClicked(0);
                                boxStore = ((App)getApplication()).getBoxStore();
                                Box<WorkoutObject> WorkoutObjectBox = boxStore.boxFor(WorkoutObject.class);
                                List<WorkoutObject> workoutList= WorkoutObjectBox.getAll();
                                String[] latitutdes = new String[workoutList.size()];
                                //run a sorting algorithm on the list to be able to get the lowest distance
                                for (int i = 0; i < workoutList.size(); i++) {
                                    //figure out how to make a double list
                                    latitutdes[i] = workoutList.get(i).getLatitude();
                                }

                                String[] longitudes = new String[workoutList.size()];
                                //run a sorting algorithm on the list to be able to get the lowest distance
                                for (int i = 0; i < workoutList.size(); i++) {
                                    //figure out how to make a double list
                                    longitudes[i] = workoutList.get(i).getLatitude();
                                }
                                Double[] distances = new Double[5];

                                for (double i = 0; i < latitutdes.length; i++) {
                                    for (double j = 0; j < longitudes.length; j++) {


                                        double distance = Math.sqrt(Math.pow((location.getLatitude()-i),2) + Math.pow((location.getLongitude()-j),2));
                                        distances[(int) j] = distance;
                                    }
                                }
                                System.out.print(distances);
                                HashMap<String, Double> map = new HashMap<String, Double>();
                                for (long i = 0; i < workoutList.size(); i++) {
                                    for (double j = 0; j < distances.length; j++) {
                                        map.put(workoutList.get((int) i).getBuildId(),distances[(int) i]);

                                    }
                                }
                                System.out.print(map);
                                sortByValues(map);
                                System.out.print(map);

                                nearBuiling.setText(String.format("\n Longitude: %1$s \\n Latitude: %2$s\",",location.getLatitude(), location.getLongitude()));


                            }
                        }
                    });
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // permission was granted, yay! Do the
                    // contacts-related task you need to do.
                } else {
                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                }
                return;
            }

            // other 'case' lines to check for other
            // permissions this app might request.
        }
    }

//    private static int REQUEST_CHECK_SETTINGS = 123;
//    private LocationRequest mLocationRequest;
//    private LocationCallback mLocationCallback;
//    private static String LATITUDE_KEY = "latitude";
//    private static String LONGITUDE_KEY = "longitude";
//    private static String ACCURACY_KEY = "accuracy";
//
//    /**
//     * This method is called to kick off the chain of events that requests continuous location updates.
//     */
//    protected void createLocationRequest() {
//        if (mLocationRequest == null) {
//            mLocationRequest = new LocationRequest();
//            mLocationRequest.setInterval(10000);
//            mLocationRequest.setFastestInterval(5000);
//            mLocationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
//        }
//
//        LocationSettingsRequest.Builder builder = new LocationSettingsRequest.Builder()
//                .addLocationRequest(mLocationRequest);
//
//        SettingsClient client = LocationServices.getSettingsClient(this);
//        Task<LocationSettingsResponse> task = client.checkLocationSettings(builder.build());
//
//        task.addOnSuccessListener(this, new OnSuccessListener<LocationSettingsResponse>() {
//            @Override
//            public void onSuccess(LocationSettingsResponse locationSettingsResponse) {
//                // All location settings are satisfied. The client can initialize
//                // location requests here.
//                // ...
//                startLocationUpdates();
//            }
//        });
//
//        task.addOnFailureListener(this, new OnFailureListener() {
//            @Override
//            public void onFailure(@NonNull Exception e) {
//                if (e instanceof ResolvableApiException) {
//                    // Location settings are not satisfied, but this can be fixed
//                    // by showing the user a dialog.
//                    try {
//                        // Show the dialog by calling startResolutionForResult(),
//                        // and check the result in onActivityResult().
//                        ResolvableApiException resolvable = (ResolvableApiException) e;
//                        resolvable.startResolutionForResult(MainActivity.this,
//                                REQUEST_CHECK_SETTINGS);
//                    } catch (IntentSender.SendIntentException sendEx) {
//                        // Ignore the error.
//                    }
//                }
//            }
//        });
//    }
//
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//
//        if (requestCode == REQUEST_CHECK_SETTINGS) {
//            // Regardless of whether the user fixed the issue or not, try again.
//            // This could be really annoying for the user...
//            // In reality, you should check the resultCode for success. If not successful, you
//            // should degrade the functionality.
//            createLocationRequest();
//        }
//    }
//
//    //causes app to freeze when clicking buildings
//    //causes app to crash when you give location permissions
////    @Override
////    protected void onResume() {
////        super.onResume();
////        createLocationRequest();
////        //cause of issue
////    }
//
//    private void startLocationUpdates() {
//        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
//                != PackageManager.PERMISSION_GRANTED) {
//            //commented about because it kept popping up repeatedly
////            Toast.makeText(this, "I need permission to access location in order to record locations.", Toast.LENGTH_SHORT).show();
//
//            ActivityCompat.requestPermissions(this,
//                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
//                    MY_PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION);
//        } else {
//            mFusedLocationClient.requestLocationUpdates(mLocationRequest,
//                    mLocationCallback,
//                    null /* Looper */);
//        }
//    }
//
////    @Override
////    protected void onPause() {
////        super.onPause();
////        mFusedLocationClient.removeLocationUpdates(mLocationCallback);
////    }
//
//    @Override
//    protected void onSaveInstanceState(Bundle outState) {
////        outState.putCharSequence(LATITUDE_KEY, latText.getText());
////        outState.putCharSequence(LONGITUDE_KEY, lonText.getText());
////        outState.putCharSequence(ACCURACY_KEY, accuracyText.getText());
//        super.onSaveInstanceState(outState);
//    }

}