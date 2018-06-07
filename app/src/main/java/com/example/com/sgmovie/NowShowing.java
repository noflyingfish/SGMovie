package com.example.com.sgmovie;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class NowShowing extends AppCompatActivity {

    private String movieName;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nowshowing_main);


        //OnClickListener for button
        Button searchButton = findViewById(R.id.button_search);
        searchButton.setOnClickListener(searchOnClickListener);

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
                // Name is valid, display movie info
                Intent search = new Intent(NowShowing.this, FunctionMain.class);
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


