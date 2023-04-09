package com.example.animelist.view.pages;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.animelist.R;
import com.example.animelist.data.AnimeShort;
import com.example.animelist.model.repository.AnimeObserver;
import com.example.animelist.model.repository.Observer;
import com.example.animelist.view.adapter.AnimeListAdapter;
import com.example.animelist.viewmodel.AnimeListsViewModel;

import java.util.ArrayList;
import java.util.List;

public class AnimeListsFragment extends Fragment implements Observer {
    RecyclerView recycler;
    RecyclerView recycler1;
    RecyclerView recycler2;
//    List<AnimeShort> list;
//    List<AnimeShort> list1;
//    List<AnimeShort> list2;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_anime_list,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        recycler = view.findViewById(R.id.anime_list_recycler_view);
        recycler1 = view.findViewById(R.id.anime_list_recycler_view1);
        recycler2 = view.findViewById(R.id.anime_list_recycler_view2);

//        list = new ArrayList<>();
//        for(int i = 0; i <30; i++){
//            list.add(new AnimeShort());
//        }

        AnimeObserver animeObserver = AnimeObserver.getInstance();
        animeObserver.registerObservers(this);

        AnimeListsViewModel.getOngoingAnime();
        AnimeListsViewModel.getAnonsAnime();
        AnimeListsViewModel.getReleasedAnime();



//        AnimeListAdapter adapter = new AnimeListAdapter(getContext(),list);
//        recycler.setLayoutManager(new GridLayoutManager(getContext(),2,GridLayoutManager.HORIZONTAL,false));
//        recycler.setAdapter(adapter);

//        AnimeListAdapter adapter1 = new AnimeListAdapter(getContext(),list1);
//        recycler1.setLayoutManager(new GridLayoutManager(getContext(),2,GridLayoutManager.HORIZONTAL,false));
//        recycler1.setAdapter(adapter1);
//
//        AnimeListAdapter adapter2 = new AnimeListAdapter(getContext(),list2);
//        recycler2.setLayoutManager(new GridLayoutManager(getContext(),2,GridLayoutManager.HORIZONTAL,false));
//        recycler2.setAdapter(adapter2);
    }

    @Override
    public void update() {
        if(AnimeListsViewModel.list!=null) {
            recycler.setLayoutManager(new GridLayoutManager(getContext(), 2, GridLayoutManager.HORIZONTAL, false));
            Log.e("listnull", "setAdapter - " + AnimeListsViewModel.list);
            recycler.setAdapter(new AnimeListAdapter(getContext(), AnimeListsViewModel.list));
        }

        if(AnimeListsViewModel.list1!=null) {
            recycler1.setLayoutManager(new GridLayoutManager(getContext(), 2, GridLayoutManager.HORIZONTAL, false));
            Log.e("listnull", "setAdapter1 - " + AnimeListsViewModel.list1);
            recycler1.setAdapter(new AnimeListAdapter(getContext(), AnimeListsViewModel.list1));
        }

        if(AnimeListsViewModel.list2!=null) {
            recycler2.setLayoutManager(new GridLayoutManager(getContext(), 2, GridLayoutManager.HORIZONTAL, false));
            Log.e("listnull", "setAdapter2 - " + AnimeListsViewModel.list2);
            recycler2.setAdapter(new AnimeListAdapter(getContext(), AnimeListsViewModel.list2));
        }
//        Log.e("listnull","setAdapter - " + list);
    }
}
