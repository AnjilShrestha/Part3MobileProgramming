package com.example.labreports2;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


public class InputFragment extends Fragment {

    Button b1;
    EditText t1,t2,t3;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_input, container, false);
        b1=v.findViewById(R.id.btnCalculate);
        t1=v.findViewById(R.id.length);
        t2=v.findViewById(R.id.width);
        t3=v.findViewById(R.id.height);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double l=Double.parseDouble(t1.getText().toString());
                Double w=Double.parseDouble(t2.getText().toString());
                Double h=Double.parseDouble(t3.getText().toString());
                DisplayFragment d=new DisplayFragment();
                Bundle bn=new Bundle();
                bn.putDouble("l",l);
                bn.putDouble("w",w);
                bn.putDouble("h",h);

                d.setArguments(bn);
                FragmentTransaction ft=getActivity().getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.outputContainer, d);
                ft.commit();
            }
        });
        return v;
    }
}