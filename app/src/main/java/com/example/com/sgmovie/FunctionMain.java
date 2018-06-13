package com.example.com.sgmovie;

import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class FunctionMain extends AppCompatActivity {

    public static Movie currMovie; // used to pass the varible into InfoFragment

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.function_main);

        // getting the movie object passed from the main page
        currMovie = getIntent().getExtras().getParcelable("movie");

        if(currMovie == null)
            Log.v("CCCCCCCCCCCCCC", "FAIL");
        else
            Log.v("DDDDDDDDDDDDDD", "PASS");

        // set the title of the page to the movie name
        setTitle(currMovie.getTitle());

        // Find the view pager that will allow the user to swipe between fragments
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        // Set up view pager
        setupViewPager(viewPager);

        // Find the tab layout that shows the tabs
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        // Connect the tab layout with the view pager
        tabLayout.setupWithViewPager(viewPager);

        // pass the movie object into the infofragment, replaced by the public static variable.
        //Bundle bundle = new Bundle();
        //bundle.putParcelable("movie", movie);
        //if(bundle != null) Log.v("QQQQQQ", "bundle !empty @ function main");
        //InfoFragment frag = new InfoFragment();
        //frag.setArguments(bundle);
    }

    private void setupViewPager(ViewPager viewPager) {
        FunctionAdapter adapter = new FunctionAdapter(FunctionMain.this, getSupportFragmentManager());
        adapter.addFragment(new TicketFragment(), "TICKET");
        adapter.addFragment(new InfoFragment(), "SYNOPSIS");
        adapter.addFragment(new ReviewFragment(), "REVIEW");

        viewPager.setAdapter(adapter);
    }

}
