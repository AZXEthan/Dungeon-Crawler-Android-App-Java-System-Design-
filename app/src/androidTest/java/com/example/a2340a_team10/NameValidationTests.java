package com.example.a2340a_team10;
import androidx.test.core.app.ActivityScenario;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import com.example.a2340a_team10.view.InitialConfiguration;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
public class NameValidationTests{

    @Before
    public void setUp() {
        ActivityScenario.launch(InitialConfiguration.class);
    }

    @Test
    public void testBlankOrNullName(){
        onView(withId(R.id.inputName)).perform(typeText(""), closeSoftKeyboard());
        onView(withId(R.id.buttonSubmit)).perform(click());
        onView(withId(R.id.greeting)).check(matches(withText("Invalid name.")));
    }

    @Test
    public void testNameWithOnlyWhitespace(){
        onView(withId(R.id.inputName)).perform(typeText("     "), closeSoftKeyboard());
        onView(withId(R.id.buttonSubmit)).perform(click());
        onView(withId(R.id.greeting)).check(matches(withText("Invalid name.")));
    }
}

