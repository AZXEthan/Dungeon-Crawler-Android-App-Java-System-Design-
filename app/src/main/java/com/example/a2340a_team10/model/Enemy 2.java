package com.example.a2340a_team10.model;

public abstract class Enemy {
    protected String enemyName;
    protected int enemyType;
    protected String difficulty;
    protected int damage;
    protected int health;
    protected int speed;
    protected int posX;
    protected int posY;

    public String getEnemyName() {
        return enemyName;
    }

    public void setEnemyName(String enemyName) {
        this.enemyName = enemyName;
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

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    public void updatePosition(int newX, int newY) {
        posX = newX;
        posY = newY;
    }

    //abstract public void attack();

    //abstract public boolean die();
}
