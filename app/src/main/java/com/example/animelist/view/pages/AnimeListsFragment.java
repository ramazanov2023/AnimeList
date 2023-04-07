package com.example.animelist.view.pages;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.animelist.R;
import com.example.animelist.data.AnimeShort;
import com.example.animelist.view.adapter.AnimeListAdapter;

import java.util.ArrayList;

public class AnimeListsFragment extends Fragment {
    RecyclerView recycler;
    RecyclerView recycler1;
    RecyclerView recycler2;
    ArrayList<AnimeShort> list;
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

        list = new ArrayList<>();
        for(int i = 0; i <30; i++){
            list.add(new AnimeShort());
        }
        AnimeListAdapter adapter = new AnimeListAdapter(getContext(),list);
        recycler.setLayoutManager(new GridLayoutManager(getContext(),2,GridLayoutManager.HORIZONTAL,false));
        recycler.setAdapter(adapter);

        AnimeListAdapter adapter1 = new AnimeListAdapter(getContext(),list);
        recycler1.setLayoutManager(new GridLayoutManager(getContext(),2,GridLayoutManager.HORIZONTAL,false));
        recycler1.setAdapter(adapter1);

        AnimeListAdapter adapter2 = new AnimeListAdapter(getContext(),list);
        recycler2.setLayoutManager(new GridLayoutManager(getContext(),2,GridLayoutManager.HORIZONTAL,false));
        recycler2.setAdapter(adapter2);
    }
}
