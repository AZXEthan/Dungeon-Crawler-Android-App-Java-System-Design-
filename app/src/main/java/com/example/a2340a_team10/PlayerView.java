package com.example.a2340a_team10;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.widget.ImageView;

public class PlayerView extends AppCompatActivity{
    private static PlayerView player;
    private String playerName;
    private int health;
    private int speed;
    private int score;
    private float posX;
    private float posY;

    private int choice;

    private PlayerView(int speed, int score, float posX, float posY) {
        this.speed = speed;
        this.score = score;
        this.posX = posX;
        this.posY = posY;
        this.playerName = getIntent().getStringExtra("playerName");
        this.health = getIntent().getIntExtra("startingHealth", 0);
        this.choice = getIntent().getIntExtra("characterChoice", 1);
    }


    public static PlayerView getPlayer() {
        if (player == null) {
            player = new PlayerView(0, 0, 0, 0);
        }
        return player;
    }

    public void draw(int choices) {
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
