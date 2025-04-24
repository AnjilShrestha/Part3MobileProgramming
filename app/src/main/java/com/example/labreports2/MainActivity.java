package com.example.labreports2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {

    Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        b1=findViewById(R.id.btnfragment1);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DynamicFragment f1=new DynamicFragment();
                FragmentTransaction ft=getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.fragmentContainer,f1);
                ft.commit();
            }
        });

    }
}