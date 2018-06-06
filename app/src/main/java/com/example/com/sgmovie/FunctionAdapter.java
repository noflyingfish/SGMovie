package com.example.com.sgmovie;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class FunctionAdapter extends FragmentPagerAdapter {

    private Context appContext;

    /**
     * Create a new {@link FunctionAdapter} object.
     * @param context is the context of the app
     * @param fm is fragment manager that keep each fragment's state in the adapter across swipes.
     */
    public FunctionAdapter(Context context, FragmentManager fm) {
        super(fm);
        appContext = context;
    }

    // return the {@link Fragment} that should be displayed for the given page number.
    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new TicketFragment();
        } else if (position == 1) {
            return new InfoFragment();
        } else if (position == 2) {
            return new TrailerFragment();
        } else {
            return new ReviewFragment();
        }
    }

    // the page title of each tab
    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return appContext.getString(R.string.function_booking);
        } else if (position == 1) {
            return appContext.getString(R.string.function_info);
        } else if (position == 2) {
            return appContext.getString(R.string.function_trailer);
        } else {
            return appContext.getString(R.string.function_review);
        }
    }

    // total number of tabs
    @Override
    public int getCount() {
        return 4;
    }
}
