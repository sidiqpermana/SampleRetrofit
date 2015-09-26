package com.sidiq.intel.sampleretrofit;

import java.util.ArrayList;

import retrofit.Callback;
import retrofit.http.GET;

/**
 * Created by inte on 9/26/2015.
 */
public interface MatchClient {
    @GET("/api/bola/1/7")
    void getMatches(Callback<ArrayList<MatchItems>> list);
}
