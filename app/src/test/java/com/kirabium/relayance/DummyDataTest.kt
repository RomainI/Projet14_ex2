package com.kirabium.relayance

import com.kirabium.relayance.data.DummyData
import junit.framework.TestCase.assertEquals
import org.junit.Test
import java.util.Calendar


class DummyDataTest {

    @Test
    fun generateDateTest(){

        // Arrange
        val calendar = Calendar.getInstance()
        calendar.add(Calendar.MONTH, -3)
        val expectedDate = calendar.time
        val dummyData = DummyData
        // Act
        val testDate = dummyData.generateDate(3)

        // Assert
        val testCalendar = Calendar.getInstance()
        testCalendar.time = testDate

        val expectedCalendar = Calendar.getInstance()
        expectedCalendar.time = expectedDate

        // Validate year, month, and day
        assertEquals(expectedCalendar.get(Calendar.YEAR), testCalendar.get(Calendar.YEAR))
        assertEquals(expectedCalendar.get(Calendar.MONTH), testCalendar.get(Calendar.MONTH))
        assertEquals(expectedCalendar.get(Calendar.DAY_OF_MONTH), testCalendar.get(Calendar.DAY_OF_MONTH))
    }

}