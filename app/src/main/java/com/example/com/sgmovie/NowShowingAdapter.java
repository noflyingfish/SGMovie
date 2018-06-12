package com.example.com.sgmovie;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class NowShowingAdapter extends ArrayAdapter<Movie> {

    /**
     * Create a new {@link NowShowingAdapter} object.
     *
     * @param context is the current context (i.e. Activity) that the adapter is being created in.
     * @param movieList is the list of {@link Movie}s to be displayed.
     */
    public NowShowingAdapter(Context context, ArrayList<Movie> movieList) {
        super(context, 0, movieList);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if an existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.nowshowing_list, parent, false);
        }

        // Get the {@link Movie} object located at this position in the list
        Movie currentMovie = getItem(position);

        // Find the TextView in layout with movie_title id
        TextView movieTitle = (TextView) listItemView.findViewById(R.id.movie_title);
        // Set the title to the title in the Movie object
        movieTitle.setText(currentMovie.getTitle());

        TextView movieDate = (TextView) listItemView.findViewById(R.id.movie_date);
        movieDate.setText(currentMovie.getOpening());


        TextView movieRating = (TextView) listItemView.findViewById(R.id.movie_rating);
        movieRating.setText(currentMovie.getRating());

        TextView movieGenre = (TextView) listItemView.findViewById((R.id.movie_genre));
        movieGenre.setText(currentMovie.getOthers());

        // Find the ImageView in the list_item.xml layout with the ID image.
        ImageView poster = (ImageView) listItemView.findViewById(R.id.movie_poster);
        if (currentMovie.hasImage()) {
            // If an image is available, display the provided image based on the resource ID
            poster.setImageResource(currentMovie.getImageResourceId());
            poster.setVisibility(View.VISIBLE);
        } else {
            // Otherwise hide the ImageView (set visibility to GONE)
            poster.setVisibility(View.GONE);
        }

        return listItemView;
    }

}
