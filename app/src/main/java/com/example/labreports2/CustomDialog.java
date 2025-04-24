package com.example.labreports2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class CustomDialog extends AppCompatActivity {

    Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_custom_dialog);
        b1=findViewById(R.id.btnCustom);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                androidx.appcompat.app.AlertDialog.Builder builder=new androidx.appcompat.app.AlertDialog.Builder(CustomDialog.this);
                builder.setTitle("Simple Interest");
                builder.setCancelable(true);

                //inflate customlayout.xml

                LayoutInflater inflater=getLayoutInflater();
                View v1=inflater.inflate(R.layout.dialog,null);
                EditText t1=v1.findViewById(R.id.p);
                EditText t2=v1.findViewById(R.id.t);
                EditText t3=v1.findViewById(R.id.r);
                Button bsi=v1.findViewById(R.id.btnres);
                TextView res=v1.findViewById(R.id.txtres);

                bsi.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int p=Integer.parseInt(t1.getText().toString());
                        int t=Integer.parseInt(t2.getText().toString());
                        int r=Integer.parseInt(t3.getText().toString());
                        int si=(p*t*r)/100;
                        res.setText("Simple Interest="+si);
                    }
                });
                builder.setView(v1);
                AlertDialog alert= builder.create();
                alert.show();
            }
        });
    }
}