package com.example.com.sgmovie;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class FunctionAdapter extends FragmentPagerAdapter {

    private Context appContext;
    private ArrayList<Fragment> tabList = new ArrayList<Fragment>();
    private ArrayList<String> tabTitle = new ArrayList<String>();

    /**
     * Create a new {@link FunctionAdapter} object.
     *
     * @param context is the context of the app
     * @param fm      is fragment manager that keep each fragment's state in the adapter across swipes.
     */
    public FunctionAdapter(Context context, FragmentManager fm) {
        super(fm);
        appContext = context;
    }

    // add additional tabs to the list
    public void addFragment(Fragment fragment, String title) {
        tabList.add(fragment);
        tabTitle.add(title);
    }

    // return the {@link Fragment} that should be displayed for the given page number.
    public Fragment getItem(int position) {
        return tabList.get(position);
    }

    // the page title of each tab
    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitle.get(position);
    }

    // total number of tabs
    @Override
    public int getCount() {
        return tabList.size();
    }
}
