package com.example.a2340a_team10.model;

import com.example.a2340a_team10.R;

public class YellowFlask extends PowerUp {
    public YellowFlask() {
        this.function = "Temporary immortality";
    }

    @Override
    public void collectPowerUp() {
        System.out.println("Hero collected a red flask and gained temporary immortality.");
    }
}
