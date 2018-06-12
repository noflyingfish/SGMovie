package com.example.com.sgmovie;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
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

    //required constructor
    public InfoFragment(){
        // empty
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Bundle bundle = this.getArguments();
        if (bundle != null) {
            movie = bundle.getParcelable("movie");
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.info, container, false);

        if (movie != null) {
            TextView textView = null;

            textView = (TextView) textView.findViewById(R.id.movie_detail_title);
            textView.setText(movie.getTitle());

            textView = (TextView) textView.findViewById(R.id.movie_detail_director);
            textView.setText(movie.getDirector());

            textView = (TextView) textView.findViewById(R.id.movie_detail_cast);
            textView.setText(movie.getCast());

            textView = (TextView) textView.findViewById(R.id.movie_detail_genre);
            textView.setText(movie.getOthers());

            textView = (TextView) textView.findViewById(R.id.movie_detail_opening);
            textView.setText(movie.getOpening());

            textView = (TextView) textView.findViewById(R.id.movie_detail_synopsis);
            textView.setText(movie.getSynopsis());

            ImageView imageView = (ImageView) textView.findViewById(R.id.movie_detail_poster);
            imageView.setImageResource(movie.getPosterResourceId());

            WebView webView = (WebView) textView.findViewById(R.id.movie_detail_trailer);
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
