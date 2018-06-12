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

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.function_main);

        // getting the movie object passed from the main page
        Movie movie = getIntent().getExtras().getParcelable("movie");

        if(movie == null)
            Log.v("CCCCCCCCCCCCCC", "FAIL");
        else
            Log.v("DDDDDDDDDDDDDD", "PASS");

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

        // pass the movie object into the infofragment
        Bundle bundle = new Bundle();
        bundle.putParcelable("movie", movie);
        InfoFragment frag = new InfoFragment();
        frag.setArguments(bundle);
        //getSupportFragmentManager().beginTransaction().replace(R.id.viewpager,InfoFragment).commit();

    }

    private void setupViewPager(ViewPager viewPager) {
        FunctionAdapter adapter = new FunctionAdapter(FunctionMain.this, getSupportFragmentManager());
        adapter.addFragment(new TicketFragment(), "TICKET");
        adapter.addFragment(new InfoFragment(), "SYNOPSIS");
        adapter.addFragment(new ReviewFragment(), "REVIEW");

        viewPager.setAdapter(adapter);
    }

}
