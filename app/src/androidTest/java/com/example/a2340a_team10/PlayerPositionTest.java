package com.example.a2340a_team10;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import com.example.a2340a_team10.model.Player;

public class PlayerPositionTest {

    private Player player;

    @Before
    public void setUp() {
        player = Player.getPlayer();
    }

    @Test
    public void testUpdatePosition() {

        float expectedPosX = 4.0f;
        float expectedPosY = 4.0f;

        player.updatePosition(expectedPosX, expectedPosY);

        assertEquals(expectedPosX, player.getPosX(), 0.00);
        assertEquals(expectedPosY, player.getPosY(), 0.00);
    }
}
