package com.example.a2340a_team10;
import androidx.test.core.app.ActivityScenario;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import com.example.a2340a_team10.model.Player;
import com.example.a2340a_team10.view.EndingScreen;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.*;

@RunWith(AndroidJUnit4.class)
public class PlayerResetTest{

    @Test
    public void playerIsResetAfterRestart(){
        ActivityScenario<EndingScreen> scenario = ActivityScenario.launch(EndingScreen.class);
        scenario.onActivity(activity -> activity.findViewById(R.id.restartButton).performClick());

        assertNull(Player.getPlayer().getName());
        assertEquals(0, Player.getPlayer().getHealth());
        assertEquals(0, Player.getPlayer().getCharacterChoice());
        assertNull(Player.getPlayer().getDifficulty());
    }
}
