package com.example.a2340a_team10;

public class PlayerView {
    private static PlayerView player;
    private String playerName;
    private int health;
    private int speed;
    private int score;
    private float posX;
    private float posY;
    private int choice;

    private PlayerView(int speed, int score, float posX, float posY, String playerName,
                       int choice, int health) {
        this.speed = speed;
        this.score = score;
        this.posX = posX;
        this.posY = posY;
        this.playerName = playerName;
        this.choice = choice;
        this.health = health;
    }


    public static PlayerView initializePlayer(int speed, int score, float posX, float posY,
                                              String playerName, int choice, int health) {
        if (player == null) {
            player = new PlayerView(speed, score, posX, posY, playerName, choice, health);
        }
        return player;
    }

    public void draw(int choice) {
        //
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

    public float getName() {
        return speed;
    }

    public void setName(String newName) {
        playerName = newName;
    }

    public float getHealth() {
        return health;
    }

    public void setHealth(int newHealth) {
        health = newHealth;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(int newSpeed) {
        speed = newSpeed;
    }

    public float getScore() {
        return score;
    }

    public void setScore(int newScore) {
        score = newScore;
    }
}
