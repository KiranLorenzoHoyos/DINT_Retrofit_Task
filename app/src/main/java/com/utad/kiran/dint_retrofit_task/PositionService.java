package com.utad.kiran.dint_retrofit_task;

import android.database.Observable;

import java.util.List;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface PositionService {
    @Headers("TRN-Api-Key: 48057d93-96dc-41a1-b740-2a3e605ee4e9")
    @GET("v1/profile/{platform}/{epic-nickname}")
    io.reactivex.Observable<Statistics> getStatisticsInfo(@Path("platform") String platform, @Path("epic-nickname") String epic_nickname);

    static PositionService Factory(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(" https://api.fortnitetracker.com/")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return  retrofit.create(PositionService.class);
    }
}

