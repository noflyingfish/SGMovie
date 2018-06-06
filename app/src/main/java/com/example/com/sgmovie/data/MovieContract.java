package com.example.com.sgmovie.data;

import android.provider.BaseColumns;

public final class MovieContract {

    public static abstract class MovieEntry implements BaseColumns {

        public static final String TABLE_NAME = "movie";

        public static final String _ID = BaseColumns._ID;
        public static final String COLUMN_TITLE = "title";
        public static final String COLUMN_RATED = "rated";
        public static final String COLUMN_DIRECTOR = "director";
        public static final String COLUMN_RELEASE = "release";
        public static final String COLUMN_GENRE = "genre";
        public static final String COLUMN_DURATION = "duration";
        public static final String COLUMN_LANGUAGE = "language";
        public static final String COLUMN_CAST = "cast";
        public static final String COLUMN_SYNOPSIS = "synopsis";

    }
}
