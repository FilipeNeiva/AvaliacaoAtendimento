package com.example.camusb.model;

import okhttp3.MultipartBody;

public class Foto {
    private MultipartBody.Part imagem;

    public void setImagens(MultipartBody.Part imagens) {
        this.imagem = imagens;
    }

    public MultipartBody.Part getImagens() {
        return imagem;
    }
}
