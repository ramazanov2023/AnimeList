package com.example.animelist.viewmodel;

import android.util.Log;

import com.example.animelist.data.AnimeDetail;
import com.example.animelist.data.AnimeShort;
import com.example.animelist.model.repository.AnimeObserver;
import com.example.animelist.model.repository.AnimeRepository;
import com.example.animelist.model.repository.AnimeRepositoryImpl;
import com.example.animelist.view.TurnPages;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AnimeDetailViewModel {


    public static AnimeDetail anime = null;

    public static void getDetailAnime(int id,TurnPages turnPages) {
        AnimeRepository call = AnimeRepositoryImpl.getInstance();
        call.getAnimeApi().getDetailAnime(id).enqueue(new Callback<AnimeDetail>() {
            @Override
            public void onResponse(Call<AnimeDetail> call, Response<AnimeDetail> response) {
                anime = response.body();
                Log.e("observer", "2 response.body() " + anime.id);
//                ((TurnPages)getActivity()).turnPage();
                turnPages.turnPage();
//                AnimeObserver animeObserver = AnimeObserver.getInstance();
//                animeObserver.notifyObservers();
//                turnPages.turnPage();

            }

            @Override
            public void onFailure(Call<AnimeDetail> call, Throwable t) {

            }
        });
    }
//    list1 = response.body();
//    AnimeObserver animeObserver = AnimeObserver.getInstance();
//                animeObserver.notifyObservers();


}
