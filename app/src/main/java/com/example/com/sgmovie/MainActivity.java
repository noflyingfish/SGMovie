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


public class MainActivity extends AppCompatActivity{

    private String movieName;
    private GestureDetectorCompat swipe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //GestureDetector for swiping up for "now showing"
        swipe = new GestureDetectorCompat(MainActivity.this, new MainPageGestureListener());

        //OnClickListener for button
        Button searchButton = findViewById(R.id.button_search);
        searchButton.setOnClickListener(searchOnClickListener);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        MainActivity.this.swipe.onTouchEvent(event);
        return super.onTouchEvent(event);
    }

    //Method for the gestureListener to swipe up/ fling up
    class MainPageGestureListener extends GestureDetector.SimpleOnGestureListener{

        // Fling up for fast swipe, same as swipe up
        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            // swipe down for intent
            if(e1.getY() > e2.getY()) {
                Intent nowshowing = new Intent(MainActivity.this, NowShowing.class);
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
            movieName = readInput();

            if (movieName.equals("")) {
                Toast emptyInput = Toast.makeText(MainActivity.this, "Please enter a movie name", Toast.LENGTH_SHORT);
                emptyInput.show();
            } else {
                // Name is valid, display movie info
                Intent search = new Intent(MainActivity.this, FunctionMain.class);
                search.putExtra("key_movieName", movieName);
                startActivity(search);
            }
        }
    };
    protected String readInput() {
        EditText movieNameInput = findViewById(R.id.searchMovieName);
        return movieNameInput.getText().toString();
    }
}
