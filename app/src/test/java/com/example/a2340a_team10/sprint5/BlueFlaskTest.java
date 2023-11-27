package com.example.a2340a_team10.sprint5;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class BlueFlaskTest {

    public boolean collectPowerUp(int x, int y) {
        return 2190 <= x && x <= 2250 && 630 <= y && y <= 740;
    }

    @Test
    public void redF(){
        int x=100000;
        int y=100000;
        assertEquals(collectPowerUp(x,y),false);
    }
}
