package com.example.carbone_raceapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    private Button mapsButton;
    private ProgressBar progress_bar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SharedPreferences prefs = getSharedPreferences("app", MODE_PRIVATE);
        double footprint = Double.longBitsToDouble(prefs.getLong("footprint", 100));
        String currentday = prefs.getString("currentday", null);
        Date date = Calendar.getInstance().getTime();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String today = formatter.format(date);


        final ProgressBar progressBar = (ProgressBar) findViewById(R.id.progress_bar);
        final TextView footPrintScore = findViewById(R.id.carbonfootstepscore);
        Button refresh = (Button) findViewById(R.id.refresh);
        Button refresher = findViewById(R.id.refresh);
        refresh.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String footPrintText = String.valueOf(100 - footprint);
                footPrintScore.setText(footPrintText);

                if(footprint >= 100){
                    progressBar.setProgress(0);
                }else {
                    progressBar.setProgress(100 - (int)footprint);
                }
            }
        });

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
        Button boardbutton = findViewById(R.id.rankButton1);
        boardbutton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, Leaderboard.class));
            }
        });
        Button transportationbutton = findViewById(R.id.travelButton1);
        transportationbutton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, Transportation.class));
            }
        });

        Button settingsbutton = findViewById(R.id.settingsButton1);
        settingsbutton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, Settings.class));
            }
        });
    }

    /* public void openMapsActivity() {
        Intent intent = new Intent(this, MapsActivity.class);
        startActivity(intent);
    }*/
}