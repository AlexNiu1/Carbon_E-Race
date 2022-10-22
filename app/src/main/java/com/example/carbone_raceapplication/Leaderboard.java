package com.example.carbone_raceapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Leaderboard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leaderboard);
        SharedPreferences prefs = getSharedPreferences("app", MODE_PRIVATE);
        ImageView homebutton = findViewById(R.id.home);
        homebutton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                startActivity(new Intent(Leaderboard.this, MainActivity.class));
            }
        });
        ImageView foodbutton = findViewById(R.id.food);
        foodbutton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                startActivity(new Intent(Leaderboard.this, Food.class));
            }
        });
        ImageView transportationbutton = findViewById(R.id.transportation);
        transportationbutton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                startActivity(new Intent(Leaderboard.this, Transportation.class));
            }
        });
        ImageView boardbutton = findViewById(R.id.leaderboard);
        boardbutton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                startActivity(new Intent(Leaderboard.this, Leaderboard.class));
            }
        });
        ImageView settingsbutton = findViewById(R.id.settings);
        settingsbutton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                startActivity(new Intent(Leaderboard.this, Settings.class));
            }
        });
    }
}