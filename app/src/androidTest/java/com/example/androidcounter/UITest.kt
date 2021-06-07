package com.example.androidcounter

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class UITest {

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Before
    fun resetCounter() {
        onView(withId(R.id.reset_button)).perform(click())
    }

    @Test
    fun testIncrement() {
        onView(withId(R.id.counter_value)).check(matches(withText("0")))
        onView(withId(R.id.increment_button)).perform(click())
        onView(withId(R.id.counter_value)).check(matches(withText("1")))
    }

    @Test
    fun testReset() {
        onView(withId(R.id.increment_button)).perform(click())
        onView(withId(R.id.counter_value)).check(matches(withText("1")))
        onView(withId(R.id.reset_button)).perform(click())
        onView(withId(R.id.counter_value)).check(matches(withText("0")))
    }

}