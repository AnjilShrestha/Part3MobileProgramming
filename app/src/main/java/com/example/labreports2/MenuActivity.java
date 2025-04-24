package com.example.labreports2;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MenuActivity extends AppCompatActivity {

    Button b1,b2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_menu);
        Toolbar toolbar=findViewById(R.id.optionmenubar);
       setSupportActionBar(toolbar);
        b1=findViewById(R.id.btncontextMenu);
        registerForContextMenu(b1);
        b2=findViewById(R.id.btnshowPopupMenu);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popup=new PopupMenu(getApplicationContext(),b2);
                popup.inflate(R.menu.popupmenu);
                popup.show();
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        int id=item.getItemId();
                        if(id==R.id.popnew)
                            Toast.makeText(getApplicationContext(),"Menu New is clicked",Toast.LENGTH_LONG).show();
                        if(id==R.id.popopen)
                            Toast.makeText(getApplicationContext(),"Menu Open is clicked",Toast.LENGTH_LONG).show();
                        if(id==R.id.popclose)
                            Toast.makeText(getApplicationContext(),"Menu Close is clicked",Toast.LENGTH_LONG).show();
                        return false;
                    }
                });
            }
        });
    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo){
        super.onCreateContextMenu(menu,v,menuInfo);
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.contextmenu,menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        int id=item.getItemId();
        if(id==R.id.copy)
            Toast.makeText(getApplicationContext(),"Copy is clicked",Toast.LENGTH_LONG).show();
        if(id==R.id.paste)
            Toast.makeText(getApplicationContext(),"Paste is clicked",Toast.LENGTH_LONG).show();
        if(id==R.id.select)
            Toast.makeText(getApplicationContext(),"Select is clicked",Toast.LENGTH_LONG).show();
        return super.onOptionsItemSelected(item);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater optionmenu=new MenuInflater(this);
        optionmenu.inflate(R.menu.optionmenu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id=item.getItemId();
        if(id==R.id.OptionProfile)
            Toast.makeText(getApplicationContext(),"Profile menu is clicked",Toast.LENGTH_LONG).show();
        if(id==R.id.Optionsettings)
            Toast.makeText(getApplicationContext(),"Settings is clicked",Toast.LENGTH_LONG).show();
        return super.onOptionsItemSelected(item);
    }
}