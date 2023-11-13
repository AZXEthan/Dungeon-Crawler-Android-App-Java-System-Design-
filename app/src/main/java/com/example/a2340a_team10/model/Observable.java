package com.example.a2340a_team10.model;

import java.util.ArrayList;

public interface Observable {
    ArrayList<Observer> observers = new ArrayList<>();

    default void addObserver(Observer observer) {
        observers.add(observer);
    }
    default void removeObserver(Observer observer) {
        observers.remove(observer);
    }
}
