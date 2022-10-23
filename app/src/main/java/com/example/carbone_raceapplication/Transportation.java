package com.example.carbone_raceapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import android.annotation.SuppressLint;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.SharedPreferences;
import android.location.Address;
import android.location.Geocoder;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.carbone_raceapplication.databinding.ActivityMapsBinding;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class Transportation extends AppCompatActivity {
    EditText etSource,etDestination;

    Button btTrack;

    private APIInterface apiInterface;
    Button btn_distance;
    TextView text_distance;

    //private GoogleMap mMap;
    //private ActivityMapsBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transportation);

        btn_distance=findViewById(R.id.btn_distance);
        text_distance = findViewById(R.id.text_distance);

        etSource = findViewById(R.id.et_source);
        etDestination = findViewById(R.id.et_destination);
        btTrack = findViewById(R.id.bt_track);

        Retrofit retrofit=new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl("https://maps.googleapis.com/")
                .build();
        apiInterface = retrofit.create(APIInterface.class);

        btn_distance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String sSource = etSource.getText().toString().trim();
                String sDestination = etDestination.getText().toString().trim();

                if (sSource.equals("") && sDestination.equals("")) {
                    Toast.makeText(getApplicationContext()
                            , "Enter Both Location",Toast.LENGTH_SHORT).show();

                } else {
                    Geocoder geocoder = new Geocoder(getApplicationContext(), Locale.getDefault());

                    try {
                        String dLat = "90";
                        String dLong = "0";
                        String sLat = "0";
                        String sLong = "0";

                        List<Address> sAddressList = geocoder.getFromLocationName(sSource, 1);

                        if (sAddressList.size()>0) {
                            Address address = sAddressList.get(0);

                            sLat = String.valueOf(address.getLatitude());
                            sLong = String.valueOf(address.getLongitude());
                        }

                        List<Address> dAddressList = geocoder.getFromLocationName(sDestination, 1);

                        if (dAddressList.size()>0) {
                            Address address = dAddressList.get(0);

                            dLat = String.valueOf(address.getLatitude());
                            dLong = String.valueOf(address.getLongitude());
                        }

                        getDistance(sLat+","+sLong, dLat+","+dLong);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }


            }
        });




        btTrack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String sSource = etSource.getText().toString().trim();
                String sDestination = etDestination.getText().toString().trim();

                if (sSource.equals("") && sDestination.equals("")) {
                    Toast.makeText(getApplicationContext()
                            , "Enter Both Location",Toast.LENGTH_SHORT).show();

                } else {
                    DisplayTrack(sSource, sDestination);
                }

            }
        });

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

        //binding = ActivityMapsBinding.inflate(getLayoutInflater());
        // setContentView(binding.getRoot());

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        /* SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this); */
    }


    private void getDistance(String origin, String dest) {
        apiInterface.getDistance(getString(R.string.api_Key),origin,dest)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<Result>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @SuppressLint("SetTextI18n")
                    @Override
                    public void onSuccess(Result result) {

                        Toast.makeText(Transportation.this, "Result Success", Toast.LENGTH_SHORT).show();
                        text_distance.setText(result.getOrigin_addresses().get(0)+"\n\n"+
                                result.getDestination_addresses().get(0) +"\n\n"
                                +"Total distance"+result.getRows().get(0).getElements().get(0).getDistance().getText());
                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                });
    }

    private void DisplayTrack(String sSource, String sDestination) {
        try {
            Uri uri = Uri.parse("https://www.google.co.in/maps/dir/" + sSource + "/"
                    + sDestination);
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);

            intent.setPackage("com.google.android.apps.maps");

            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

            startActivity(intent);
        }catch (ActivityNotFoundException e) {
            Uri uri = Uri.parse("https://play.google.com/store/apps/details?id=com.google.android.apps.maps");

            Intent intent = new Intent(Intent.ACTION_VIEW,uri);

            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

            startActivity(intent);
        }
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
    /*@Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    } */
}