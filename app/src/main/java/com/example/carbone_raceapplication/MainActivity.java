package com.example.carbone_raceapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    private Button mapsButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SharedPreferences prefs = getSharedPreferences("app", MODE_PRIVATE);

        mapsButton = (Button) findViewById(R.id.mapsbutton);
        mapsButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                openMapsActivity();
            }
        });

        /*
        double footprint = Double.longBitsToDouble(prefs.getLong("footprint", 0));
        String currentday = prefs.getString("currentday", null);
        Date date = Calendar.getInstance().getTime();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String today = formatter.format(date);
        if (currentday == null || !currentday.equals(today)) {
            SharedPreferences.Editor editor = prefs.edit();
            editor.putLong("footprint", 0);
            editor.putString("currentday", currentday);
            editor.apply();
        }

        Button homebutton = findViewById(R.id.homeButton1);
        homebutton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, MainActivity.class));
            }
        });
        Button foodbutton = findViewById(R.id.foodButton1);
        foodbutton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, Food.class));
            }
        });
        Button transportationbutton = findViewById(R.id.travelButton1);
        transportationbutton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, Transportation.class));
            }
        });
        Button boardbutton = findViewById(R.id.rankButton1);
        boardbutton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, Leaderboard.class));
            }
        });


        Button settingsbutton = findViewById(R.id.settingsButton1);
        settingsbutton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, Settings.class));
            }
        }); */
    }

    public void openMapsActivity() {
        Intent intent = new Intent(this, MapsActivity.class);
        startActivity(intent);
    }
}