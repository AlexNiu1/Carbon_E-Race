package com.example.carbone_raceapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.carbone_raceapplication.databinding.ActivityFoodBinding;

import java.util.HashMap;

public class Food extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityFoodBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);
        SharedPreferences prefs = getSharedPreferences("app", MODE_PRIVATE);
        HashMap<String, Double> map = new HashMap<>();
        map.put("Beef", 2.98);
        map.put("Lamb", 2.57);
        map.put("Cheese", 1.17);
        map.put("Shrimp", 0.91);
        map.put("Pork", 0.76);
        map.put("Chicken", 0.63);
        map.put("Yogurt", 0.48);
        map.put("Eggs", 0.45);
        map.put("Veggie Patty", 0.42);
        map.put("Fish", 0.38);
        map.put("Seafood", 0.24);
        map.put("Rice", 0.19);
        map.put("Beans", 0.16);
        map.put("Lettuce", 0.07);
        map.put("Tomato", 0.06);
        map.put("Other Veggies", 0.05);
        Button submitbutton = findViewById(R.id.submit);
        submitbutton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                double ans = 0.0;
                CheckBox box = findViewById(R.id.checkBox15);
                if (box.isChecked()){
                    ans += map.get(box.getText().toString());
                    box.setChecked(false);
                }
                box = findViewById(R.id.checkBox16);
                if (box.isChecked()){
                    ans += map.get(box.getText().toString());
                    box.setChecked(false);
                }
                box = findViewById(R.id.checkBox17);
                if (box.isChecked()){
                    ans += map.get(box.getText().toString());
                    box.setChecked(false);
                }
                box = findViewById(R.id.checkBox18);
                if (box.isChecked()){
                    ans += map.get(box.getText().toString());
                    box.setChecked(false);
                }
                box = findViewById(R.id.checkBox19);
                if (box.isChecked()){
                    ans += map.get(box.getText().toString());
                    box.setChecked(false);
                }
                box = findViewById(R.id.checkBox20);
                if (box.isChecked()){
                    ans += map.get(box.getText().toString());
                    box.setChecked(false);
                }
                box = findViewById(R.id.checkBox21);
                if (box.isChecked()){
                    ans += map.get(box.getText().toString());
                    box.setChecked(false);
                }
                box = findViewById(R.id.checkBox22);
                if (box.isChecked()){
                    ans += map.get(box.getText().toString());
                    box.setChecked(false);
                }
                box = findViewById(R.id.checkBox23);
                if (box.isChecked()){
                    ans += map.get(box.getText().toString());
                    box.setChecked(false);
                }
                box = findViewById(R.id.checkBox24);
                if (box.isChecked()){
                    ans += map.get(box.getText().toString());
                    box.setChecked(false);
                }
                box = findViewById(R.id.checkBox25);
                if (box.isChecked()){
                    ans += map.get(box.getText().toString());
                    box.setChecked(false);
                }
                box = findViewById(R.id.checkBox26);
                if (box.isChecked()){
                    ans += map.get(box.getText().toString());
                    box.setChecked(false);
                }
                box = findViewById(R.id.checkBox27);
                if (box.isChecked()){
                    ans += map.get(box.getText().toString());
                    box.setChecked(false);
                }
                box = findViewById(R.id.checkBox28);
                if (box.isChecked()){
                    ans += map.get(box.getText().toString());
                    box.setChecked(false);
                }
                box = findViewById(R.id.checkBox29);
                if (box.isChecked()){
                    ans += map.get(box.getText().toString());
                    box.setChecked(false);
                }
                box = findViewById(R.id.checkBox30);
                if (box.isChecked()){
                    ans += map.get(box.getText().toString());
                    box.setChecked(false);
                }
                SharedPreferences.Editor editor = prefs.edit();
                editor.putLong("footprint", Double.doubleToRawLongBits(Double.longBitsToDouble(prefs.getLong("footprint", 0))+ans));
                editor.apply();
            }
        });
        Button homebutton = findViewById(R.id.homeButton2);
        homebutton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                startActivity(new Intent(Food.this, MainActivity.class));
            }
        });
        Button foodbutton = findViewById(R.id.foodButton2);
        foodbutton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                startActivity(new Intent(Food.this, Food.class));
            }
        });
        Button transportationbutton = findViewById(R.id.travelButton2);
        transportationbutton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                startActivity(new Intent(Food.this, Transportation.class));
            }
        });
        Button boardbutton = findViewById(R.id.rankButton2);
        boardbutton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                startActivity(new Intent(Food.this, Leaderboard.class));
            }
        });


        Button settingsbutton = findViewById(R.id.settingsButton2);
        settingsbutton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                startActivity(new Intent(Food.this, Settings.class));
            }
        });
    }
}