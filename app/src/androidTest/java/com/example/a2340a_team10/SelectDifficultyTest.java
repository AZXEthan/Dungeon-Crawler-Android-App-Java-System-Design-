package com.example.a2340a_team10;

import android.widget.Button;
import android.widget.RadioButton;
import androidx.test.core.app.ActivityScenario;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import com.example.a2340a_team10.view.InitialConfiguration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.isNotEnabled;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isEnabled;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(AndroidJUnit4.class)
public class SelectDifficultyTest {

    private ActivityScenario<InitialConfiguration> activityScenario;

    @Before
    public void setUp() {
        // Launch the InitialConfiguration activity using ActivityScenario
        activityScenario = ActivityScenario.launch(InitialConfiguration.class);
    }

    @After
    public void tearDown() {
        // Close the activity after each test
        activityScenario.close();
    }

    @Test
    public void testStartButtonEnabledAfterRadioButtonSelection() {
        // Check that the Start button is initially disabled
        //onView(withId(R.id.startButton)).check(matches(isNotEnabled()));

        // Simulate a click on the "Easy" radio button
        onView(withId(R.id.radioEasy)).perform(click());

        // After the click, the Start button should be enabled
        onView(withId(R.id.startButton)).check(matches(isEnabled()));
    }

    @Test
    public void testStartButtonEnabledBeforeRadioButtonSelection() {
        onView(withId(R.id.startButton)).check(matches(not(isNotEnabled())));
    }
}
