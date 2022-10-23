package com.example.carbone_raceapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Transportation extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transportation);
        SharedPreferences prefs = getSharedPreferences("app", MODE_PRIVATE);
        Button homebutton = findViewById(R.id.homeButton);
        homebutton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                startActivity(new Intent(Transportation.this, MainActivity.class));
            }
        });
        Button foodbutton = findViewById(R.id.foodButton);
        foodbutton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                startActivity(new Intent(Transportation.this, Food.class));
            }
        });
        Button transportationbutton = findViewById(R.id.transportationButton);
        transportationbutton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                startActivity(new Intent(Transportation.this, Transportation.class));
            }
        });
        Button boardbutton = findViewById(R.id.leaderboardButton);
        boardbutton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                startActivity(new Intent(Transportation.this, Leaderboard.class));
            }
        });


        Button settingsbutton = findViewById(R.id.settingsButton);
        settingsbutton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                startActivity(new Intent(Transportation.this, Settings.class));
            }
        });
    }
}