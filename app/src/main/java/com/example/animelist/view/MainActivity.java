package com.example.animelist.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;

import com.example.animelist.R;
import com.example.animelist.model.repository.AnimeObserver;
import com.example.animelist.view.adapter.AnimeListAdapter;
import com.example.animelist.view.adapter.PagesAdapter;
import com.example.animelist.view.pages.AnimeDetailFragment;
import com.example.animelist.view.pages.AnimeListsFragment;
import com.example.animelist.view.pages.UserAnimeListsFragment;
import com.example.animelist.viewmodel.AnimeDetailViewModel;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AnimeListAdapter.MovePages,TurnPages{
    ViewPager2 viewPager2;
    TabLayout tabLayout;
    List<Fragment> pages;
    String[] pagesNames;
    PagesAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        setNoFrameMode();

        viewPager2 = findViewById(R.id.main_activity_view_pager2);
        tabLayout = findViewById(R.id.main_activity_tab_layout);
        pagesNames = getResources().getStringArray(R.array.pages_names);

        pages = new ArrayList<>();
        pages.add(0, new AnimeListsFragment());
        pages.add(1, new AnimeDetailFragment());
        pages.add(2, new UserAnimeListsFragment());

        adapter = new PagesAdapter(getSupportFragmentManager(), getLifecycle(), pages);
        viewPager2.setAdapter(adapter);

        new TabLayoutMediator(tabLayout, viewPager2, true, true, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                tab.setText(pagesNames[position]);
            }
        }).attach();

    }

    public void setNoFrameMode() {
        Window window = getWindow();
        window.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
    }

    @Override
    public void setPage(int id) {
//        getSharedPreferences("anime",MODE_PRIVATE).edit().putInt("animeId",id).apply();
//        AnimeDetailFragment animeDetail = (AnimeDetailFragment) pages.get(1);
        AnimeListsFragment animeList = (AnimeListsFragment) pages.get(0);
        AnimeObserver.getInstance().unRegisterObservers(animeList);
//        animeDetail.setAnimeId(id,this);
//        AnimeObserver.getInstance().notifyObservers();
        Log.e("observer", "1 setPage(int id) " + id);
        AnimeDetailViewModel.getDetailAnime(id,this);
    }

    @Override
    public void turnPage() {

        viewPager2.setCurrentItem(1);
        Log.e("observer", "VALUE setCurrentItem(1) " + AnimeObserver.getInstance().countObservers());
        AnimeObserver animeObserver = AnimeObserver.getInstance();
        animeObserver.notifyObservers();
    }
}