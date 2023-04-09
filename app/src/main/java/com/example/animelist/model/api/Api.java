package com.example.animelist.model.api;

import com.example.animelist.data.AnimeShort;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Api {
    String BASE_URL="https://shikimori.one";

    @GET("/api/animes?status=ongoing&limit=30&season=2023&kind=tv&order=ranked")
    Call<List<AnimeShort>> getOngoingAnime();
//    Call<List<AnimeShort>> getOngoingAnime(@Query("status") String status, @Query("limit") int limit);

    @GET("/api/animes?status=anons&limit=30&season=2023&kind=tv&order=ranked")
    Call<List<AnimeShort>> getAnonsAnime();

    @GET("/api/animes?status=released&limit=30&season=2023&kind=tv&order=ranked")
    Call<List<AnimeShort>> getReleasedAnime();
}
