package com.example.a2340a_team10;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.assertion.ViewAssertions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.example.a2340a_team10.model.Player;
import com.example.a2340a_team10.view.InitialConfiguration;

import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StartingHealthTest {

    @Rule
    public ActivityScenarioRule<InitialConfiguration> activityScenarioRule =
            new ActivityScenarioRule<>(InitialConfiguration.class);

    @Test
    public void testPlayerStartingHealth() {
        // Easy
        Espresso.onView(ViewMatchers.withId(R.id.radioEasy)).perform(ViewActions.click());
        assertEquals(5, Player.getPlayer().getHealth());

        // Medium
        Espresso.onView(ViewMatchers.withId(R.id.radioMedium)).perform(ViewActions.click());
        assertEquals(4, Player.getPlayer().getHealth());

        // Hard
        Espresso.onView(ViewMatchers.withId(R.id.radioHard)).perform(ViewActions.click());
        assertEquals(3, Player.getPlayer().getHealth());
    }
}
