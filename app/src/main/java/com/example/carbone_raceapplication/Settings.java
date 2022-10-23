package com.example.carbone_raceapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Settings extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        SharedPreferences prefs = getSharedPreferences("app", MODE_PRIVATE);
        EditText username = findViewById(R.id.userusername);
        username.setText(prefs.getString("username", ""));
        Button updateusername = findViewById(R.id.UpdateUsername);
        updateusername.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                SharedPreferences.Editor editor = prefs.edit();
                editor.putString("username", username.getText().toString());
            }
        });

        Button homebutton = findViewById(R.id.homeButton5);
        homebutton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                startActivity(new Intent(Settings.this, MainActivity.class));
            }
        });
        Button foodbutton = findViewById(R.id.foodButton5);
        foodbutton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                startActivity(new Intent(Settings.this, Food.class));
            }
        });
        Button transportationbutton = findViewById(R.id.travelButton5);
        transportationbutton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                startActivity(new Intent(Settings.this, Transportation.class));
            }
        });
        Button boardbutton = findViewById(R.id.rankButton5);
        boardbutton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                startActivity(new Intent(Settings.this, Leaderboard.class));
            }
        });


        Button settingsbutton = findViewById(R.id.settingsButton5);
        settingsbutton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                startActivity(new Intent(Settings.this, Settings.class));
            }
        });

    }
}