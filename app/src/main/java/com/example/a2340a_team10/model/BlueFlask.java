package com.example.a2340a_team10.model;

import com.example.a2340a_team10.R;

public class BlueFlask extends PowerUp {
    public BlueFlask() {
        this.function = "Speed boost";
    }

    @Override
    public void collectPowerUp() {
        System.out.println("Hero collected a red flask and gained speed boost.");
    }
}
