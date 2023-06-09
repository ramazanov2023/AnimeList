package com.example.animelist.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AnimeShort {

    public String getUrlPoster() {
        return "https://shikimori.one/system/animes/original/1.jpg?1674378220";
    }


    @SerializedName("id")
    @Expose
    public Integer id;
    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("russian")
    @Expose
    public String russian;
    @SerializedName("image")
    @Expose
    public Image image;
    @SerializedName("url")
    @Expose
    public String url;
    @SerializedName("kind")
    @Expose
    public String kind;
    @SerializedName("score")
    @Expose
    public String score;
    @SerializedName("status")
    @Expose
    public String status;
    @SerializedName("episodes")
    @Expose
    public Integer episodes;
    @SerializedName("episodes_aired")
    @Expose
    public Integer episodesAired;
    @SerializedName("aired_on")
    @Expose
    public String airedOn;
    @SerializedName("released_on")
    @Expose
    public String releasedOn;

    public class Image {

        @SerializedName("original")
        @Expose
        public String original;
        @SerializedName("preview")
        @Expose
        public String preview;
        @SerializedName("x96")
        @Expose
        public String x96;
        @SerializedName("x48")
        @Expose
        public String x48;
    }
}
