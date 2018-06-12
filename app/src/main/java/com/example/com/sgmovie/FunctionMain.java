package com.example.com.sgmovie;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class FunctionMain extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.function_main);

        Log.v("1", "check create function main xml");

        // getting the movie object passed from the main page
        Movie movie = getIntent().getParcelableExtra("movie");

        // set the title of the page to the movie name
        setTitle(movie.getTitle());

        // Find the view pager that will allow the user to swipe between fragments
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        // Set up view pager
        setupViewPager(viewPager);

        // Find the tab layout that shows the tabs
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        // Connect the tab layout with the view pager
        tabLayout.setupWithViewPager(viewPager);
    }

    private void setupViewPager(ViewPager viewPager) {
        FunctionAdapter adapter = new FunctionAdapter(FunctionMain.this, getSupportFragmentManager());
        adapter.addFragment(new TicketFragment(), "TICKET");
        adapter.addFragment(new InfoFragment(), "SYNOPSIS");
        adapter.addFragment(new ReviewFragment(), "REVIEW");

        viewPager.setAdapter(adapter);
    }

}
