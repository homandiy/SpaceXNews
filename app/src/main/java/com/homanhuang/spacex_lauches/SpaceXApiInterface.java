package com.homanhuang.spacex_lauches;

import com.homanhuang.spacex_lauches.launch.Launch;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

import java.util.List;
import java.util.Map;

/**
 * Created by Homan on 2/28/2018.
 */

public interface SpaceXApiInterface {

    //Get all past launches
    @GET("/v2/launches")
    Call<List<Launch>> getTimeLaunches(@QueryMap Map<String, String> options);

    //Get latest launch
    @GET("/v2/launches/latest")
    Call<List<Launch>> getlastLaunch();

    //Get up coming launch(es)
    @GET("/v2/launches/upcoming")
    Call<List<Launch>> getUpComing();

    //Get up coming launch(es)
    @GET("/v2/launches/all")
    Call<List<Launch>> getAll();
}
