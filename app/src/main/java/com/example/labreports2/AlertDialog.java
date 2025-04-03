package com.example.labreports2;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class AlertDialog extends AppCompatActivity {

    Button b1;
    EditText t1;
    int Number;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_alert_dialog);
        b1=findViewById(R.id.btnAlert);
        t1=new EditText(getApplicationContext());
        t1.setInputType(Number);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                androidx.appcompat.app.AlertDialog.Builder builder=new androidx.appcompat.app.AlertDialog.Builder(AlertDialog.this);
                builder.setTitle("Calculate Factorial,cube");
                builder.setMessage("Do you want to calculate");
                builder.setView(t1);
                builder.setCancelable(true);
                builder.setPositiveButton("Calculate", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog,int which){
                        int n=Integer.parseInt(t1.getText().toString());
                        int fact=1;
                        int cube=n*n*n;
                        for(int f=1;f<=n;f++)
                            fact*=f;
                        Toast.makeText(getApplicationContext(),"Factorial="+fact+"\nCube="+cube,Toast.LENGTH_LONG).show();
                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(),"Cancel button is clicked",Toast.LENGTH_LONG).show();
                    }
                });
                androidx.appcompat.app.AlertDialog alert =builder.create();
                alert.show();
            }
        });
    }
}