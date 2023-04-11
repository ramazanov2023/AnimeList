package com.example.animelist.viewmodel;

import android.util.Log;

import com.example.animelist.data.AnimeShort;
import com.example.animelist.model.repository.AnimeObserver;
import com.example.animelist.model.repository.AnimeRepository;
import com.example.animelist.model.repository.AnimeRepositoryImpl;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AnimeListsViewModel {

    int listNum = 0;


    public static List<AnimeShort> list = null;
    public static List<AnimeShort> list1 = null;
    public static List<AnimeShort> list2 = null;

    public static void getOngoingAnime() {
        AnimeRepository call = AnimeRepositoryImpl.getInstance();
        call.getAnimeApi().getOngoingAnime().enqueue(new Callback<List<AnimeShort>>() {
            @Override
            public void onResponse(Call<List<AnimeShort>> call, Response<List<AnimeShort>> response) {
                list = response.body();
                AnimeObserver animeObserver = AnimeObserver.getInstance();
                animeObserver.notifyObservers();
            }

            @Override
            public void onFailure(Call<List<AnimeShort>> call, Throwable t) {

            }
        });
    }

    public static void getAnonsAnime() {
        AnimeRepository call = AnimeRepositoryImpl.getInstance();
        call.getAnimeApi().getAnonsAnime().enqueue(new Callback<List<AnimeShort>>() {
            @Override
            public void onResponse(Call<List<AnimeShort>> call, Response<List<AnimeShort>> response) {
                list1 = response.body();
                AnimeObserver animeObserver = AnimeObserver.getInstance();
                animeObserver.notifyObservers();
            }

            @Override
            public void onFailure(Call<List<AnimeShort>> call, Throwable t) {

            }
        });
    }

    public static void getReleasedAnime() {
        AnimeRepository call = AnimeRepositoryImpl.getInstance();
        call.getAnimeApi().getReleasedAnime().enqueue(new Callback<List<AnimeShort>>() {
            @Override
            public void onResponse(Call<List<AnimeShort>> call, Response<List<AnimeShort>> response) {
                list2 = response.body();
                AnimeObserver animeObserver = AnimeObserver.getInstance();
                animeObserver.notifyObservers();
            }

            @Override
            public void onFailure(Call<List<AnimeShort>> call, Throwable t) {

            }
        });
    }
}
