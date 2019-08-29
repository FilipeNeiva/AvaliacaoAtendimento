package com.example.camusb.network.services;

import com.example.camusb.network.helpers.FotoEndPoint;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIService {

    private FotoEndPoint fotoEndPoint;
    public static final String BASE_URL = "http://10.20.30.54:8000";
    private Retrofit retrofit;
    private Interceptor interceptor;

    public APIService(String token) {
        this.interceptor = new InterceptadorMuralAPI("token" + token);
        OkHttpClient.Builder builderCliente = new OkHttpClient.Builder();
        builderCliente.interceptors().add(this.interceptor);

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient httpClient = new OkHttpClient.Builder().connectTimeout(2, TimeUnit.MINUTES)
                .readTimeout(2, TimeUnit.MINUTES)
                .writeTimeout(2, TimeUnit.MINUTES)
                .addInterceptor(logging)
                .build();

        Retrofit.Builder builder = new Retrofit.Builder();
        retrofit = builder.baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create())
                .client(httpClient)
                .build();

        fotoEndPoint = retrofit.create(FotoEndPoint.class);

    }

    public Retrofit getRetrofit(){
        return this.retrofit;
    }

    public FotoEndPoint getFotoEndPoint(){
        return this.fotoEndPoint;
    }
}


