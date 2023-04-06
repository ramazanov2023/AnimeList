package com.example.animelist.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.example.animelist.R;
import com.example.animelist.view.adapter.PagesAdapter;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ViewPager2 viewPager2;
    TabLayout tabLayout;
    List<Fragment> pages;
    String[] pagesNames;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager2 = findViewById(R.id.main_activity_view_pager2);
        tabLayout = findViewById(R.id.main_activity_tab_layout);
        pagesNames = getResources().getStringArray(R.array.pages_names);

        pages = new ArrayList<>();
        pages.add(0, new AnimeListsFragment());
        pages.add(1, new AnimeDetailFragment());
        pages.add(2, new UserAnimeListsFragment());

        PagesAdapter adapter = new PagesAdapter(getSupportFragmentManager(), getLifecycle(), pages);
        viewPager2.setAdapter(adapter);

        new TabLayoutMediator(tabLayout, viewPager2, true, true, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                tab.setText(pagesNames[position]);
            }
        }).attach();

    }
}