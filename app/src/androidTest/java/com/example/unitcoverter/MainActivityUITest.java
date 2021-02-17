package com.example.unitcoverter;

import android.content.Context;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.*;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.*;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class MainActivityUITest {
    @Rule
    public ActivityScenarioRule<MainActivity> activityRule =
            new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void useAppContext() {

        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        assertEquals("com.example.unitcoverter", appContext.getPackageName());
    }
    //@Test
    /*public void canEnterPounds() {
        onView(withId(R.id.pounds_input2)).perform(typeText("10"));
        onView(withId(R.id.convert_btn2)).perform(click());
        onView(withId(R.id.kilo_text2)).check(matches(withText("4.54 kg")));
    }*/

    @Test
    public void can_enter_fahrenheit() {
        onView(withId(R.id.unit_input)).perform(typeText("77"));
        onView(withId(R.id.convert_btn)).perform(click());
        onView(withId(R.id.unit_text)).check(matches(withText("25.00 ºC")));

    }
}