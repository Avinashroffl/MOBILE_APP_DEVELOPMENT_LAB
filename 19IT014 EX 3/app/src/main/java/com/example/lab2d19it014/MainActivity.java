package com.example.lab2d19it014;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.optionmenu,menu);
        //setTitle("SELECT A PRODUCT");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId())
        {
            case R.id.au:
                Toast.makeText(this,"About Us",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this,Aboutus.class);
                startActivity(intent);
                return true;
            case R.id.tm:
                Toast.makeText(this,"Team members",Toast.LENGTH_SHORT).show();
                Intent intenttm = new Intent(MainActivity.this,Teammembers.class);
                startActivity(intenttm);
                return true;
            case R.id.td:
                Toast.makeText(this,"Team details",Toast.LENGTH_SHORT).show();
                Intent intenttd = new Intent(MainActivity.this,Teamdetails.class);
                startActivity(intenttd);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}