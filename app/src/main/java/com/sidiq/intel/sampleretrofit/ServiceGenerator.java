package com.sidiq.intel.sampleretrofit;

import com.squareup.okhttp.OkHttpClient;

import java.util.concurrent.TimeUnit;

import retrofit.RestAdapter;
import retrofit.client.OkClient;

/**
 * Created by inte on 9/26/2015.
 */
public class ServiceGenerator {
    public static final String BASE_URL = "http://area54labs.net";
    private ServiceGenerator(){}

    public static <S> S createService(Class<S> serviceClass){
        final OkHttpClient okHttpClient = new OkHttpClient();
        okHttpClient.setReadTimeout(60, TimeUnit.SECONDS);
        okHttpClient.setConnectTimeout(60, TimeUnit.SECONDS);

        RestAdapter.Builder builder = new RestAdapter.Builder()
                .setEndpoint(BASE_URL)
                .setClient(new OkClient(okHttpClient));
        RestAdapter adapter = builder.build();

        return adapter.create(serviceClass);
    }

}
