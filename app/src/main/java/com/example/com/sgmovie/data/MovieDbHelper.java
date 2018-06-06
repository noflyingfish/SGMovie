package com.example.com.sgmovie.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.com.sgmovie.data.MovieContract;

public class MovieDbHelper extends SQLiteOpenHelper{
    // If you change the database schema, you need to increase the database version.
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "SGMovie.db";

    private static final String TEXT_TYPE = " TEXT";
    private static final String COMMA = ",";
    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + MovieContract.MovieEntry.TABLE_NAME + " (" +
                    MovieContract.MovieEntry._ID + " INTEGER PRIMARY KEY," +
                    MovieContract.MovieEntry.COLUMN_TITLE + TEXT_TYPE + COMMA +
                    MovieContract.MovieEntry.COLUMN_RATED + TEXT_TYPE + COMMA +
                    MovieContract.MovieEntry.COLUMN_GENRE + TEXT_TYPE + COMMA +
                    MovieContract.MovieEntry.COLUMN_LANGUAGE + TEXT_TYPE + COMMA +
                    MovieContract.MovieEntry.COLUMN_DURATION + TEXT_TYPE + COMMA +
                    MovieContract.MovieEntry.COLUMN_RELEASE + TEXT_TYPE + COMMA +
                    MovieContract.MovieEntry.COLUMN_DIRECTOR + TEXT_TYPE + COMMA +
                    MovieContract.MovieEntry.COLUMN_CAST + TEXT_TYPE + COMMA +
                    MovieContract.MovieEntry.COLUMN_SYNOPSIS + TEXT_TYPE + COMMA +
                    " )";

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + MovieContract.MovieEntry.TABLE_NAME;

    public MovieDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }
}
