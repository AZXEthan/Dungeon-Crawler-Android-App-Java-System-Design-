package com.example.a2340a_team10.model;

public abstract class Enemy implements Observer {
    protected String enemyName;
    protected int enemyType;
    protected String difficulty;
    protected int damage;
    protected int health;
    protected int speed;
    protected int posX;
    protected int posY;

    public Enemy() {
        this.damage = 1;
        this.posX = 1000;
        this.posY = 1000;
    }

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
        this.posX = newX;
        this.posY = newY;
    }

    @Override
    public void update(int playerX, int playerY) {
        onPlayerMove(playerX, playerY);
    }

    public void onPlayerMove(int playerX, int playerY) {
        if (checkCollision(playerX, playerY)) {
            Player player = Player.getPlayer();
            int multiplier = player.getDifficultyMultiplier();
            player.setHealth(player.getHealth() - this.damage * multiplier);
            if (player.getHealth() < 0) {
                player.setHealth(0);
            }
        }
    }

    private boolean checkCollision(int playerX, int playerY) {
        int threshold = 60;
        int dX = playerX - this.posX;
        int dY = playerY - this.posY;
        int distanceSquared = dX * dX + dY * dY;

        return distanceSquared < threshold * threshold;
    }

    //abstract public void attack();

    //abstract public boolean die();
}
