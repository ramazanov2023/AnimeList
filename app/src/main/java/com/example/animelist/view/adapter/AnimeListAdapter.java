package com.example.animelist.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.animelist.R;
import com.example.animelist.data.AnimeShort;
import com.example.animelist.model.api.Api;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class AnimeListAdapter extends RecyclerView.Adapter<AnimeListAdapter.Holder> {
    Context context;
    List<AnimeShort> list;

    public AnimeListAdapter(Context context, List<AnimeShort> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.anime_list_sample_view,parent,false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        AnimeShort anime = list.get(position);
        String urlPoster = Api.BASE_URL + anime.image.original;
        holder.number.setText(String.valueOf(position));
        Picasso.get().load(urlPoster).into(holder.poster);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class Holder extends RecyclerView.ViewHolder {
        ImageView poster;
        TextView number;
        public Holder(@NonNull View itemView) {
            super(itemView);
            poster = itemView.findViewById(R.id.sample_view);
            number = itemView.findViewById(R.id.number);
        }
    }
}
