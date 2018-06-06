package com.example.com.sgmovie;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class MovieAdapter extends ArrayAdapter<Movie> {

    public MovieAdapter (Activity context, ArrayList<Movie> movies) {
        super(context, 0, movies);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // if the currentview is empty, add it, otherwise recycle it.
        View listItemView = convertView;
        if (listItemView  == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.grid_view, parent, false);
        }

        //recycle.
        //find current movie item.
        Movie currentMovie = getItem(position);

        //recycle the movie poster.
        //ImageView posterView = (ImageView) listItemView.findViewById(R.id.movie_poster);
       // posterView.setImageResource(currentMovie.getPosterId());

        //recycle the movie title.
        //TextView titleView = (TextView) listItemView.findViewById(R.id.movie);
        //titleView.setText(currentMovie.getTitle());
        return listItemView;
    }
}
