package com.example.carbone_raceapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.carbone_raceapplication.databinding.ActivityMapsBinding;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class Transportation extends FragmentActivity implements OnMapReadyCallback {
    private GoogleMap mMap;
    private ActivityMapsBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transportation);
        SharedPreferences prefs = getSharedPreferences("app", MODE_PRIVATE);

        Button homebutton = findViewById(R.id.homeButton3);
        homebutton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                startActivity(new Intent(Transportation.this, MainActivity.class));
            }
        });
        Button foodbutton = findViewById(R.id.foodButton3);
        foodbutton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                startActivity(new Intent(Transportation.this, Food.class));
            }
        });
        Button transportationbutton = findViewById(R.id.travelButton3);
        transportationbutton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                startActivity(new Intent(Transportation.this, Transportation.class));
            }
        });
        Button boardbutton = findViewById(R.id.rankButton3);
        boardbutton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                startActivity(new Intent(Transportation.this, Leaderboard.class));
            }
        });


        Button settingsbutton = findViewById(R.id.settingsButton3);
        settingsbutton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                startActivity(new Intent(Transportation.this, Settings.class));
            }
        });
        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }
    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }
}