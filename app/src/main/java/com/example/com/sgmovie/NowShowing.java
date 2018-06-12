package com.example.com.sgmovie;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class NowShowing extends AppCompatActivity {

    private String movieName;
    private ArrayList<Movie> movieList;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nowshowing_main);

        // take over the arraylist of movie
        movieList = this.getIntent().getExtras().getParcelableArrayList("movieList");

        //OnClickListener for button
        Button searchButton = findViewById(R.id.button_search);
        searchButton.setOnClickListener(searchOnClickListener);

        // setting the adapter for the nowshowing list
        NowShowingAdapter adapter = new NowShowingAdapter(NowShowing.this, movieList);
        final ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);

        // set each list view to be clickable
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                // launch the function page for that movie
                Intent intent = new Intent(NowShowing.this, FunctionMain.class);
                intent.putExtra("movie", movieList.get(position));

                if(movieList.get(position) == null)
                    Log.v("EEEEEEEEEE", "passsed?");
                else
                    Log.v("FFFFFFFFFFFFFF", "pos in arraylist"+position );

                startActivity(intent);
            }
        });
    }

    // method for click listener on button
    private View.OnClickListener searchOnClickListener = new View.OnClickListener() {

        @Override
        public void onClick(View view) {

            //Get the user input movie name
            movieName = readInput();

            if (movieName.equals("")) {
                Toast emptyInput = Toast.makeText(NowShowing.this, "Please enter a movie name", Toast.LENGTH_SHORT);
                emptyInput.show();
            } else {
                // input is present
                Movie temp = null;
                for (Movie m : movieList) {
                    if (m.getTitle().toLowerCase().equals(movieName))
                        temp = m;
                }

                if (temp != null) { // input match data base movie name
                    Intent intent = new Intent(NowShowing.this, FunctionMain.class);
                    intent.putExtra("movie", temp);
                    startActivity(intent);
                } else {
                    Toast noSuchMovie = Toast.makeText(NowShowing.this, "PLease enter a correct movie name", Toast.LENGTH_SHORT);
                    noSuchMovie.show();
                }
            }
        }
    };

    // method to read the input from the search bar
    protected String readInput() {
        EditText movieNameInput = findViewById(R.id.searchMovieName);
        return movieNameInput.getText().toString();
    }
}


