package com.example.a2340a_team10;

import com.example.a2340a_team10.viewmodel.EnemyMove;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class EnemyMoveTest {

    private EnemyMove enemyMove;
    private int[] initialPosition;

    @Before
    public void setUp() {
        // Set the initial position of the enemy.
        initialPosition = new int[]{1000, 1000};
        enemyMove = new EnemyMove(initialPosition);
    }

    @Test
    public void testEnemyMoveWithinRange() {
        int[] newPosition = enemyMove.move();

        assertTrue("Enemy should move horizontally within range",
                newPosition[0] >= 20 && newPosition[0] <= 3000);
        assertTrue("Enemy should move vertically within range",
                newPosition[1] >= 20 && newPosition[1] <= 1200);
        assertTrue("Move count should decrease", enemyMove.getCount() < 6);
    }
}