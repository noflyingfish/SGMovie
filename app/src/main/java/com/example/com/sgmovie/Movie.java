package com.example.com.sgmovie;

import android.media.Image;
import android.os.Parcel;
import android.os.Parcelable;
import android.widget.TextView;

public class Movie implements Parcelable {

    public static final Creator<Movie> CREATOR = new Creator<Movie>() {
        @Override
        public Movie createFromParcel(Parcel in) {
            return new Movie(in);
        }

        @Override
        public Movie[] newArray(int size) {
            return new Movie[size];
        }
    };

    private static final int NO_IMAGE = -1;
    private int mPosterResourceId = NO_IMAGE;
    private String mTitle;
    private String mOthers;
    private String mDirector;
    private String mCast;
    private String mOpening;
    private String mRating;
    private String mSynopsis;
    private String mTrailerAddress;


    public Movie(int PosterResourceId,
                 String title,
                 String genre,
                 String director,
                 String cast,
                 String opening,
                 String rating,
                 String synopsis,
                 String trailerAddress) {
        mPosterResourceId = PosterResourceId;
        this.mTitle = title;
        this.mOthers = genre;
        this.mDirector = director;
        this.mCast = cast;
        this.mOpening = opening;
        this.mRating = rating;
        this.mSynopsis = synopsis;
        this.mTrailerAddress = trailerAddress;
    }

    protected Movie(Parcel in) {
        mPosterResourceId = in.readInt();
        mTitle = in.readString();
        mOthers = in.readString();
        mDirector = in.readString();
        mCast = in.readString();
        mOpening = in.readString();
        mRating = in.readString();
        mSynopsis = in.readString();
        mTrailerAddress = in.readString();
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(mPosterResourceId);
        dest.writeString(mTitle);
        dest.writeString(mOthers);
        dest.writeString(mDirector);
        dest.writeString(mCast);
        dest.writeString(mOpening);
        dest.writeString(mRating);
        dest.writeString(mSynopsis);
        dest.writeString(mTrailerAddress);

    }

    public int getPosterResourceId() {
        return mPosterResourceId;
    }

    public String getTitle() {
        return mTitle;
    }

    public String getDirector() {
        return mDirector;
    }

    public String getRating() {
        return mRating;
    }

    public String getCast() {
        return mCast;
    }

    public boolean hasImage() {
        return mPosterResourceId != NO_IMAGE;
    }

    public int getImageResourceId() { return mPosterResourceId; }


    public String getOthers() {
        return mOthers;
    }

    public String getSynopsis() {
        return mSynopsis;
    }

    public String getTrailerAddress() {
        return mTrailerAddress;
    }

    public String getOpening() {return mOpening;}
}
