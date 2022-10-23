package com.example.carbone_raceapplication;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface APIInterface {
    @GET("maps/api/distancematrix/json")
    Single<com.example.carbone_raceapplication.Result> getDistance(@Query("key") String key,
                                                       @Query("origins") String origin,
                                                       @Query("destinations") String destinations);
}
