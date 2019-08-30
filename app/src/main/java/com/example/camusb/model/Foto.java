package com.example.camusb.model;

import java.io.Serializable;

import okhttp3.MultipartBody;

public class Foto implements Serializable {
    private Long id;
    private MultipartBody.Part imagem;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setImagens(MultipartBody.Part imagens) {
        this.imagem = imagens;
    }

    public MultipartBody.Part getImagens() {
        return imagem;
    }
}
