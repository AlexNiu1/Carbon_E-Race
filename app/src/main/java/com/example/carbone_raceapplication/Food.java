package com.example.carbone_raceapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
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
        SharedPreferences prefs = getSharedPreferences("app", MODE_PRIVATE);
        Button homebutton = findViewById(R.id.homeButton);
        homebutton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                startActivity(new Intent(Food.this, MainActivity.class));
            }
        });
        Button foodbutton = findViewById(R.id.foodButton);
        foodbutton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                startActivity(new Intent(Food.this, Food.class));
            }
        });
        Button transportationbutton = findViewById(R.id.transportationButton);
        transportationbutton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                startActivity(new Intent(Food.this, Transportation.class));
            }
        });
        Button boardbutton = findViewById(R.id.leaderboardButton);
        boardbutton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                startActivity(new Intent(Food.this, Leaderboard.class));
            }
        });


        Button settingsbutton = findViewById(R.id.settingsButton);
        settingsbutton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                startActivity(new Intent(Food.this, Settings.class));
            }
        });
    }
}