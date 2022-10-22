package com.example.carbone_raceapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class Settings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        SharedPreferences prefs = getSharedPreferences("app", MODE_PRIVATE);
        EditText username = findViewById(R.id.userusername);
        username.setText(prefs.getString("username", ""));
        Button updateusername = findViewById(R.id.UpdateUsername);
        updateusername.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                SharedPreferences.Editor editor = prefs.edit();
                editor.putString("username", username.getText().toString());
            }
        });
        ImageView homebutton = findViewById(R.id.home);
        homebutton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                startActivity(new Intent(Settings.this, MainActivity.class));
            }
        });
        ImageView foodbutton = findViewById(R.id.food);
        foodbutton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                startActivity(new Intent(Settings.this, Food.class));
            }
        });
        ImageView transportationbutton = findViewById(R.id.transportation);
        transportationbutton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                startActivity(new Intent(Settings.this, Transportation.class));
            }
        });
        ImageView boardbutton = findViewById(R.id.leaderboard);
        boardbutton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                startActivity(new Intent(Settings.this, Leaderboard.class));
            }
        });
        ImageView settingsbutton = findViewById(R.id.settings);
        settingsbutton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                startActivity(new Intent(Settings.this, Settings.class));
            }
        });
    }
}