package com.example.com.sgmovie;

import android.media.Image;
import android.widget.TextView;

public class Movie {
    private int mPosterResourceId;
    private String mTitle;
    //private  mRating;

    public Movie(int poster, String title) {
        mPosterResourceId = poster;
        mTitle = title;
        //mRating = rating;
    }
    public int getPosterId() {
        return mPosterResourceId;
    }
    public String getTitle() {
        return mTitle;
    }
}
