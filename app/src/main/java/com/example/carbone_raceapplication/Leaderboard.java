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

import java.util.ArrayList;
import java.util.Random;

public class Leaderboard extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leaderboard);
        SharedPreferences prefs = getSharedPreferences("app", MODE_PRIVATE);
        String league = prefs.getString("league", null);
        TextView errorText = findViewById(R.id.error);
        errorText.setVisibility(View.INVISIBLE);
        if (league == null){
            findViewById(R.id.leaveleague).setEnabled(false);
            findViewById(R.id.leaveleague).setVisibility(View.INVISIBLE);
        }
        else {
            EditText room = findViewById(R.id.room);
            room.setText("League: " + league);
            findViewById(R.id.leaguename).setEnabled(false);
            findViewById(R.id.leaguename).setVisibility(View.INVISIBLE);
            findViewById(R.id.createleague).setEnabled(false);
            findViewById(R.id.createleague).setVisibility(View.INVISIBLE);
            findViewById(R.id.joinleague).setEnabled(false);
            findViewById(R.id.joinleague).setVisibility(View.INVISIBLE);
            ArrayList<Double> al = new ArrayList<>();
            ArrayList<String> arr = new ArrayList<>();
            al.add(8.3);
            al.add(11.1);
            al.add(12.9);
            al.add(28.1);
            al.add(37.1);
            al.add(46.0);
            al.add(52.1);
            arr.add("andrewwu");
            arr.add("meganyi");
            arr.add("eyoelgebre");
            arr.add("aliyanmuhammad");
            arr.add("alexniu");
            arr.add("kevinwu");
            arr.add("ralenkovara");
            double score = Double.longBitsToDouble(prefs.getLong("footprint", 0));
            score = Math.round(score * 100.0) / 100.0;
            boolean bool = true;
            for (int i = 0; i < al.size(); i++){
                if (score <= al.get(i)){
                    al.add(i, score);
                    arr.add(i, "You");
                    bool = false;
                    break;
                }
            }
            if (bool){
                al.add(score);
                arr.add("You");
            }
            TextView one = findViewById(R.id.firstplace);
            TextView two = findViewById(R.id.secondplace);
            TextView three = findViewById(R.id.thirdplace);
            TextView four = findViewById(R.id.fourthplace);
            TextView five = findViewById(R.id.fifthplace);
            TextView six = findViewById(R.id.sixthplace);
            TextView seven = findViewById(R.id.seventhplace);
            TextView eight = findViewById(R.id.eighthplace);
            one.setText("1st: " + arr.get(0) + " , " + al.get(0));
            two.setText("2nd: " + arr.get(1) + " , " + al.get(1));
            three.setText("3rd: " + arr.get(2) + " , " + al.get(2));
            four.setText("4th: " + arr.get(3) + " , " + al.get(3));
            five.setText("5th: " + arr.get(4) + " , " + al.get(4));
            six.setText("6th: " + arr.get(5) + " , " + al.get(5));
            seven.setText("7th: " + arr.get(6) + " , " + al.get(6));
            eight.setText("8th: " + arr.get(7) + " , " + al.get(7));
        }
        Button createleague = findViewById(R.id.createleague);
        createleague.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                EditText name = findViewById(R.id.leaguename);
                String newleague = name.getText().toString();
                if (!newleague.matches("[a-zA-Z0-9]*")){
                    //name.setText("Error: League name is either not valid or already in use");
                    errorText.setVisibility(View.VISIBLE);
                }
                else {
                    errorText.setVisibility(View.INVISIBLE);
                    SharedPreferences.Editor editor = prefs.edit();
                    editor.putString("league", newleague);
                    editor.apply();
                    EditText room = findViewById(R.id.room);
                    room.setText("League: " + newleague);
                    findViewById(R.id.leaveleague).setEnabled(true);
                    findViewById(R.id.leaveleague).setVisibility(View.VISIBLE);
                    findViewById(R.id.leaguename).setEnabled(false);
                    findViewById(R.id.leaguename).setVisibility(View.INVISIBLE);
                    findViewById(R.id.createleague).setEnabled(false);
                    findViewById(R.id.createleague).setVisibility(View.INVISIBLE);
                    findViewById(R.id.joinleague).setEnabled(false);
                    findViewById(R.id.joinleague).setVisibility(View.INVISIBLE);
                    ArrayList<Double> al = new ArrayList<>();
                    ArrayList<String> arr = new ArrayList<>();
                    al.add(8.3);
                    al.add(11.1);
                    al.add(12.9);
                    al.add(28.1);
                    al.add(37.1);
                    al.add(46.0);
                    al.add(52.1);
                    arr.add("andrewwu");
                    arr.add("meganyi");
                    arr.add("eyoelgebre");
                    arr.add("aliyanmuhammad");
                    arr.add("alexniu");
                    arr.add("kevinwu");
                    arr.add("ralenkovara");
                    double score = Double.longBitsToDouble(prefs.getLong("footprint", 0));
                    score = Math.round(score * 100.0) / 100.0;
                    boolean bool = true;
                    for (int i = 0; i < al.size(); i++){
                        if (score <= al.get(i)){
                            al.add(i, score);
                            arr.add(i, "You");
                            bool = false;
                            break;
                        }
                    }
                    if (bool){
                        al.add(score);
                        arr.add("You");
                    }
                    TextView one = findViewById(R.id.firstplace);
                    TextView two = findViewById(R.id.secondplace);
                    TextView three = findViewById(R.id.thirdplace);
                    TextView four = findViewById(R.id.fourthplace);
                    TextView five = findViewById(R.id.fifthplace);
                    TextView six = findViewById(R.id.sixthplace);
                    TextView seven = findViewById(R.id.seventhplace);
                    TextView eight = findViewById(R.id.eighthplace);
                    one.setText("1st: " + arr.get(0) + " , " + al.get(0));
                    two.setText("2nd: " + arr.get(1) + " , " + al.get(1));
                    three.setText("3rd: " + arr.get(2) + " , " + al.get(2));
                    four.setText("4th: " + arr.get(3) + " , " + al.get(3));
                    five.setText("5th: " + arr.get(4) + " , " + al.get(4));
                    six.setText("6th: " + arr.get(5) + " , " + al.get(5));
                    seven.setText("7th: " + arr.get(6) + " , " + al.get(6));
                    eight.setText("8th: " + arr.get(7) + " , " + al.get(7));
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
                    editor.putString("league", newleague);
                    editor.apply();
                    EditText room = findViewById(R.id.room);
                    room.setText("League: " + newleague);
                    findViewById(R.id.leaveleague).setEnabled(true);
                    findViewById(R.id.leaveleague).setVisibility(View.VISIBLE);
                    findViewById(R.id.leaguename).setEnabled(false);
                    findViewById(R.id.leaguename).setVisibility(View.INVISIBLE);
                    findViewById(R.id.createleague).setEnabled(false);
                    findViewById(R.id.createleague).setVisibility(View.INVISIBLE);
                    findViewById(R.id.joinleague).setEnabled(false);
                    findViewById(R.id.joinleague).setVisibility(View.INVISIBLE);
                    ArrayList<Double> al = new ArrayList<>();
                    ArrayList<String> arr = new ArrayList<>();
                    al.add(8.3);
                    al.add(11.1);
                    al.add(12.9);
                    al.add(28.1);
                    al.add(37.1);
                    al.add(46.0);
                    al.add(52.1);
                    arr.add("andrewwu");
                    arr.add("meganyi");
                    arr.add("eyoelgebre");
                    arr.add("aliyanmuhammad");
                    arr.add("alexniu");
                    arr.add("kevinwu");
                    arr.add("ralenkovara");
                    double score = Double.longBitsToDouble(prefs.getLong("footprint", 0));
                    score = Math.round(score * 100.0) / 100.0;
                    boolean bool = true;
                    for (int i = 0; i < al.size(); i++){
                        if (score <= al.get(i)){
                            al.add(i, score);
                            arr.add(i, "You");
                            bool = false;
                            break;
                        }
                    }
                    if (bool){
                        al.add(score);
                        arr.add("You");
                    }
                    TextView one = findViewById(R.id.firstplace);
                    TextView two = findViewById(R.id.secondplace);
                    TextView three = findViewById(R.id.thirdplace);
                    TextView four = findViewById(R.id.fourthplace);
                    TextView five = findViewById(R.id.fifthplace);
                    TextView six = findViewById(R.id.sixthplace);
                    TextView seven = findViewById(R.id.seventhplace);
                    TextView eight = findViewById(R.id.eighthplace);
                    one.setText("1st: " + arr.get(0) + " , " + al.get(0));
                    two.setText("2nd: " + arr.get(1) + " , " + al.get(1));
                    three.setText("3rd: " + arr.get(2) + " , " + al.get(2));
                    four.setText("4th: " + arr.get(3) + " , " + al.get(3));
                    five.setText("5th: " + arr.get(4) + " , " + al.get(4));
                    six.setText("6th: " + arr.get(5) + " , " + al.get(5));
                    seven.setText("7th: " + arr.get(6) + " , " + al.get(6));
                    eight.setText("8th: " + arr.get(7) + " , " + al.get(7));
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
                room.setText("League: none");
                findViewById(R.id.leaveleague).setEnabled(false);
                findViewById(R.id.leaveleague).setVisibility(View.INVISIBLE);
                findViewById(R.id.leaguename).setEnabled(true);
                findViewById(R.id.leaguename).setVisibility(View.VISIBLE);
                findViewById(R.id.createleague).setEnabled(true);
                findViewById(R.id.createleague).setVisibility(View.VISIBLE);
                findViewById(R.id.joinleague).setEnabled(true);
                findViewById(R.id.joinleague).setVisibility(View.VISIBLE);
                TextView one = findViewById(R.id.firstplace);
                TextView two = findViewById(R.id.secondplace);
                TextView three = findViewById(R.id.thirdplace);
                TextView four = findViewById(R.id.fourthplace);
                TextView five = findViewById(R.id.fifthplace);
                TextView six = findViewById(R.id.sixthplace);
                TextView seven = findViewById(R.id.seventhplace);
                TextView eight = findViewById(R.id.eighthplace);
                one.setText("");
                two.setText("");
                three.setText("");
                four.setText("");
                five.setText("");
                six.setText("");
                seven.setText("");
                eight.setText("");
            }
        });
        Button homebutton = findViewById(R.id.homeButton4);
        homebutton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                startActivity(new Intent(Leaderboard.this, MainActivity.class));
            }
        });
        Button foodbutton = findViewById(R.id.foodButton4);
        foodbutton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                startActivity(new Intent(Leaderboard.this, Food.class));
            }
        });
        Button transportationbutton = findViewById(R.id.travelButton4);
        transportationbutton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                startActivity(new Intent(Leaderboard.this, Transportation.class));
            }
        });
        Button boardbutton = findViewById(R.id.rankButton4);
        boardbutton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                startActivity(new Intent(Leaderboard.this, Leaderboard.class));
            }
        });


        Button settingsbutton = findViewById(R.id.settingsButton4);
        settingsbutton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                startActivity(new Intent(Leaderboard.this, Settings.class));
            }
        });
    }
}