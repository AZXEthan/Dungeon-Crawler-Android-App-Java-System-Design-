package com.example.a2340a_team10.model;

public class MoveDownAction implements KeyAction {
    @Override
    public int[] performAction(int posX, int posY) {
        int[] position = new int[2];
        posY += 30;
        position[0] = posX;
        position[1] = posY;
        return position;
    }
}
