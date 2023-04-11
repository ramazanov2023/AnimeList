package com.example.animelist.model.repository;

import java.util.ArrayList;
import java.util.List;

public class AnimeObserver {
    static ArrayList<Observer> observers;
    static AnimeObserver animeObserver;

    public AnimeObserver() {

        observers = new ArrayList<>();
    }

    public static AnimeObserver getInstance(){
        if(animeObserver==null){
            animeObserver = new AnimeObserver();
        }
        return animeObserver;
    }

    public void registerObservers(Observer observer){

        observers.add(observer);
    }

    public void unRegisterObservers(Observer observer){

        observers.remove(observer);
    }

    public int countObservers(){
        return observers.size();
    }

    public void notifyObservers(){
        for(int i = 0; i < observers.size(); i++){
            observers.get(i).update();
        }
    }

}
