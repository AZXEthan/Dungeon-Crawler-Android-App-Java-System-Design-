package com.example.a2340a_team10.model;

public class MoveUpAction implements KeyAction {
    @Override
    public int[] performAction(int posX, int posY) {
        int[] position = new int[2];
        posX -= 50;
        position[0] = posX;
        position[1] = posY;
        return position;
    }
}
