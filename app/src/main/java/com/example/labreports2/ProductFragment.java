package com.example.labreports2;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class ProductFragment extends Fragment {

   Button b1;
   EditText t1,t2;
   TextView res;
   double sp,cp,p;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_product, container, false);
        t1=v.findViewById(R.id.cp);
        t2=v.findViewById(R.id.sp);
        b1=v.findViewById(R.id.btnProfitLoss);
        res=v.findViewById(R.id.result);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cp=Double.parseDouble(t1.getText().toString());
                sp=Double.parseDouble(t2.getText().toString());
                if(sp>cp){
                    p=((sp-cp)/cp)*100;
                    res.setText("Profit%="+p);
                }else{
                    double l=((cp-sp)/cp)*100;
                    res.setText("Loss="+l);
                }
            }
        });
        return v;
    }
}