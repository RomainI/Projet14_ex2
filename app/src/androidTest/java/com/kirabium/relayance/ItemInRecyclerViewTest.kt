package com.kirabium.relayance

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.kirabium.relayance.ui.activity.MainActivity
import com.kirabium.relayance.util.RecyclerViewItemCountAssertion
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class ItemInRecyclerViewTest {

    @get:Rule
    val activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    //Check if the recycler view has exactly 5 items
    @Test
    fun testRecyclerViewItemCount() {
        onView(withId(R.id.customerRecyclerView)).check(
            RecyclerViewItemCountAssertion.withItemCount(
                5
            )
        )
    }
}