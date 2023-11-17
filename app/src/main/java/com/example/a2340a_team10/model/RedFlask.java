package com.example.a2340a_team10.model;

import com.example.a2340a_team10.R;

public class RedFlask extends PowerUp {
    public RedFlask() {
        this.function = "Recover HP";
    }

    @Override
    public void collectPowerUp() {
        System.out.println("Hero collected a red flask and recovered 1 HP.");
    }
}
