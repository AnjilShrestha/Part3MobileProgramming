package com.example.labreports2;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class DisplayFragment extends Fragment {


    TextView txtres;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v= inflater.inflate(R.layout.fragment_display, container, false);
        txtres=v.findViewById(R.id.txtOutput);
        Bundle bn=this.getArguments();
        Double l=bn.getDouble("l");
        Double w=bn.getDouble("w");
        Double h=bn.getDouble("h");
        Double area=l*w+w*h+l*h;
        Double volume=l*w*h;
        String text="Area="+area+"\nVolume="+volume;
        txtres.setText(text);
        return v;
    }
}