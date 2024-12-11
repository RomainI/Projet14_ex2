package com.kirabium.relayance

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent
import androidx.test.espresso.intent.matcher.IntentMatchers.hasExtra
import androidx.test.espresso.matcher.ViewMatchers.withId
import com.kirabium.relayance.ui.activity.DetailActivity
import org.hamcrest.core.AllOf.allOf
import org.junit.Test
import androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.kirabium.relayance.ui.activity.MainActivity
import org.junit.Rule
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class VerifyCorrectIntentAfterItemClickTest {

    @get:Rule
    val activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)
    @Test
    fun testIntentAfterItemClick() {
        Intents.init()

        onView(withId(R.id.customerRecyclerView)).perform(actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))

        Intents.intended(
            allOf(
                hasComponent(DetailActivity::class.java.name),
                hasExtra(DetailActivity.EXTRA_CUSTOMER_ID, 1)
            )
        )

        Intents.release()
    }
}