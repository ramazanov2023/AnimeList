package com.example.animelist.model.repository;


import com.example.animelist.model.api.Api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AnimeRepositoryImpl implements AnimeRepository {

    private static AnimeRepositoryImpl instance = null;

    Retrofit retrofit;

    private AnimeRepositoryImpl(){
        retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static synchronized AnimeRepositoryImpl getInstance(){
        if(instance==null){
            instance = new AnimeRepositoryImpl();
        }
        return instance;
    }

    @Override
    public Api getAnimeApi() {
        return retrofit.create(Api.class);
    }

//    public Api getAnimeApi(){return retrofit.create(Api.class);}

}
