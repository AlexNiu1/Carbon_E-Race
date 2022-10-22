package com.example.carbone_raceapplication;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.ImageView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.carbone_raceapplication.databinding.ActivityFoodBinding;

public class Food extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityFoodBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);
        ImageView homebutton = findViewById(R.id.home);
        homebutton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                // start the game
                startActivity(new Intent(MainActivity.this, MainActivity.class));
            }
        });
        ImageView foodbutton = findViewById(R.id.food);
        foodbutton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                // start the game
                startActivity(new Intent(MainActivity.this, Food.class));
            }
        });
        ImageView transportationbutton = findViewById(R.id.transportation);
        transportationbutton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                // start the game
                startActivity(new Intent(MainActivity.this, Transportation.class));
            }
        });
        ImageView boardbutton = findViewById(R.id.leaderboard);
        boardbutton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                // start the game
                startActivity(new Intent(MainActivity.this, Leaderboard.class));
            }
        });
        ImageView settingsbutton = findViewById(R.id.settings);
        settingsbutton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                // start the game
                startActivity(new Intent(MainActivity.this, Settings.class));
            }
        });
    }
}