package com.example.camusb.network.services;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class InterceptadorMuralAPI implements Interceptor {

    public static final String AUTHORIZATION = "Autorization";
    public final String TOKEN;


    public InterceptadorMuralAPI(String TOKEN) {
        this.TOKEN = TOKEN;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request().newBuilder().addHeader(AUTHORIZATION, TOKEN).build();
        return chain.proceed(request);
    }
}
