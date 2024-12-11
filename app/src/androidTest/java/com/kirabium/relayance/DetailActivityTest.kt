package com.kirabium.relayance

import android.content.Intent
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.kirabium.relayance.data.DummyData
import com.kirabium.relayance.extension.DateExt.Companion.toHumanDate
import com.kirabium.relayance.ui.activity.DetailActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class DetailActivityTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<DetailActivity>()

    @Test
    fun detailActivity_displaysCorrectCustomerInfo() {
        val customerId = 1 //Alice Wonderland
        val intent = Intent(
            ApplicationProvider.getApplicationContext(),
            DetailActivity::class.java
        ).apply {
            putExtra(DetailActivity.EXTRA_CUSTOMER_ID, customerId)
        }

        composeTestRule.activityRule.scenario.onActivity { activity ->
            activity.startActivity(intent)
        }
        val dummyData = DummyData
        val alice = dummyData.customers.find { it.id == customerId }!!

        // Vérifier que les informations sont bien affichées sur l'écran
        composeTestRule.onNodeWithText(alice.name).assertIsDisplayed() // Vérifie le nom
        composeTestRule.onNodeWithText(alice.email).assertIsDisplayed() // Vérifie l'email
        composeTestRule.onNodeWithText(
            composeTestRule.activity.getString(
                R.string.created_at,
                alice.createdAt.toHumanDate()
            )
        ).assertIsDisplayed() // Vérifie la date de création formatée
    }
}