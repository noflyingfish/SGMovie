package com.example.com.sgmovie;

import android.app.Activity;
import android.content.Intent;
import android.gesture.GestureOverlayView;
import android.os.Bundle;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    private String movieName;
    private GestureDetectorCompat swipe;
    private ArrayList<Movie> movieList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //GestureDetector for swiping up for "now placeholder_img"
        swipe = new GestureDetectorCompat(MainActivity.this, new MainPageGestureListener());

        //OnClickListener for button
        Button searchButton = findViewById(R.id.button_search);
        searchButton.setOnClickListener(searchOnClickListener);

        // method to add in place holder data
        fakedata();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        MainActivity.this.swipe.onTouchEvent(event);
        return super.onTouchEvent(event);
    }

    //nested class for the gestureListener to swipe up/ fling up
    class MainPageGestureListener extends GestureDetector.SimpleOnGestureListener {

        // Fling up for fast swipe, same as swipe up
        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            // swipe up for intent
            if (e1.getY() > e2.getY()) {
                Intent nowshowing = new Intent(MainActivity.this, NowShowing.class);
                Bundle bundle = new Bundle();
                bundle.putParcelableArrayList("movieList", movieList);
                nowshowing.putExtras(bundle);
                startActivity(nowshowing);
            }
            return true;
        }

        // reccommended to return true -- android dev site
        @Override
        public boolean onDown(MotionEvent e) {
            return true;
        }
    }

    private View.OnClickListener searchOnClickListener = new View.OnClickListener() {

        @Override
        public void onClick(View view) {

            //Get the user input movie name
            movieName = readInput().toLowerCase();

            if (movieName.equals("")) {
                Toast emptyInput = Toast.makeText(MainActivity.this, "Please enter a movie name", Toast.LENGTH_SHORT);
                emptyInput.show();
            } else {
                // input is present
                Movie temp = null;
                for(Movie m : movieList){
                    if(m.getTitle().toLowerCase().equals(movieName))
                        temp = m;
                }

                if(temp != null){ // input match data base movie name
                    Intent intent = new Intent( MainActivity.this, FunctionMain.class);
                    intent.putExtra("movie", temp);
                    startActivity(intent);
                } else {
                    Toast noSuchMovie = Toast.makeText(MainActivity.this, "PLease enter a correct movie name", Toast.LENGTH_SHORT);
                    noSuchMovie.show();
                }
            }
        }
    };

    protected String readInput() {
        EditText movieNameInput = findViewById(R.id.searchMovieName);
        return movieNameInput.getText().toString();
    }

    // the temp method to add in 6x fake movie data entry
    private void fakedata() {
        movieList.add(new Movie(R.drawable.placeholder_img,
                "Placeholder title 1",
                "Placeholder Genre 1",
                "PLaceholder director 1",
                "Placeholder cast 1",
                "Place holder opening 1 ",
                "Placeholder rating 1",
                "PLACE HOLDER SYNOPSIS 1+ \n + PLACE HOLDER SYNOPSIS 1 + \n +PLACE HOLDER SYNOPSIS 1 ",
                "https://youtu.be/Oai8MbSxfrc"));

        movieList.add(new Movie(R.drawable.placeholder_img,
                "Placeholder title 2",
                "Placeholder Genre 2",
                "PLaceholder director 2",
                "Placeholder cast 2",
                "Place holder opening 2 ",
                "Placeholder rating 2",
                "PLACE HOLDER SYNOPSIS 2+ \n + PLACE HOLDER SYNOPSIS 2 + \n +PLACE HOLDER SYNOPSIS 2 ",
                "https://youtu.be/Oai8MbSxfrc"));

        movieList.add(new Movie(R.drawable.placeholder_img,
                "Placeholder title 3",
                "Placeholder Genre 3",
                "PLaceholder director 3",
                "Placeholder cast 3",
                "Place holder opening 3",
                "Placeholder rating 3",
                "PLACE HOLDER SYNOPSIS 3+ \n + PLACE HOLDER SYNOPSIS 3 + \n +PLACE HOLDER SYNOPSIS 3",
                "https://youtu.be/Oai8MbSxfrc"));

        movieList.add(new Movie(R.drawable.placeholder_img,
                "Placeholder title 4",
                "Placeholder Genre 4",
                "PLaceholder director 4",
                "Placeholder cast 4",
                "Place holder opening 4",
                "Placeholder rating 4",
                "PLACE HOLDER SYNOPSIS 4+ \n + PLACE HOLDER SYNOPSIS 4 + \n +PLACE HOLDER SYNOPSIS 4 ",
                "https://youtu.be/Oai8MbSxfrc"));

        movieList.add(new Movie(R.drawable.placeholder_img,
                "Placeholder title 5",
                "Placeholder Genre 5",
                "PLaceholder director 5",
                "Placeholder cast 5",
                "Place holder opening 5",
                "Placeholder rating 5",
                "PLACE HOLDER SYNOPSIS 5+ \n + PLACE HOLDER SYNOPSIS 5 + \n +PLACE HOLDER SYNOPSIS 5",
                "https://youtu.be/Oai8MbSxfrc"));

        movieList.add(new Movie(R.drawable.placeholder_img,
                "Placeholder title 6",
                "Placeholder Genre 6",
                "PLaceholder director 6",
                "Placeholder cast 6",
                "Place holder opening 6",
                "Placeholder rating 6",
                "PLACE HOLDER SYNOPSIS 6+ \n + PLACE HOLDER SYNOPSIS 6 + \n +PLACE HOLDER SYNOPSIS 6",
                "https://youtu.be/Oai8MbSxfrc"));
    }
}
