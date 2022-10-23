package com.example.carbone_raceapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import java.util.Random;

public class Leaderboard extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leaderboard);
        SharedPreferences prefs = getSharedPreferences("app", MODE_PRIVATE);
        String league = prefs.getString("league", null);
        if (league == null){
            findViewById(R.id.leaguesize).setEnabled(false);
            findViewById(R.id.leaveleague).setEnabled(false);
        }
        else{
            EditText room = findViewById(R.id.room);
            room.setText("Your current league: " + league);
            EditText size = findViewById(R.id.leaguesize);
            size.setText("League size: 5");
            findViewById(R.id.leaguename).setEnabled(false);
            findViewById(R.id.createleague).setEnabled(false);
            findViewById(R.id.joinleague).setEnabled(false);
            findViewById(R.id.notinleague).setEnabled(false);
        }
        int size = 0;
        Button createleague = findViewById(R.id.createleague);
        createleague.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                EditText name = findViewById(R.id.leaguename)
                String newleague = name.getText().toString();
                if (!newleague.matches("[a-zA-Z0-9]*") || prefs.getString("leagues", "").contains(newleague)){
                    name.setText("Error: League name is either not valid or already in use");
                }
                else {
                    SharedPreferences.Editor editor = prefs.edit();
                    editor.putString("leagues", prefs.getString("leagues", "") + newleague + ",");
                    editor.apply();
                    EditText room = findViewById(R.id.room);
                    room.setText("Your current league: " + newleague);
                    findViewById(R.id.leaguesize).setEnabled(true);
                    EditText size = findViewById(R.id.leaguesize);
                    size.setText("League size: 5");
                    findViewById(R.id.leaveleague).setEnabled(true);
                    findViewById(R.id.leaguename).setEnabled(false);
                    findViewById(R.id.createleague).setEnabled(false);
                    findViewById(R.id.joinleague).setEnabled(false);
                    findViewById(R.id.notinleague).setEnabled(false);
                }
            }
        });
        Button joinleague = findViewById(R.id.joinleague);
        joinleague.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                EditText name = findViewById(R.id.leaguename);
                String newleague = name.getText().toString();
                if (!newleague.matches("[a-zA-Z0-9]*") || !prefs.getString("leagues", "").contains(newleague)){
                    name.setText("Error: League name does not exist");
                }
                else{
                    SharedPreferences.Editor editor = prefs.edit();
                    editor.putString("leagues", prefs.getString("leagues", "") + newleague + ",");
                    editor.apply();
                    EditText room = findViewById(R.id.room);
                    room.setText("Your current league: " + newleague);
                    findViewById(R.id.leaguesize).setEnabled(true);
                    EditText size = findViewById(R.id.leaguesize);
                    size.setText("League size: 5");
                    findViewById(R.id.leaveleague).setEnabled(true);
                    findViewById(R.id.leaguename).setEnabled(false);
                    findViewById(R.id.createleague).setEnabled(false);
                    findViewById(R.id.joinleague).setEnabled(false);
                    findViewById(R.id.notinleague).setEnabled(false);
                }
            }
        });
        Button leaveleague = findViewById(R.id.leaveleague);
        leaveleague.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                SharedPreferences.Editor editor = prefs.edit();
                editor.putString("league", null);
                editor.apply();
                EditText room = findViewById(R.id.room);
                room.setText("Your current league: none");
                findViewById(R.id.leaguesize).setEnabled(false);
                findViewById(R.id.leaveleague).setEnabled(false);
                findViewById(R.id.leaguename).setEnabled(true);
                findViewById(R.id.createleague).setEnabled(true);
                findViewById(R.id.joinleague).setEnabled(true);
                findViewById(R.id.notinleague).setEnabled(true);
            }
        });
        ImageView homebutton = findViewById(R.id.home);
        homebutton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                startActivity(new Intent(Leaderboard.this, MainActivity.class));
            }
        });
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