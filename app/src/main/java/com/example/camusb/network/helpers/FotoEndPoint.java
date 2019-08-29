package com.example.camusb.network.helpers;

import com.example.camusb.model.Foto;

import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface FotoEndPoint {

    @GET("gabarito/")
    Call<FotoEndPoint> getResultado();

    @Multipart
    @POST("gabarito/")
    Call<Foto> postFoto(@Part MultipartBody.Part imagem);
}
