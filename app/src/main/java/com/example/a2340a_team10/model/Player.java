package com.example.a2340a_team10.model;

public class Player {
    private static Player hero;
    private String playerName;
    private String difficulty;
    private int health;
    private int speed;
    private int score;
    private float posX;
    private float posY;
    private int characterChoice;

//    private Player(String playerName, String difficulty, int characterChoice) {
//        this.playerName = playerName;
//        this.difficulty = difficulty;
//        this.characterChoice = characterChoice;
//    }

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

    public void updatePosition(float newX, float newY) {
        posX = newX;
        posY = newY;
    }

    public float getPosX() {
        return posX;
    }

    public float getPosY() {
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

    public void resetScore(){
        this.score = 300;
    }
}
