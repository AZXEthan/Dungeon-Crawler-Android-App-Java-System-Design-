package com.example.a2340a_team10.model;

public abstract class PowerUp implements CommonPowers {
    public enum Color {RED, YELLOW, BLUE, GREEN};
    protected Color color;
    protected int flaskImage;
    protected String function;
    protected int posX;
    protected int posY;
    protected Player hero = Player.getPlayer();

    public abstract void collectPowerUp();
}
