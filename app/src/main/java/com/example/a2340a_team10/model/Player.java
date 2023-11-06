package com.example.a2340a_team10.model;
//import com.example.a2340a_team10.model.Observer;
import java.util.ArrayList;
import java.util.List;

public class Player {
    private static Player hero;
    private String playerName;
    private String difficulty;
    private int health;
    private int speed;
    private int score;
    private int posX;
    private int posY;
    private int characterChoice;
    private List<Observer> observers = new ArrayList<>();

    private Player() {
        this.score = 300;
        this.posX = 0;
        this.posY = 0;
    }

    public static Player getPlayer() {
        if (hero == null) {
            hero = new Player();
        }
        return hero;
    }

    public static void clear() {
        hero = null;
    }

    public void updatePosition(int newX, int newY) {
        this.posX = newX;
        this.posY = newY;
        notifyAllObservers();
    }
    public void attach(Observer observer) {
        observers.add(observer);
    }

    private void notifyAllObservers() {
        for (Observer observer : observers) {
            observer.onPlayerMove(this.posX, this.posY);
        }
    }
    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    public String getName() {
        return playerName;
    }

    public void setName(String name) {
        playerName = name;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getCharacterChoice() {
        return characterChoice;
    }

    public void setCharacterChoice(int choice) {
        this.characterChoice = choice;
    }

    public void resetScore() {
        this.score = 300;
    }

    public int getDifficultyMultiplier() {
        switch (this.difficulty) {
            case "Easy":
                return 1;
            case "Medium":
                return 2;
            case "Hard":
                return 3;
            default:
                return 0;
        }
    }
}
