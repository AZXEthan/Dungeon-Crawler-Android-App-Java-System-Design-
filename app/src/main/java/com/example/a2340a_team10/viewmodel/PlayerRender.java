package com.example.a2340a_team10.viewmodel;

import com.example.a2340a_team10.model.Observer;
import com.example.a2340a_team10.model.Player;

public class PlayerRender implements Observer {
    private Player player;

    public void playerRenderer(Player player) {
        this.player = player;
        player.attach(this);
    }

    @Override
    public void update() {
        // render the player's current position
        System.out.println("Player is at: (" + Player.getPlayer().getPosX() + ", "
                + Player.getPlayer().getPosY() + ")");
    }
}
