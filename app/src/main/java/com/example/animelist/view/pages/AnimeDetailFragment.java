package com.example.animelist.view.pages;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.animelist.R;
import com.example.animelist.data.AnimeDetail;
import com.example.animelist.data.AnimeShort;
import com.example.animelist.model.api.Api;
import com.example.animelist.model.repository.AnimeObserver;
import com.example.animelist.model.repository.Observer;
import com.example.animelist.view.TurnPages;
import com.example.animelist.viewmodel.AnimeDetailViewModel;
import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AnimeDetailFragment extends Fragment implements Observer {
    TextView animeTitleRus, animeTitleJpn,animeDescription;
    ImageView animePoster;
//    AnimeDetail anime;
//    int animeId = 0;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_anime_detail,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
//        animeId = getActivity().getSharedPreferences("anime", Context.MODE_PRIVATE).getInt("animeId",1);


        animePoster = view.findViewById(R.id.anime_detail_poster);
        animeTitleRus = view.findViewById(R.id.anime_detail_name_rus);
        animeTitleJpn = view.findViewById(R.id.anime_detail_name_jpn);
        animeDescription = view.findViewById(R.id.anime_detail_description);


        AnimeObserver.getInstance().registerObservers(this);
        Log.e("observer", "VALUE registerObservers(this) " + AnimeObserver.getInstance().countObservers());
        Log.e("observer", "3 registerObservers(this) " + AnimeDetailViewModel.anime.id);
//        AnimeDetailViewModel.getDetailAnime(1);

        if(AnimeDetailViewModel.anime!=null) {
            fillViews(AnimeDetailViewModel.anime);
        }

    }

    @Override
    public void update() {
//        int animeId = getActivity().getSharedPreferences("anime", Context.MODE_PRIVATE).getInt("animeId",1);
//        AnimeDetailViewModel.getDetailAnime(animeId);
        Log.e("observer", "4 update() " + AnimeDetailViewModel.anime.id);
        if(AnimeDetailViewModel.anime!=null) {
            fillViews(AnimeDetailViewModel.anime);
        }

    }


    public void fillViews(AnimeDetail animeDetail){
        String posterUrl = Api.BASE_URL + animeDetail.image.original;
        Picasso.get().load(posterUrl).into(animePoster);
        animeTitleRus.setText(animeDetail.russian);
        animeTitleJpn.setText(animeDetail.name);
        animeDescription.setText(animeDetail.description);
    }

    public void setAnimeId(int id,TurnPages turnPages){
        AnimeDetailViewModel.getDetailAnime(id,turnPages);
    }
//    public void setAnimeId(int id,TurnPages turnPages){
//        AnimeDetailViewModel.getDetailAnime().getAnimeApi().getDetailAnime(id).enqueue(new Callback<AnimeDetail>() {
//            @Override
//            public void onResponse(Call<AnimeDetail> call, Response<AnimeDetail> response) {
//                anime = response.body();
////                ((TurnPages)getActivity()).turnPage();
//                turnPages.turnPage();
//                AnimeObserver animeObserver = AnimeObserver.getInstance();
//                animeObserver.notifyObservers();
////                turnPages.turnPage();
//
//            }
//
//            @Override
//            public void onFailure(Call<AnimeDetail> call, Throwable t) {
//
//            }
//        });
//    }


}
