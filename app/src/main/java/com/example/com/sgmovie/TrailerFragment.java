package com.example.com.sgmovie;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class TrailerFragment extends Fragment {

    //required constructor
    public TrailerFragment(){
        // empty
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.trailer, container, false);
        Button btnTEST = (Button) rootView.findViewById(R.id.btnTEST);

        btnTEST.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast temp = Toast.makeText(getActivity(), "TESTING BUTTON TRAILER PAGE",Toast.LENGTH_SHORT);
                temp.show();
            }
        });

        return rootView;
    }

}
