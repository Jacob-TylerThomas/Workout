package com.hfad.workout;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.util.Linkify;
import android.widget.TextView;

import java.util.regex.Pattern;

public class AboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        TextView aboutMe= findViewById(R.id.aboutMe);
        Pattern pattern = Pattern.compile("University +[a-zA-Z]+");
        aboutMe.setText(R.string.About_me_text);
        Linkify.addLinks(aboutMe, pattern, "https://library.uncw.edu/archives_special/archives");
    }







}
