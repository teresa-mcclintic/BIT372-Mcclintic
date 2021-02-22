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

    @Test
    public void can_enter_value_to_convert() {
        onView(withId(R.id.unit_input)).perform(typeText("77"));
        onView(withId(R.id.convert_btn)).perform(click());
        onView(withId(R.id.unit_text)).check(matches(withText("ºF is 25.0 ºC")));
    }
    @Test
    public void can_select_pounds_to_kilograms(){
        onView(withId(R.id.conversion_type)).perform(click());
        onView(withText("Pounds to Kilograms")).perform(click());
    }
    @Test
    public void can_select_fahrenheit_to_celsius(){
        onView(withId(R.id.conversion_type)).perform(click());
        onView(withText("Fahrenheit to Celsius")).perform(click());
    }
    @Test
    public void can_select_inches_to_centimeters(){
        onView(withId(R.id.conversion_type)).perform(click());
        onView(withText("Inches to Centimeters")).perform(click());
    }
    @Test
    public void can_select_quarts_to_liters(){
        onView(withId(R.id.conversion_type)).perform(click());
        onView(withText("Quarts to Liters")).perform(click());
    }
}