package com.example.com.sgmovie;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class InfoFragment extends Fragment{

    private Movie movie;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.info, container, false);
        Bundle bundle = getArguments();
        movie = bundle.getParcelable("movie");

        if(movie == null)
            Log.v("AAAAAAAAAAAA", "FAIL");
        else
            Log.v("BBBBBBBBBBBBB", "PASS");

        if (movie != null) {

            TextView title = (TextView) rootView.findViewById(R.id.movie_detail_title);
            title.setText(movie.getTitle());

            TextView director = (TextView) rootView.findViewById(R.id.movie_detail_director);
            director.setText(movie.getDirector());

            TextView cast = (TextView) rootView.findViewById(R.id.movie_detail_cast);
            cast.setText(movie.getCast());

            TextView genre = (TextView) rootView.findViewById(R.id.movie_detail_genre);
            genre.setText(movie.getOthers());

            TextView opening = (TextView) rootView.findViewById(R.id.movie_detail_opening);
            opening.setText(movie.getOpening());

            TextView synopsis = (TextView) rootView.findViewById(R.id.movie_detail_synopsis);
            synopsis.setText(movie.getSynopsis());

            ImageView imageView = (ImageView) rootView.findViewById(R.id.movie_detail_poster);
            imageView.setImageResource(movie.getPosterResourceId());

            WebView webView = (WebView) rootView.findViewById(R.id.movie_detail_trailer);
            webView.getSettings().setJavaScriptEnabled(true);
            webView.setWebViewClient(new WebViewClient(){
                @Override
                public boolean shouldOverrideUrlLoading(WebView view, String url) {
                    return false;
                }
            });
            webView.loadData(
                    "<html><body>Movie Trailer <br> <iframe width=\"100%\" height=\"80%\" src=\"https://www.youtube.com/embed/jXmPkWDeAcE\" frameborder=\"0\" allowfullscreen></iframe></body></html>", "text/html", "utf-8");
        } else {
            System.out.println("123error");
        }
        return rootView;
    }
}
