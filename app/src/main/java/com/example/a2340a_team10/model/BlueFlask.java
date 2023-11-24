package com.example.a2340a_team10.model;

import com.example.a2340a_team10.R;

public class BlueFlask extends PowerUp {
    public BlueFlask() {
        this.function = "Teleport";
    }

    @Override
    public void collectPowerUp() {
        System.out.println("Hero collected a blue flask and teleported to the gate.");
    }
}
